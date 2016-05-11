package com.qa.smurf.service;

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
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getUsersPendingOrder(oa);
		if (order != null) {
			boolean foundLineItem = false;
			for (LineItems li : order.getLineItem()) {
				if (!foundLineItem) {
					if (li.getProduct().getId() == productId) {
						li.setQuantity(li.getQuantity() + 1);
						lineItemsRepository.persistLineItems(li);
						foundLineItem = true;
					}
				}
			}
			if (!foundLineItem) {
				LineItems li = new LineItems(order, product, 1, product.getPrice(), product.getQuantityAvailable());
				List<LineItems> lia = order.getLineItem();
				lineItemsRepository.persistLineItems(li);
				lia.add(li);
				order.setLineItem(lia);
				orderRepository.persistOrder(order);
			}

		} else {

			order = new Order(123, new Date(), null, paymentRepository.findByUserId(userId),
					userRepository.findByID(userId).getAddress(), userRepository.findByID(userId), null);
			order.setOrderStatus(OrderStatus.PENDING);
			LineItems li = new LineItems(order, product, 1, product.getPrice(), product.getQuantityAvailable());
			lineItemsRepository.persistLineItems(li);
			order.addLineItem(li);
			orderRepository.persistOrder(order);
		}
	}

	private Order getUsersPendingOrder(List<Order> oa) {
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

			order = new Order(123, new Date(), null, paymentRepository.findByUserId(userId),
					userRepository.findByID(userId).getAddress(), userRepository.findByID(userId), null);

			orderRepository.persistOrder(order);
		}

	}

	public void clearBasket(long userId) {
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getUsersPendingOrder(oa);
		if (order != null) {
			for (LineItems li : order.getLineItem()) {
				if (li != null) {
					List<LineItems> lia = order.getLineItem();
					lia.remove(li);
					order.setLineItem(lia);
					lineItemsRepository.removeLineItem(li);
					orderRepository.persistOrder(order);
				}
			}
			orderRepository.removeOrder(order);
		}

	}

	public Order getUsersPendingOrder(long userId) {
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getUsersPendingOrder(oa);
		return order;
	}

	public float calcOrderTotalPending(long userId) {
		float total = 0;
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getUsersPendingOrder(oa);
		if (order != null) {
			if(order.getLineItem()!=null){
				for (LineItems li : order.getLineItem()) {
					total = (float) li.getSubtotal();
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
			order.setOrderStatus(OrderStatus.PLACED);
			orderRepository.updateOrder(order);
			orderRepository.persistOrder(order);
		}

	}

	public void removeFromBasket(long productId, long userId) {
		List<Order> oa = orderRepository.findByUser(userRepository.findByID(userId));
		Order order = getUsersPendingOrder(oa);
		if (order != null) {
			for (LineItems li : order.getLineItem()) {
				if (li.getProduct().getId() == productId) {
					List<LineItems> lia = order.getLineItem();
					int index = getLineItem(lia, li);
					lia.remove(index);
					order.setLineItem(lia);
					lineItemsRepository.removeLineItem(li);
					return;
				}
			}
			return;
		}
	}

	private int getLineItem(List<LineItems> lia, LineItems li) {
		int index = 0;
		for (LineItems check : lia) {
			if (check.getProduct().getId() == li.getProduct().getId()) {
				return index;
			} else {
				index = index + 1;
			}
		}
		return 0;
	}

	public List<LineItems> getLineItems(Order order, long userId) {
		return order.getLineItem();
	}
}
