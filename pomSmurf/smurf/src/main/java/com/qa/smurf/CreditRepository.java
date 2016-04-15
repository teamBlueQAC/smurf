/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface CreditRepository {

	public void persistCredit(Credit cr);

	public void persistCredits(List<Credit> cr);

	public Credit findByUserID(long userID);

	public ArrayList<Credit> getCredits();

}
