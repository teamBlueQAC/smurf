package com.qa.smurf.service;

import javax.inject.Inject;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.CreditRepository;
import com.qa.smurf.repositories.PaymentRepository;

public class PaymentService {

	@Inject
	PaymentRepository paymentRepository;

	@Inject
	CreditRepository creditRepository;

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

	public Double getAmountRemaining(Double total, User user) {
		Credit credit = creditRepository.findByUser(user);
		Double amount = credit.getAmount();
		if(total>=amount){
			return total-amount;
		} else {
			System.out.println("Total is less than the amount of credit");
			return 0.0;
		}
	}
}
