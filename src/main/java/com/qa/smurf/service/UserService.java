package com.qa.smurf.service;

import javax.ejb.Stateless;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.offline.UserRepositoryOffline;

@Stateless
public class UserService {
	 
	//@Inject
	private UserRepositoryOffline userRepository;
	
	public int authenticate(String username, String password) {
		for(User user : userRepository.getUser()) {
			if(username.equalsIgnoreCase(user.getUsername()) && password.equals(user.getPassword())) {
				return user.getId();
			}
		}
		return -1;
	}
	
	public void addUser(User user) {
		userRepository.persistUser(user);
	}
	
	public boolean userExists(String username) {
		for(User user : userRepository.getUser()) {
			if(user.getUsername().equalsIgnoreCase(username)) {
				return true;
			}
		}
		return false;
	}

}
