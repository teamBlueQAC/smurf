package com.qa.smurf.repositories.offline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.EmployeeUserTest;
import com.qa.smurf.repositories.EmployeeUserRepository;

public class EmployeeUserRepositoryOffline implements EmployeeUserRepository {

	private InitialData initialData;
		ArrayList<EmployeeUserTest> employeeUser = new ArrayList<EmployeeUserTest>();
	
	@PostConstruct	
	public void init(){
		try{
			initialData = new InitialData();
		} catch (ParseException pe){
			pe.printStackTrace();
		}
		
	}	
	


	@Override
	public void persistEmployeeUser(EmployeeUserTest eu) {
		initialData.addEmployeeUser(eu);
	}

	@Override
	public void persistEmployeeUsers(List<EmployeeUserTest> eu) {
		for (EmployeeUserTest employeeUser : eu) {
			initialData.addEmployeeUser(employeeUser);
		}
	}

	@Override
	public EmployeeUserTest findByID(long id) {
		for (EmployeeUserTest employeeUser : initialData.getEmployeeUser()) {
			if (employeeUser.getID() == id) {
				return employeeUser;
			}
		}
		return null;
	}

	@Override
	public ArrayList<EmployeeUserTest> getEmployeeUsers() {
		return initialData.getEmployeeUser();
	}

	@Override
	public void updateEmployeeUser(EmployeeUserTest eUser) {
		ArrayList<EmployeeUserTest> employeeUserList = initialData.getEmployeeUser();
		for (EmployeeUserTest employeeUser : employeeUserList) {
			if (employeeUser.getID() == eUser.getID()) {
				employeeUser = eUser;
			}
		}
	}

	@Override
	public void removeEmployeeUser(EmployeeUserTest eu) {
		initialData.getEmployeeUser().remove(eu);
	}

}
