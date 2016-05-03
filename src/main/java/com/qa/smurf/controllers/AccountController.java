package com.qa.smurf.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.service.AccountService;

@Named(value = "account")
@RequestScoped
public class AccountController {
	@Inject
	AccountService accountService;
	@Inject
	CurrentUser currentUser;
	private User user = accountService.getCurrentUser(currentUser.getUserId());
	
	private Payment payment = accountService.getUsersPayment(currentUser.getUserId());

	public String updatePersonal() {
		if (user.getName().isEmpty() || user.getAddress().getLine1().isEmpty()
				|| user.getAddress().getPostcode().isEmpty() || user.getEmail().isEmpty() || user.getPhone().isEmpty())
			return "account";
		accountService.updatePersonal(user, currentUser.getUserId());
		return "account";
	}

	public String updatePayment() {
		if (payment.getCardNumber().isEmpty() || payment.getCardType().isEmpty() || payment.getNameOnCard().isEmpty()
				|| payment.getExpiryDate().toString().isEmpty())
			return "account";
		accountService.updatePayment(payment);
		return "account";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}
}