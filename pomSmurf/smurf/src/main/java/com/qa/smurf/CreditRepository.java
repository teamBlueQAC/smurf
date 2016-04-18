package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface CreditRepository {
	
	public void persistCredit (Credit credit);
	
	public void persistCredit (List<Credit> credits);
	
	public Credit findByUser(User user);
	
	public ArrayList<Credit> getCredit();
	
	public Credit readCredit(Credit credit);

}
