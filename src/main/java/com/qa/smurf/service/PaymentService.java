package com.qa.smurf.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.CreditRepository;
import com.qa.smurf.repositories.OrderRepository;
import com.qa.smurf.repositories.PaymentRepository;
import com.qa.smurf.repositories.UserRepository;
import com.qa.smurf.util.OrderStatus;

@Stateless
public class PaymentService {
	@Inject	private UserRepository userRepository;
	@Inject	private PaymentRepository paymentRepository;
	@Inject	private CreditRepository creditRepository;
	@Inject	private OrderRepository orderRepository;

	/*
	 * Method checks to see if the card number is 16 digits long and only
	 * contains numbers
	 */
	public Payment findByCardNumber(String cardNumber) {
		return paymentRepository.findByCardNumber(cardNumber);
	}

	/*
	 * Method checks the card name to make sure it only contains alpha-numerical
	 * characters
	 */
	public Payment findByCardName(String name) {
		return paymentRepository.findByNameOnCard(name);
	}

	/* Method checks the card type to accept only credit or debit */
	public Payment findByCardType(String cardType) {
		return paymentRepository.findByCardType(cardType);
	}

	/*
	 * method checks the expiry date and makes sure it is in the correct date
	 * format
	 */
	public Payment findByExpiryDate(String expiryDate) {
		return paymentRepository.findByExpiryDate(expiryDate);
	}

	/* method checks the ccv number and makes sure it is only 3 digits long */
	public Payment findBySecurityNumber(int ccv) {
		return paymentRepository.findBySecurityNumber(ccv);
	}

	public Double getAmountPaying(Double total, User user) {
		Credit credit = creditRepository.findByUser(user);
		Double amount = credit.getAmount();
		if (total >= amount) {
			return total - amount;
		} else {
			System.out.println("Total is less than the amount of credit");
			return 0.0;
		}
	}

	public User getCurrentUser(long userId) {
		return userRepository.findByID(userId);
	}

	public Order getPlacedOrder(User user) {
		List<Order> orders = orderRepository.findByUser(user);
		for (Order o : orders) {
			if (o.getOrderStatus() == OrderStatus.PLACED) {
				return o;
			}
		}
		return null;
	}

	public Double getAmountRemaining(Double orderTotal, User user) {
		Credit credit = creditRepository.findByUser(user);
		Double amount = credit.getAmount();
		if (amount >= orderTotal) {
			return amount - orderTotal;
		} else {
			System.out.println("Credit is less than the order total");
			return 0.0;
		}
	}

	public Payment getPayment(User user) {
		return paymentRepository.findByUserId(user.getId());
	}

	public String confirmPayment(Order order, Credit credit, Payment payment, long userId) {
		Double creditAmount = getAmountRemaining(order.getTotal(), userRepository.findByID(userId));
		credit.setAmountRemaining(creditAmount);
		order.setOrderStatus(OrderStatus.PAID);
		return "confirmation";
	}
}
