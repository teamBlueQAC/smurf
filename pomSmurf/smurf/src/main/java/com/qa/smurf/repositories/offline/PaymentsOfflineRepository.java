package com.qa.smurf.repositories.offline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.qa.smurf.InitialData;
import com.qa.smurf.PaymentRepository;
import com.qa.smurf.entities.Payment;

public class PaymentsOfflineRepository implements PaymentRepository {

	private InitialData initialData = new InitialData();
	
	@Override
	public void persistPayment(Payment payment) {
		initialData.addPayment(payment);
		
	}

	@Override
	public void persistPayment(List<Payment> payments) {
		for(Payment p: payments){
			initialData.addPayment(p);
		}
		
	}

	@Override
	public Payment findByID(long id) {
		try{
			ArrayList<Payment> payment = initialData.getPayment();
			for(Payment p: payment){
				if(p.getId() == id){
					return p;
				}
			}
		} catch (ParseException pe){
			System.err.println();
		}
		
		return null;
	}

	@Override
	public Payment findByCardNumber(String cardNumber) {
		try{
			ArrayList<Payment> payment = initialData.getPayment();
			for(Payment p: payment){
				if(p.getCardNumber().equals(cardNumber)){
					return p;
				}
			}
		} catch (ParseException pe){
			System.err.println();
		}
		return null;
	}

	@Override
	public Payment findByCardType(String cardType) {
		try{
			ArrayList<Payment> payment = initialData.getPayment();
			for(Payment p: payment){
				if(p.getCardType().equals(cardType)){
					return p;
				}
			}
		} catch (ParseException pe){
			System.err.println();
		}
		return null;
	}

	@Override
	public Payment findByExpiryDate(Date expiryDate) {
		try{
			ArrayList<Payment> payment = initialData.getPayment();
			for(Payment p: payment){
				if(p.getExpiryDate().equals(expiryDate)){
					return p;
				}
			}
		} catch (ParseException pe){
			System.err.println();
		}
		return null;
	}

	@Override
	public Payment findByNameOnCard(String nameOnCard) {
		try{
			ArrayList<Payment> payment = initialData.getPayment();
			for(Payment p: payment){
				if(p.getNameOnCard().equals(nameOnCard)){
					return p;
				}
			}
		} catch (ParseException pe){
			System.err.println();
		}
		return null;
	}

	@Override
	public ArrayList<Payment> getPayments() {
		try{
			ArrayList<Payment> payment = initialData.getPayment();
			return payment;
		} catch (ParseException pe) {
			System.err.println();
		}
		return null;
	}

	@Override
	public void createPayment(Payment p) {
		persistPayment(p);
		
	}

	@Override
	public Payment readPayment(Payment payment) {
		try{
			ArrayList<Payment> paymentList = initialData.getPayment();
			for(Payment p: paymentList){
				if(p.getId() == payment.getId()){
					return p;
				}
			}
			
		} catch (ParseException pe) {
			System.err.println();
		}
		return null;
	}

	@Override
	public void updatePayment(Payment payment) {
		
		try{
			ArrayList<Payment> paymentList = initialData.getPayment();
			for(Payment p: paymentList){
				if(p.getId() == payment.getId()){
					p = payment;
				}
			}
			
		} catch (ParseException pe) {
			System.err.println();
		}
		
		
	}

	@Override
	public void removePayment(Payment payment) {
		try{
			ArrayList<Payment> paymentList = initialData.getPayment();
			for(Payment p: paymentList){
				if(p.getId() == payment.getId()){
					paymentList.remove(p);
				}
			}
		} catch (ParseException pe) {
			System.err.println();
		}
	}
}
