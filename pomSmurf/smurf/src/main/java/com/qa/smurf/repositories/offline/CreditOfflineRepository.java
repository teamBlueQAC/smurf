package com.qa.smurf.repositories.offline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.CreditRepository;
import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;

public class CreditOfflineRepository implements CreditRepository {
	InitialData initialData = new InitialData();
	

	@Override
	public void persistCredit(Credit credit) {
		initialData.addCredit(credit);
		
	}

	@Override
	public void persistCredit(List<Credit> credits) {
		for(Credit c: credits){
			initialData.addCredit(c);
		}
		
	}

	@Override
	public Credit findByUser(User user) {
		for(Credit c: initialData.getCredit()){
			if(c.getUser().equals(user));
			return c;
		}
		return null;
	}

	@Override
	public ArrayList<Credit> getCredit() {
		return initialData.getCredit();
	}

	@Override
	public Credit readCredit(Credit credit) {
			ArrayList<Credit> creditList = initialData.getCredit();
			for(Credit c: creditList){
				if(c.getUser() == credit.getUser()){
					return c;
				}
		return null;
	}
}
