package com.qa.smurf.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.qa.smurf.entities.Payment;
import com.qa.smurf.repositories.PaymentRepository;

public class PaymentService {

	@Inject
	PaymentRepository paymentRepository;
	
	/*Method checks to see if the card number is 16 digits long and only contains numbers*/
	public Payment findByCardNumber(String cardNumber){
		return paymentRepository.findByCardNumber(cardNumber);
	}
	
	/*Method checks the card name to make sure it only contains alpha-numerical characters*/
	public Payment findByCardName(String name){
		return paymentRepository.findByNameOnCard(name);
	}
	
	/*Method checks the card type to accept only credit or debit*/
	public Payment findByCardType(String cardType){
		return paymentRepository.findByCardType(cardType);
	}
	
	/*method checks the expiry date and makes sure it is in the correct date format*/
	public Payment findByExpiryDate(String expiryDate){
		return paymentRepository.findByExpiryDate(expiryDate);
	}
	
	/*method checks the ccv number and makes sure it is only 3 digits long*/
	public Payment findBySecurityNumber(int ccv){
		return paymentRepository.findBySecurityNumber(ccv);
	}
}
