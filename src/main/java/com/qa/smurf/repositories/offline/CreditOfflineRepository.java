package com.qa.smurf.repositories.offline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.qa.smurf.repositories.CreditRepository;
import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
//import com.qa.smurf.repositories.CategoryRepository;

public class CreditOfflineRepository implements CreditRepository {
	
	
	InitialData initialData;

	@PostConstruct	
	public void init(){
		try{
			initialData = new InitialData();
		} catch (ParseException pe){
			pe.printStackTrace();
		}	
	}	
	
	public void persistCredit(Credit credit) {
		initialData.addCredit(credit);

	}

	public void persistCredit(List<Credit> credits) {
		for (Credit c : credits) {
			initialData.addCredit(c);
		}

	}

	public Credit findByUser(User user) {
		for (Credit c : initialData.getCredit()) {
			if (c.getUser().equals(user))
				;
			return c;
		}
		return null;
	}

	public ArrayList<Credit> getCredit() {
		return initialData.getCredit();
	}

	public Credit readCredit(Credit credit) {
		ArrayList<Credit> creditList = initialData.getCredit();
		for (Credit c : creditList) {
			if (c.getUser() == credit.getUser()) {
				return c;
			}
		}
		return null;
	}
}
