package com.qa.smurf.service;

import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import com.qa.smurf.entities.Address;
import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.AddressRepository;
import com.qa.smurf.repositories.OrderRepository;
import com.qa.smurf.repositories.OrderStatusRepository;
import com.qa.smurf.repositories.PaymentRepository;
import com.qa.smurf.repositories.ProductRepository;
import com.qa.smurf.repositories.UserRepository;
import com.qa.smurf.util.OrderStatus;

public class OrderService {

	@Inject
	ProductRepository productRepository;
	
	@Inject
	AddressRepository addressRepository;
	
	@Inject
	PaymentRepository paymentRepository;

	@Inject
	OrderRepository orderRepository;

	@Inject
	OrderStatusRepository orderStatusRepository;

	@Inject
	UserRepository userRepository;

	public User getCurrentUser(long userId) {
		return userRepository.findByID(userId);
	}

	public void addToBasket(long productId, long userId) {
		Product product = productRepository.findByID(productId);
		Order order = orderRepository.getBasketOrder(userId);
		if (order != null) {
			boolean foundLineItem = false;
			for (LineItems li : order.getLineItem()) {
				if (!foundLineItem) {
					if (li.getProduct().getId() == productId) {
						li.setQuantity(li.getQuantity() + 1);
						foundLineItem = true;
					}
				}
			}
			if(!foundLineItem){
				LineItems li = new LineItems(order, product, 1, product.getPrice(), product.getQuantityAvailable());
				ArrayList<LineItems> lia = order.getLineItem();
				lia.add(li);
				order.setLineItem(lia);
			}

		} else {
			order = new Order(123, new Date(), null, paymentRepository.findByUserId(userId),
					addressRepository.findByUserId(userId), userRepository.findByID(userId), null);
		}

	}

	public void updateQuantity(Order order, long userId) {
		if(order!=null){
			orderRepository.updateOrder(order);
		} else {
			order = new Order(123, new Date(), null, paymentRepository.findByUserId(userId),
					addressRepository.findByUserId(userId), userRepository.findByID(userId), null);
		}

	}

	public void clearBasket(long userId) {
		Order order = orderRepository.getUsersPendingOrder(userId);
		if (order != null) {
			for (LineItems li : order.getOrderLineItems()) {
				if (li != null) {
					order.removeLineItem(li);
				}
			}
			orderRepository.removeOrder(order);
		}

	}

	public Order getUsersPendingOrder(long userId) {
		Order order = orderRepository.findByUserAndStatus(userId, OrderStatus.PENDING);
		return null;
	}

	public float calcOrderTotalPending(long userId) {
		float total = 0;
		Order order = orderRepository.getUsersPendingOrder(userId);
		if (order != null) {
			for (LineItems li : order.getOrderLineItems()) {
				total = (float) li.getSubtotal();
			}
		}
		return total;
	}

	public void placeOrder(Order order, long userId) {
		if(order!=null){
			for(LineItems li : order.getOrderLineItems()){
				long productId = li.getProduct().getId();
				Product p = productRepository.findById(productId);
				int available = li.getProduct().getQuantityAvailable();
				int liQuantity = li.getQuantity();
				if(liQuantity <= available){
					p.setQuantityAvailable(available-liQuantity);
				}
			}
			order.setOrderStatus("PLACED");
			orderRepository.updateOrder(order);
		}

	}

	public void removeFromBasket(long productId, long userId) {
		Product product = productRepository.findByID(productId);
		Order order = orderRepository.getUsersPendingOrder(userId);
		if (order != null) {
			boolean foundLineItem = false;
			for (LineItems li : order.getOrderLineItems()) {
				if (li.getProduct().getId() == productId) {
					order.removeLineItem(li);
				}
			}

		}
	}

	public void getLineItems(Order order, long userId) {
		ArrayList<LineItems> lineItems = order.getOrderLineItems();

	}

}
