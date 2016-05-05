package com.qa.smurf.repositories.offline;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.EmployeeUser;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.repositories.EmployeeUserRepository;

public class EmployeeUserOfflineRepository implements EmployeeUserRepository {

	try{
		ArrayList<EmployeeUser> employeeUser = new ArrayList<EmployeeUser>();
	} catch (ParseException pe){
		System.err.println();
	}
	private InitialData initialData = new InitialData();

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
