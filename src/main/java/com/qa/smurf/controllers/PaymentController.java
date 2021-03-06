package com.qa.smurf.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.service.CreditService;
//import com.qa.smurf.service.AddressService;
import com.qa.smurf.service.PaymentService;
//import com.qa.smurf.service.UserService;

@Named(value = "payment")
@SessionScoped
// A series of method using regular expressions to validate the user input.
public class PaymentController {
	@Inject	private PaymentService paymentService;
	@Inject	private CreditService creditService;
	@Inject	private CurrentUser currentUser;
	private boolean useCredit;
	private User user;
	private Credit credit;
	private Order placedOrder;
	private Payment payment;

	private Boolean matchesPattern(String input, String pattern) {
		Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(input);
		return matcher.find();
	}

	public Payment findByCardName(String name) {
		String pattern = "^[a-zA-Z0-9]*$";
		Payment returnPayment = null;

		if (matchesPattern(name, pattern)) {
			returnPayment = paymentService.findByCardName(name);
		}
		return returnPayment;
	}

	public Payment findByCardNumber(String cardNumber) {
		String pattern = "[//d]+";
		Payment returnPayment = null;

		if (Long.valueOf(cardNumber).toString().length() != 16 && matchesPattern(cardNumber, pattern)) {
			returnPayment = paymentService.findByCardNumber(cardNumber);
		}
		return returnPayment;
	}

	public Payment findByExpiryDate(String expiryDate) {
		String pattern = "[0-9][0-9][0-9][0-9]";
		Payment returnPayment = null;
		expiryDate.replace("/", "");

		if (matchesPattern(expiryDate, pattern)) {
			returnPayment = paymentService.findByExpiryDate(expiryDate);
		}
		return returnPayment;
	}

	public Payment validateCardType(String cardType) {
		if (!cardType.toLowerCase().equals("credit") || !cardType.toLowerCase().equals("debit")) {
			return null;
		}
		return paymentService.findByCardType(cardType);
	}

	public Payment validateSecurityNumber(String ccv) {
		String pattern = "[0-9][0-9][0-9]";
		Payment returnPayment = null;

		if (matchesPattern(ccv, pattern)) {
			returnPayment = paymentService.findByExpiryDate(ccv);
		}
		return returnPayment;
	}

	public String getTotalPrice() {
		return String.format("%.2f", paymentService.calcOrderTotalPlaced(currentUser.getUserId()));
	}

	public String getCreditTotal() {
		return String.format("%.2f", paymentService.calcCreditTotal(currentUser.getUserId()));
	}

	public String confirmPayment(){
		System.out.println("useCredit on confirm - " + useCredit);
		return paymentService.confirmPayment(currentUser.getUserId());
	}

	public String cancelPayment(){
		return paymentService.cancelPayment(currentUser.getUserId());

	}

	public Double getAmountPaying(Double total, User user) {
		return paymentService.getAmountPaying(total, user);
	}

	public Double getCreditRemaining(Double orderTotal, User user) {
		return paymentService.getAmountRemaining(orderTotal, user);
	}

	public void onChangeEnabled() {
		System.out.println("onChange called");
		System.out.println("useCredit original - " + this.useCredit);
		if(this.useCredit){
			System.out.println("useCredit set to false");
			this.useCredit = false;
		} else {
			System.out.println("useCredit set to true");
			this.useCredit = true;
		}
		//setUseCredit(useCredit);
	}

	public CurrentUser getCurrentUser() {
		return currentUser;
	}

	public Order getPlacedOrder() {
		placedOrder = paymentService.getPlacedOrder(user);
		return placedOrder;
	}

	public void setPlacedOrder(Order placedOrder) {
		this.placedOrder = placedOrder;
	}

	public User getUser() {
		user = paymentService.getCurrentUser(currentUser.getUserId());
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Credit getCredit() {
		credit = creditService.findByUserId(currentUser.getUserId());
		return credit;
	}

	public void setCredit(Credit credit) {
		this.credit = credit;
	}

	public Payment getPayment() {
		payment = paymentService.getPayment(currentUser.getUserId());
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public boolean isUseCredit() {
		//useCredit = false;
		return useCredit;
	}

	public void setUseCredit(boolean useCredit) {
		this.useCredit = useCredit;
	}
}
