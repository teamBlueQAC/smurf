package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import com.qa.smurf.InitialData;
import com.qa.smurf.entities.EmployeeUser;
import com.qa.smurf.repositories.EmployeeUserRepository;

@Default
@Stateless
public class EmployeeUserRepositoryOffline implements EmployeeUserRepository {

	@Inject
	private InitialData initialData;
		ArrayList<EmployeeUser> employeeUser = new ArrayList<EmployeeUser>();
	

	@Override
	public void persistEmployeeUser(EmployeeUser eu) {
		initialData.addEmployeeUser(eu);
	}

	@Override
	public void persistEmployeeUsers(List<EmployeeUser> eu) {
		for (EmployeeUser employeeUser : eu) {
			initialData.addEmployeeUser(employeeUser);
		}
	}

	@Override
	public EmployeeUser findByID(long id) {
		for (EmployeeUser employeeUser : initialData.getEmployeeUser()) {
			if (employeeUser.getID() == id) {
				return employeeUser;
			}
		}
		return null;
	}

	@Override
	public ArrayList<EmployeeUser> getEmployeeUsers() {
		return initialData.getEmployeeUser();
	}

	@Override
	public void updateEmployeeUser(EmployeeUser eUser) {
		ArrayList<EmployeeUser> employeeUserList = initialData.getEmployeeUser();
		for(int i = 0; i < employeeUserList.size();  i++){
			if(employeeUserList.get(i).getID() == eUser.getID()){
				employeeUserList.set(i, eUser);
				break;
			}
		}
	}

	@Override
	public void removeEmployeeUser(EmployeeUser eu) {
		initialData.getEmployeeUser().remove(eu);
	}

	

}
