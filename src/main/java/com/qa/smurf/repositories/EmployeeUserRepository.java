/* Made By Dean + Nabs */
package com.qa.smurf.repositories;

import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.EmployeeUserTest;

public interface EmployeeUserRepository {

	public void persistEmployeeUser(EmployeeUserTest eu);

	public void persistEmployeeUsers(List<EmployeeUserTest> eu);

	public EmployeeUserTest findByID(long id);

	public ArrayList<EmployeeUserTest> getEmployeeUsers();

	public void updateEmployeeUser(EmployeeUserTest eu);

	public void removeEmployeeUser(EmployeeUserTest eu);

}
