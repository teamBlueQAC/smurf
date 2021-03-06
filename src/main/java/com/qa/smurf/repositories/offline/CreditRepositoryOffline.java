package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;
//import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import com.qa.smurf.repositories.CreditRepository;
import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.User;
//import com.qa.smurf.repositories.CategoryRepository;

@Default
@Stateless
public class CreditRepositoryOffline implements CreditRepository {	

	@Inject
	private InitialData initialData;

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
			if (c.getUser().equals(user));
			return c;
		}
		return null;
	}

	public ArrayList<Credit> getCredit() {
		return initialData.getCredit();
	}

	public Credit checkCredit(Credit credit) {
		ArrayList<Credit> creditList = initialData.getCredit();
		for (Credit c : creditList) {
			if (c.getUser() == credit.getUser()) {
				return c;
			}
		}
		return null;
	}
	
	public void updateCredit(Credit credit) {
		ArrayList<Credit> credits = initialData.getCredit();
		for (int i = 0; i < credits.size(); i++) {
			if (credits.get(i) == credit){
				System.out.println("Found Credit");
				credits.set(i, credit);
			}
		}
		initialData.setCredit(credits);
	}
	
	@Override
	public Credit readCredit(Credit credit) {
		// TODO Auto-generated method stub
		return null;

	}
}
