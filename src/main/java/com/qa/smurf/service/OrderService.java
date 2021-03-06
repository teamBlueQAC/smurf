package com.qa.smurf.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.LineItemsRepository;
import com.qa.smurf.repositories.OrderRepository;
import com.qa.smurf.repositories.PaymentRepository;
import com.qa.smurf.repositories.ProductRepository;
import com.qa.smurf.repositories.UserRepository;
import com.qa.smurf.util.OrderStatus;

@Stateless
public class OrderService {
	@Inject
	private ProductRepository productRepository;
	@Inject
	private LineItemsRepository lineItemsRepository;
	@Inject
	private PaymentRepository paymentRepository;
	@Inject
	private OrderRepository orderRepository;
	@Inject
	private UserRepository userRepository;

	public User getCurrentUser(long userId) {
		return userRepository.findByID(userId);
	}

	public void addToBasket(long productId, long userId) {
		Product product = productRepository.findByID(productId);
		List<Order> orders = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getPendingOrders(orders);		
		
		if (order != null) {
			LineItems foundLineItem = lineItemsRepository.findByCompositeKey(order, productRepository.findByID(productId));

			if (foundLineItem == null){			
				newLineItem(order, product);
				orderRepository.updateOrder(order);
			}
			else{
				updateLineQuantity(foundLineItem, order, 1);
			}
		} else {
			newOrder(product, userId);
		}

	}

	private LineItems updateLineQuantity(LineItems lineItem, Order order, int diff){
		lineItem.setQuantity(lineItem.getQuantity() + diff);
		lineItemsRepository.updateLineItem(lineItem);
		lineItem.setSubtotal(lineItem.getProduct().getPrice()*lineItem.getQuantity());
		lineItemsRepository.updateLineItem(lineItem);
		Double total = calculateOrderTotal(order);
		order.setTotal(total);
		return lineItem;
	}

	private LineItems newLineItem(Order order, Product product){
		LineItems newLineItem = new LineItems(order, product, 1, product.getPrice(), 0);
		lineItemsRepository.persistLineItem(newLineItem);
		List<LineItems> lineItems = order.getLineItem();

		if (lineItems == null){
			lineItems = new ArrayList<LineItems>();
		}
		lineItems.add(newLineItem);
		order.setLineItem(lineItems);
		Double total = calculateOrderTotal(order);
		order.setTotal(total);
		return newLineItem;
	}
	
	public Double calculateOrderTotal(Order order) {
		Double total = 0.0;
		for(LineItems l : order.getLineItem()){
			total = total + (l.getProduct().getPrice())*(l.getQuantity());
		}
		return total;
	}

	private void newOrder(Product product, long userId){
		Order order = new Order(getNewOrderId(), 0, new Date(), null, paymentRepository.findByUserID(userId),
				userRepository.findByID(userId).getAddress(), userRepository.findByID(userId), OrderStatus.PENDING);
		orderRepository.persistOrder(order);
		newLineItem(order, product);

	}
	
	private long getNewOrderId(){
		return orderRepository.getOrders().size();
	}

	private Order getPendingOrders(List<Order> oa) {
		for (Order o : oa) {
			if (o.getOrderStatus() == OrderStatus.PENDING) {
				return o;
			}
		}
		return null;
	}

	public void updateQuantity(Order order, long userId) {
		if (order != null) {
			orderRepository.updateOrder(order);
		} else {

			order = new Order(getNewOrderId(), 123, new Date(), null, paymentRepository.findByUserID(userId), //TODO why is total 123?
					userRepository.findByID(userId).getAddress(), userRepository.findByID(userId), null);

			orderRepository.persistOrder(order);
		}

	}

	public void clearBasket(long userId) {
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getPendingOrders(oa);
		if (order != null) {
			while(!order.getLineItem().isEmpty()){
				removeFromBasket(order.getLineItem().get(0).getProduct().getId(), userId);
			}
			orderRepository.removeOrder(order);
		}

	}

	public Order getUsersPendingOrder(long userId) {
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getPendingOrders(oa);
		return order;
	}

	public Double calcOrderTotalPending(long userId) {
		double total = 0;
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getPendingOrders(oa);
		if (order != null) {
			if(order.getLineItem()!=null){
				for (LineItems li : order.getLineItem()) {
					total += (li.getProduct().getPrice())*(li.getQuantity());
				}
			}
		}
		return total;
	}

	public void placeOrder(Order order, long userId) {
		if (order != null) {
			for (LineItems li : order.getLineItem()) {
				long productId = li.getProduct().getId();
				Product p = productRepository.findByID(productId);
				int available = li.getProduct().getQuantityAvailable();
				int liQuantity = li.getQuantity();
				if (liQuantity <= available) {
					p.setQuantityAvailable(available - liQuantity);
				}
			}
			order.setOrderStatus(OrderStatus.PLACED);//TODO
			orderRepository.updateOrder(order);
		}
	}

	public void removeFromBasket(long productId, long userId) {
		System.out.println("removeFromBasket");
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getPendingOrders(oa);
		if (order != null) {
			for (LineItems li : order.getLineItem()) {
				if (li.getProduct().getId() == productId) {
					List<LineItems> lia = order.getLineItem();
					lia.remove(li);
					order.setLineItem(lia);
					lineItemsRepository.removeLineItem(li);
					return;
				}
			}
			return;
		}
	}

	public List<LineItems> getLineItems(Order order, long userId) {
		return order.getLineItem();
	}

	public List<Order> getPaidOrders(long userId) {
		List<Order> orders = findPaidOrders(orderRepository.findByUser(userRepository.findByID(userId)));
		return orders;
	}

	private List<Order> findPaidOrders(ArrayList<Order> orders) {
		List<Order> foundOrders = new ArrayList<Order>();
		for(Order o : orders){
			if(o.getOrderStatus()!=OrderStatus.PENDING&&o.getOrderStatus()!=OrderStatus.PLACED){
				foundOrders.add(o);
			}
		}
		if(!foundOrders.isEmpty()){
			return foundOrders;
		} else {
			return null;
		}
	}

	public void deductFromBasket(long productId, long userId) {
		List<Order> orders = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getPendingOrders(orders);		
		
		if (order != null) {
			LineItems foundLineItem = lineItemsRepository.findByCompositeKey(order, productRepository.findByID(productId));

			if (foundLineItem != null){			
				updateLineQuantity(foundLineItem, order, -1);
				if(foundLineItem.getQuantity() < 1){
					removeFromBasket(productId, userId);
				}
			}
		}

	}
}
