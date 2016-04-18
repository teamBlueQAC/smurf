/* Made By Dean + Nabs; edited by will */

package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface PaymentRepository {

	public void persistPayment (Payment payment);
	public void persistPayment (List<Payment> payments);
	
	public Payment findByID(long id);

	public ArrayList<Payment> getPayments();
	
	public void createPayment(Payment p);
	
	public Payment readPayment(Payment p);

	public void updatePayment(Payment  p);

	public void removePayment(Payment  p);

}