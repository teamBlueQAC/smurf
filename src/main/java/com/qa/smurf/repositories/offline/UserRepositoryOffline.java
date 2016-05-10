package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.UserRepository;

/**
 * 
 * @author Nathan Orme
 *
 * Offline Repository for the User Repository
 *
 */
@Default
@Stateless
public class UserRepositoryOffline implements UserRepository {
	@Inject
	private InitialData initialData;

	/**
	 * Adds the user to the storage
	 * @param user - user that gets saved 
	 */
	@Override
	public void persistUser(User user) {
		initialData.addUser(user);

	}

	/**
	 * Adds the user to the storage
	 * @param user - list of user that gets saved 
	 */
	@Override
	public void persistUsers(List<User> user) {
		for (User u : user) {
			initialData.addUser(u);
		}

	}

	/**
	 * Gets the user from the storage
	 * @param id id of the user
	 */
	@Override
	public User findByID(long id) {
		for (User u : initialData.getUsers()) {
			if (u.getId() == id) {
				return u;
			}
		}
		return null;
	}

	/**
	 * Gets all the users.
	 */
	@Override
	public ArrayList<User> getUser() {
		return initialData.getUsers();
	}

	/**
	 * Iterates through the existing list of users,
	 * Then updates the specified user from the list. 
	 * @param user user that gets updated 
	 */
	@Override
	public void updateUser(User user) {
		ArrayList<User> users = initialData.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getId() == user.getId())
				users.set(i, user);
		}
		initialData.setUsers(users);

	}

	/**
	 * Iterates through the existing list of users,
	 * Then removes the specified user from the list. 
	 * @param user user that gets removed 
	 */
	@Override
	public void removeUser(User user) {
		ArrayList<User> users = initialData.getUsers();
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).equals(user))
				users.remove(i);
		}
		initialData.setUsers(users);
	}
}