package com.qa.smurf.service;

import javax.inject.Inject;

import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.offline.UserRepositoryOffline;

public class UserService {
	 
	@Inject
	private UserRepositoryOffline userRepositoryOffline;
	
	public void authenticate(String username, String password) {
		for(User user : userRepositoryOffline.getUser()) {
			//How are we authenticating with no username? maybe email?
			if(user.getEmail().equalsIgnoreCase(username)) {
				
			}
		}
	}
	
	public void addUser(User user) {
		userRepositoryOffline.persistUser(user);
	}
	
	public boolean userExists(String email) {
		for(User user : userRepositoryOffline.getUser()) {
			if(user.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

}
