package com.qa.smurf.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

//import com.qa.smurf.service.AddressService;
import com.qa.smurf.service.PaymentService;
//import com.qa.smurf.service.UserService;

	@Named(value = "payment")
	@RequestScoped
	// A series of method using regular expressions to validate the user input.
public class PaymentController {
		@Inject
		PaymentService paymentService; 
		
		public Boolean validateCardName(String name){
			if(paymentService.validateCardName(name)){
				return true;
			}
			return false;
		}
		
		public Boolean validateCardNumber(long cardNumber){
			if(paymentService.validateCardNumber(cardNumber)){
				return true;
			}
			return false;
		}
		
		public Boolean validateExpiryDate(String expiryDate){
			if(paymentService.validateExpiryDate(expiryDate)){
				return true;
			}
			return false;
		}
		
		public Boolean validateCardType(String cardType){
			if(paymentService.validateCardType(cardType)){
				return true;
			}
			return false;
		}
}
