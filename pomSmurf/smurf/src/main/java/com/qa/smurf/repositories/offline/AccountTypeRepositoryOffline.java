package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.repositories.AccountTypeRepository;
import com.qa.smurf.util.AccountType;



public class AccountTypeRepositoryOffline implements AccountTypeRepository{
	@Inject
	private InitialData initialData;

	@Override
	public void persistAccountType(AccountType accountType) {
		initialData.addAccountType(accountType);

	}

	@Override
	public void persistAccountTypes(List<AccountType> accountType) {
		for(AccountType a: accountType){
			initialData.addAccountType(a);
		}	

	}

	@Override
	public AccountType findByID(int id) {
		for(AccountType a: initialData.getAccountTypes()){
			if(a.getId() == id){
				return a;
			}
		}
		return null;
	}

	@Override
	public ArrayList<AccountType> getAccountTypes() {
		return initialData.getAccountTypes();
	}

	@Override
	public void updateAccountType(AccountType accountType) {
		ArrayList<AccountType> accountTypes = initialData.getAccountTypes();
		for(int i=0; i<accountTypes.size(); i++) {
			if(accountTypes.get(i).getId() == accountType.getId())
				accountTypes.set(i, accountType);
		}
		initialData.setAccountType(accountTypes);

	}

	@Override
	public void removeAccountType(AccountType accountType) {
		ArrayList<AccountType> accountTypes = initialData.getAccountTypes();
		for(int i=0; i<accountTypes.size(); i++) {
			if(accountTypes.get(i).equals(accountType))
				accountTypes.remove(i);
		}
		initialData.setAccountType(accountTypes);

	}

}
