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
		
		String error;
		
		/*Method checks to see if the card number is 16 digits long and only contains numbers*/
		public String validateCardNumber(long cardNumber){
			if(Long.valueOf(cardNumber).toString().length() != 16){
				error = "CARD LENGTH MUST BE 16 DIGITS;" ;
				return error;
			}
			String pattern = "[//d]+";
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(Long.valueOf(cardNumber).toString());
			if(!matcher.find()){
				error = error + "FIELD MUST ONLY CONTAIN DIGITS;";
				return error;
			}
			return null;
		}
		
		/*Method checks the card name to make sure it only contains alpha-numerical characters*/
		public String validateCardName(String name){
			String pattern = "^[a-zA-Z0-9]*$";
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(name);
			if(!matcher.find()){
				error = "NAME MUST ONLY CONTAIN ALPHANUMERICAL CHARACTERS";
				return error;
			}
			return null;
		}
		
		/*Method checks the card type to accept only credit or debit*/
		public String validateCardType(String cardType){
			
			if(!cardType.toLowerCase().equals("credit")||!cardType.toLowerCase().equals("debit")){
				error = "PAYMENT METHOD MUST BE EITHER CREDIT OR DEBIT CARD";
				return null;
			}
			return null;
		}
		
		/*method checks the expiry date and makes sure it is in the correct date format*/
		public String validateExpiryDate(String expiryDate){
			String pattern = "[0-9][0-9][0-9][0-9]";
			expiryDate.replace("/", "");
			Pattern regexPattern = Pattern.compile(pattern);
			Matcher matcher = regexPattern.matcher(expiryDate);
			if(!matcher.find()){
				error = "EXPIRY DATE MUST MATCH THE FORMAT MM/YY";
				return error;
			}
			return null;
		}
}
