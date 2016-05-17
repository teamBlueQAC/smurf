package com.qa.smurf.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.LineItems;
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
		System.out.println("Total - " + orderTotal);
		Credit credit = creditRepository.findByUser(user);
		if(credit != null){
			if(credit.getAmount()!=null){
				Double amount = credit.getAmount();
				System.out.println("Credit - " + amount);
				if (amount >= orderTotal) {
					return amount - orderTotal;
				} else {
					System.out.println("Credit is less than the order total");
					return 0.0;
				}
			}
		}
		return 0.0;
	}

	public Double calcOrderTotalPlaced(long userId) {
		double total = 0;
		Order order = getPlacedOrder(userRepository.findByID(userId));
		if (order != null) {
			if(order.getLineItem()!=null){
				for (LineItems li : order.getLineItem()) {
					total += (li.getProduct().getPrice())*(li.getQuantity());
				}
			}
		}
		return total;
	}

	public Payment getPayment(long userId) {
		return paymentRepository.findByUserID(userId);
	}

	public String confirmPayment(long userId) {
		Order order = getPlacedOrder(userRepository.findByID(userId));
		Credit credit = creditRepository.findByUser(userRepository.findByID(userId));
		Double creditAmount = getAmountRemaining(order.getTotal(), userRepository.findByID(userId));
		
		if(credit != null){
			credit.setAmountRemaining(creditAmount);
			System.out.println("Creditamount - " + creditAmount);
			creditRepository.updateCredit(credit);
		}
		order.setOrderStatus(OrderStatus.PAID);
		order.setDate(new Date());
		orderRepository.updateOrder(order);
		
		return "confirmation";
	}

	public String cancelPayment(long userId) {
		Order order = getPlacedOrder(userRepository.findByID(userId));
		order.setOrderStatus(OrderStatus.PENDING);
		return "basket";
	}
}
