package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.repositories.AccountTypeRepository;
import com.qa.smurf.util.AccountType;

/**
 * 
 * @author Nathan Orme
 *
 *         Offline Repository for the AccountType Repository
 *
 */
class AccountTypeRepositoryOffline implements AccountTypeRepository {
	@Inject
	private InitialData initialData;

	/**
	 * Adds productType to system
	 * 
	 * @param accountType
	 *            - accountType that gets added
	 */
	@Override
	public void persistAccountType(AccountType accountType) {
		initialData.addAccountType(accountType);

	}

	/**
	 * Iterates through the passed list of account types, Then adds them to the
	 * system.
	 * 
	 * @param accountType
	 *            - accountType that gets added
	 */
	@Override
	public void persistAccountTypes(List<AccountType> accountType) {
		for (AccountType a : accountType) {
			initialData.addAccountType(a);
		}

	}

	/**
	 * Gets the account type from the storage
	 * 
	 * @param id
	 *            - id of the account type
	 */
	@Override
	public AccountType findByID(long id) {
		for (AccountType a : initialData.getAccountTypes()) {
			if (a.getId() == id) {
				return a;
			}
		}
		return null;
	}

	@Override
	public ArrayList<AccountType> getAccountTypes() {
		return initialData.getAccountTypes();
	}

	/**
	 * Iterates through the existing list of account types, Then updated the
	 * specified account type from the list.
	 * 
	 * @param accountType
	 *            - accountType that gets updated
	 */
	@Override
	public void updateAccountType(AccountType accountType) {
		ArrayList<AccountType> accountTypes = initialData.getAccountTypes();
		for (int i = 0; i < accountTypes.size(); i++) {
			if (accountTypes.get(i).getId() == accountType.getId())
				accountTypes.set(i, accountType);
		}
		initialData.setAccountType(accountTypes);

	}

	/**
	 * Iterates through the existing list of account types, Then Removes the
	 * specified account type from the list.
	 * 
	 * @param accountType
	 *            - accountType that gets removed
	 */
	@Override
	public void removeAccountType(AccountType accountType) {
		ArrayList<AccountType> accountTypes = initialData.getAccountTypes();
		for (int i = 0; i < accountTypes.size(); i++) {
			if (accountTypes.get(i).equals(accountType))
				accountTypes.remove(i);
		}
		initialData.setAccountType(accountTypes);

	}

}
