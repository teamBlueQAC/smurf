/* Made By Dean + Nabs; edited by will */

package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qa.smurf.entities.Payment;

public interface PaymentRepository {

	public void persistPayment(Payment payment);

	public void persistPayment(List<Payment> payments);

	public Payment findByID(long id);

	public Payment findByCardNumber(String cardNumber);

	public Payment findByCardType(String cardType);

	public Payment findByExpiryDate(String expiryDate);

	public Payment findByNameOnCard(String nameOnCard);
	
	public Payment findBySecurityNumber(int ccv);

	public ArrayList<Payment> getPayments();

	public void createPayment(Payment p);

	public Payment readPayment(Payment p);

	public void updatePayment(Payment p);

	public void removePayment(Payment p);

	

}