package com.qa.smurf.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.service.AccountService;

@Named(value = "account")
@RequestScoped
public class AccountController {
	@Inject
	private AccountService accountService;
	@Inject
	private CurrentUser currentUser;
	private Payment payment = accountService.getUsersPayment(currentUser.getUserId());
	private Order order = accountService.getUsersOrder(currentUser.getUserId());
	private User user = accountService.getCustomerDetails(currentUser.getUserId());

	public String updatePersonal() {
		if (user.getName().isEmpty() || user.getAddress().getLine1().isEmpty()
				|| user.getAddress().getPostcode().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty())
			return "account";
		accountService.updatePersonal(user);
		return "account";
	}

	public String updatePayment() {
		if (payment.getCardNumber().isEmpty() || payment.getCardType().isEmpty() || payment.getNameOnCard().isEmpty()
				|| payment.getExpiryDate().toString().isEmpty())
			return "account";
		accountService.updatePayment(payment);
		return "account";
	}

	public Order getOrder() {
		return order;
	}

	public Payment getPayment() {
		return payment;
	}

	public User getUser() {
		return user;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public void setUser(User user) {
		this.user = user;
	}
}