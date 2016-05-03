package com.qa.smurf.service;

import java.util.Date;

import javax.inject.Inject;

import com.qa.smurf.entities.Address;
import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.OrderRepository;
import com.qa.smurf.repositories.ProductRepository;
import com.qa.smurf.repositories.UserRepository;

public class OrderService {

	@Inject
	ProductRepository productRepository;

	@Inject
	OrderRepository orderRepository;

	@Inject
	UserRepository userRepository;

	public User getCurrentUser(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void addToBasket(long productId, long userId) {
		Product product = productRepository.findByID(productId);
		Order order = orderRepository.getUsersPendingOrder(userId);
		if(order != null){
			boolean foundLineItem = false;
			for (LineItems li : order.getOrderLineItems()){
				if(li.getProduct().getId() == productId){
					li.setQuantity(li.getQuantity()+1);
					foundLineItem = true;
				}
				order.addLineItem(new LineItems(order, product, 1, product.getPrice(), product.getQuantityAvailable()));
			}

		} else{
			order = new Order(123, new Date(), new Date(), 
					new Payment(null, null, null, null, null, null), 
					new Address("Place", "Postcode"), 
					userRepository.findByID(userId), null);
		}
		// TODO Auto-generated method stub

	}

	public void updateOrder(Order order, long userId) {
		// TODO Auto-generated method stub

	}

	public void clearBasket(long userId) {
		Order order = orderRepository.getUsersPendingOrder(userId);


	}

	public Order getUsersPendingOrder(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public float calcOrderTotalPending(long userId) {
		float total = 0;
		Order order = orderRepository.getUsersPendingOrder(userId);
		if(order != null){
			for (LineItems li : order.getOrderLineItems()){
				total=(float) li.getSubtotal();
			}
		}
		return total;
	}

	public void placeOrder(Order order, long userId) {
		// TODO Auto-generated method stub

	}

	public void removeFromBasket(long productId, long userId) {
		Product product = productRepository.findByID(productId);
		Order order = orderRepository.getUsersPendingOrder(userId);
		if(order != null){
			boolean foundLineItem = false;
			for (LineItems li : order.getOrderLineItems()){
				if(li.getProduct().getId() == productId){
					order.removeLineItem(li);
				}
			}

		} 
	}

	public void getLineItems(Order order, long userId) {
		// TODO Auto-generated method stub

	}

}
