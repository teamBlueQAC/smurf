package com.qa.smurf.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.OrderRepository;
import com.qa.smurf.repositories.PaymentRepository;
import com.qa.smurf.repositories.UserRepository;

@Stateless
public class AccountService {
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private UserRepository userRepository;
	@SuppressWarnings("cdi-ambiguous-dependency")
	@Inject
	private PaymentRepository paymentrepository;
	@SuppressWarnings("cdi-ambiguous-dependency")
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

	public Order getUsersOrder(long userId) {
		return orderRepository.findMostRecentUnPaiedOrder(userId);
	}
}