package com.qa.smurf.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaymentService {

	//String error;
	
	/*Method checks to see if the card number is 16 digits long and only contains numbers*/
	public Boolean validateCardNumber(long cardNumber){
		if(Long.valueOf(cardNumber).toString().length() != 16){
			
			return false;
		}
		String pattern = "[//d]+";
		Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(Long.valueOf(cardNumber).toString());
		if(!matcher.find()){
			return false;
		}
		return true;
	}
	
	/*Method checks the card name to make sure it only contains alpha-numerical characters*/
	public Boolean validateCardName(String name){
		String pattern = "^[a-zA-Z0-9]*$";
		Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(name);
		if(!matcher.find()){
			return false;
		}
		return true;
	}
	
	/*Method checks the card type to accept only credit or debit*/
	public Boolean validateCardType(String cardType){
		if(!cardType.toLowerCase().equals("credit")||!cardType.toLowerCase().equals("debit")){
			return false;
		}
		return true;
	}
	
	/*method checks the expiry date and makes sure it is in the correct date format*/
	public Boolean validateExpiryDate(String expiryDate){
		String pattern = "[0-9][0-9][0-9][0-9]";
		expiryDate.replace("/", "");
		Pattern regexPattern = Pattern.compile(pattern);
		Matcher matcher = regexPattern.matcher(expiryDate);
		if(!matcher.find()){
			return false;
		}
		return true;
	}
}
