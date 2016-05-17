package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.repositories.PaymentRepository;
import com.qa.smurf.entities.Payment;

@Default
@Stateless
public class PaymentRepositoryOffline implements PaymentRepository {

	@Inject
	private InitialData initialData;

	public void persistPayment(Payment payment) {
		initialData.addPayment(payment);
	}

	public void persistPayment(List<Payment> payments) {
		for (Payment p : payments) {
			initialData.addPayment(p);
		}
	}

	public Payment findByID(long id) {
		for (Payment p : initialData.getPayments()) {
			if (p.getId() == id) {
				return p;
			}
		}
		return null;
	}
	
	public Payment findByUserID(long id) {
		for (Payment p : initialData.getPayments()) {
			if (p.getUser().getId() == id) {
				return p;
			}
		}
		return null;
	}

	public Payment findByCardNumber(String cardNumber) {
		for (Payment p : initialData.getPayments()) {
			if (p.getCardNumber().equals(cardNumber)) {
				return p;
			}
		}
		return null;
	}

	public Payment findByCardType(String cardType) {
		for (Payment p : initialData.getPayments()) {
			if (p.getCardType().equals(cardType)) {
				return p;
			}
		}
		return null;
	}

	public Payment findByExpiryDate(String expiryDate) {
		for (Payment p : initialData.getPayments()) {
			if (p.getExpiryDate().equals(expiryDate)) {
				return p;
			}
		}
		return null;
	}

	public Payment findByNameOnCard(String nameOnCard) {
		for (Payment p : initialData.getPayments()) {
			if (p.getNameOnCard().equals(nameOnCard)) {
				return p;
			}
		}
		return null;
	}

	public ArrayList<Payment> getPayments() {
		return initialData.getPayments();
	}

	public void createPayment(Payment p) {
		persistPayment(p);
	}

	public Payment readPayment(Payment payment) {
		for (Payment p : initialData.getPayments()) {
			if (p.getId() == payment.getId()) {
				return p;
			}
		}
		return null;
	}

	public void updatePayment(Payment payment) {
		for (Payment p : initialData.getPayments()) {
			if (p.getId() == payment.getId()) {
				p = payment;
			}
		}
	}

	public void removePayment(Payment payment) {
		for (Payment p : initialData.getPayments()) {
			if (p.getId() == payment.getId()) {
				initialData.getPayments().remove(p);
			}
		}
	}

	@Override
	public Payment findBySecurityNumber(int ccv) {
		// TODO Auto-generated method stub
		return null;
	}
}
