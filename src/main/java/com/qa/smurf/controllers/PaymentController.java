package com.qa.smurf.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
//import com.qa.smurf.service.AddressService;
import com.qa.smurf.service.PaymentService;
//import com.qa.smurf.service.UserService;

	@Named(value = "payment")
	@RequestScoped
	// A series of method using regular expressions to validate the user input.
public class PaymentController {
		
		@Inject
		PaymentService paymentService;
		
		private Boolean matchesPattern(String input, String pattern){
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(input);
			return matcher.find();
		}
		
		public Payment findByCardName(String name){
			String pattern = "^[a-zA-Z0-9]*$";
			Payment returnPayment = null;
			
			if(matchesPattern(name, pattern)){
				returnPayment = paymentService.findByCardName(name);
			}
			return returnPayment;
		}
		
		public Payment findByCardNumber(String cardNumber){
			String pattern = "[//d]+";
			Payment returnPayment = null;
			
			if(Long.valueOf(cardNumber).toString().length() != 16 && 
					matchesPattern(cardNumber, pattern)){
				returnPayment = paymentService.findByCardNumber(cardNumber);
			}
			return returnPayment;
		}
		
		public Payment findByExpiryDate(String expiryDate){
			String pattern = "[0-9][0-9][0-9][0-9]";
			Payment returnPayment = null;
			expiryDate.replace("/", "");
			
			if(matchesPattern(expiryDate, pattern)){
				returnPayment = paymentService.findByExpiryDate(expiryDate);
			}
			return returnPayment;
		}
		
		public Payment validateCardType(String cardType){
			if(!cardType.toLowerCase().equals("credit")||!cardType.toLowerCase().equals("debit")){
				return null;
			}
			return paymentService.findByCardType(cardType);
		}
		
		public Payment validateSecurityNumber(String ccv){
			String pattern = "[0-9][0-9][0-9]";
			Payment returnPayment = null;

			if(matchesPattern(ccv, pattern)){
				returnPayment = paymentService.findByExpiryDate(ccv);
			}
			return returnPayment;
		}	
		
		public Double getAmountRemaining(Double total, User user){
			return paymentService.getAmountRemaining(total, user);
		}
}
