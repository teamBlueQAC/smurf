/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface AccountTypeRepository {
	public void persistAccountType(AccountType at);

	public void persistAccountTypes(List<AccountType> at);

	public AccountType findByID(long id);

	public ArrayList<AccountType> getAccountTypes();
}
