package com.qa.smurf.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Payment;
//import com.qa.smurf.service.AddressService;
import com.qa.smurf.service.PaymentService;
//import com.qa.smurf.service.UserService;

	@Named(value = "payment")
	@RequestScoped
	// A series of method using regular expressions to validate the user input.
public class PaymentController {
		
		@Inject
		PaymentService paymentService;
		
		public Payment findByCardName(String name){
			String pattern = "^[a-zA-Z0-9]*$";
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(name);
			if(!matcher.find()){
				return null;
			}
			return paymentService.findByCardName(name);
		}
		
		public Payment findByCardNumber(String cardNumber){
			
			if(Long.valueOf(cardNumber).toString().length() != 16){
				return null;
			}
			String pattern = "[//d]+";
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(Long.valueOf(cardNumber).toString());
			if(!matcher.find()){
				return null;
			}
			return paymentService.findByCardNumber(cardNumber);
		}
		
		public Payment findByExpiryDate(String expiryDate){
			String pattern = "[0-9][0-9][0-9][0-9]";
			expiryDate.replace("/", "");
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(expiryDate);
			if(!matcher.find()){
				return null;
			}
			return paymentService.findByExpiryDate(expiryDate);
		}
		
		public Payment validateCardType(String cardType){
			if(!cardType.toLowerCase().equals("credit")||!cardType.toLowerCase().equals("debit")){
				return null;
			}
			return paymentService.findByCardType(cardType);
		}
		
		public Payment validateSecurityNumber(int ccv){
			if(Integer.valueOf(ccv).toString().length() != 3){
				return null;
			}
			String pattern = "[//d]+";
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(Long.valueOf(ccv).toString());
			if(!matcher.find()){
				return null;
			}
			return paymentService.findBySecurityNumber(ccv);
		}	
}
