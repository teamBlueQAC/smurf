/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface PaymentRepository {

	public void persistPayment(Payment  p);

	public void persistPayments(List<Payment>  p);

	public Payment findByID(long id);

	public ArrayList<Payment> getPayments();

	public void updatePayment(Payment  p);

	public void removePayment(Payment  p);

}
