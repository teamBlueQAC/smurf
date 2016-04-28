package com.qa.smurf.repositories;

/**
 * Created by Elliot and Sam
 */
import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.util.AccountType;

public interface AccountTypeRepository {
	public void persistAccountType(AccountType accountType);

	public void persistAccountTypes(List<AccountType> accountType);

	public AccountType findByID(int id);

	public ArrayList<AccountType> getAccountTypes();

	public void updateAccountType(AccountType accountType);

	public void removeAccountType(AccountType accountType);
}
