package com.qa.smurf;
/**
 *Created by Elliot and Sam
 */
import java.util.ArrayList;
import java.util.List;

public interface UserRepository {
	public void persistUser(User user);
	public void persistUsers(List<User> user);

	public User findByID(int id);
	public ArrayList<User> getUser();

	public void updateUser(User user);

	public void removeUser(User user);
}

