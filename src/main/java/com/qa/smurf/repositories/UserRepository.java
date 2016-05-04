package com.qa.smurf.repositories;
/**
 *Created by Elliot and Sam
 */
import java.util.ArrayList;
import java.util.List;

import com.qa.smurf.entities.User;

public interface UserRepository {
	public void persistUser(User user);
	public void persistUsers(List<User> user);

	public User findByID(long userId);
	public ArrayList<User> getUser();

	public void updateUser(User user);

	public void removeUser(User user);
}

