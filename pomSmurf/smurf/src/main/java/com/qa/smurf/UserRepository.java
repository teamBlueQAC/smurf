/* Made By Dean + Nabs */
package com.qa.smurf;

import java.util.ArrayList;
import java.util.List;

public interface UserRepository {
	public void persistUser(User u);

	public void persistUsers(List<User> u);

	public User findByID(long id);

	public ArrayList<User> getUsers();

	public void updateUser(User u);

}
