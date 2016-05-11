package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
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
	
	@PostConstruct	
	public void init(){
		initialData = new InitialData();		
	}	

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
		for (EmployeeUser employeeUser : employeeUserList) {
			if (employeeUser.getID() == eUser.getID()) {
				employeeUser = eUser;
			}
		}
	}

	@Override
	public void removeEmployeeUser(EmployeeUser eu) {
		initialData.getEmployeeUser().remove(eu);
	}

	

}
