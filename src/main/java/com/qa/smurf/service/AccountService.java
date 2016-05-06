package com.qa.smurf.service;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.OrderRepository;
import com.qa.smurf.repositories.PaymentRepository;
import com.qa.smurf.repositories.UserRepository;

@Default
@Stateless
public class AccountService {
	@Inject
	private UserRepository userRepository;
	@Inject
	private PaymentRepository paymentrepository;
	@Inject
	private OrderRepository orderRepository;

	// update customer info
	public void updatePersonal(User user) {
		if (user != null) {
			userRepository.updateUser(user);
		}
	}

	public User getCustomerDetails(long userId) {
		return userRepository.findByID(userId);
	}

	// update payment
	public void updatePayment(Payment payment) {
		if (payment != null)
			paymentrepository.updatePayment(payment);
	}

	public Payment getUsersPayment(long userId) {
		return paymentrepository.findByID(userId);
	}

	public ArrayList<Order> getUsersOrder(long userId) {
		return orderRepository.findByUser(userRepository.findByID(userId));
	}
}