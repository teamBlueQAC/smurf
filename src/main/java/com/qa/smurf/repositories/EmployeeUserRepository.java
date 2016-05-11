/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.EmployeeUser;

public interface EmployeeUserRepository {

	public void persistEmployeeUser(EmployeeUser eu);

	public void persistEmployeeUsers(List<EmployeeUser> eu);

	public EmployeeUser findByID(long id);

	public ArrayList<EmployeeUser> getEmployeeUsers();

	public void updateEmployeeUser(EmployeeUser eu);

	public void removeEmployeeUser(EmployeeUser eu);

}
