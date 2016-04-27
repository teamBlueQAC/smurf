package com.qa.smurf.repositories.offline;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.UserRepository;

public class UserRepositoryOffline implements UserRepository {

	@Inject
	private InitialData initialData;

	@Override
	public void persistUser(User user) {
		initialData.addUser(user);

	}

	@Override
	public void persistUsers(List<User> user) {
		for(User u: user){
			initialData.addUser(u);
		}	

	}

	@Override
	public User findByID(int id) {
		for(User u: initialData.getUser()){
			if(u.getId() == id){
				return u;
			}
		}
		return null;
	}

	@Override
	public ArrayList<User> getUser() {
		return initialData.getUser();
	}

	@Override
	public void updateUser(User user) {
		ArrayList<User> users = initialData.getUser();
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getId() == user.getId())
				users.set(i, user);
		}
		initialData.setUser(users);

	}

	@Override
	public void removeUser(User user) {
		ArrayList<User> users = initialData.getUser();
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).equals(user))
				users.remove(i);
		}
		initialData.setUser(users);

	}

}
