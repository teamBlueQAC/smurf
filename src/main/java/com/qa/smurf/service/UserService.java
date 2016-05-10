package com.qa.smurf.service;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.UserRepository;

@Stateless
public class UserService {
	 
	@Inject
	private UserRepository userRepository;
	
	public void authenticate(String username, String password) {
		for(User user : userRepository.getUser()) {
			//How are we authenticating with no username? maybe email?
			if(user.getEmail().equalsIgnoreCase(username)) {
				
			}
		}
	}
	
	public void addUser(User user) {
		userRepository.persistUser(user);
	}
	
	public boolean userExists(String email) {
		for(User user : userRepository.getUser()) {
			if(user.getEmail().equalsIgnoreCase(email)) {
				return true;
			}
		}
		return false;
	}

}
