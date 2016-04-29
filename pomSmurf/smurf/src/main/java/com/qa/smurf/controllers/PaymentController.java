package com.qa.smurf.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Address;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
//import com.qa.smurf.service.AddressService;
import com.qa.smurf.service.PaymentService;
//import com.qa.smurf.service.UserService;
>>>>>>> Initial controller work

	@Named(value = "account")
	@RequestScoped
	
public class PaymentController {
		@Inject
		PaymentService paymentService; 
		/*
		@Inject
		UserService userService;
		@Inject
		AddressService addressService;
		*/
		
		String error;
		String cardNumber;
		String cardType;
		String expiryDate;
		String nameOnCard;
		Address address;
		User user; 
		
		public String inputCardNumber(){
			if(cardNumber.length()!= 16){
				error = "CARD LENGTH MUST BE 16 DIGITS" ;

				return error;
			}
			return null;
		} 
		
		public String inputExpiryDate(String expiryDate){
			String pattern = "[0-9][0-9][0-9][0-9]";
			expiryDate.replace("/", "");
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(expiryDate);
			if(matcher.find()){
				
			} else {
				error = "Expiry date must match the format MM/yy";
				return error;
			}
			return null;
		}
}
