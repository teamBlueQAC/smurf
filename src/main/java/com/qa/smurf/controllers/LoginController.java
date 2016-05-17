package com.qa.smurf.controllers;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.service.UserService;

@Named(value = "login")
@RequestScoped
public class LoginController {
	
	@Inject
	private UserService userService;
	
	@Inject
	private CurrentUser currentUser;
	
	public void submit() {
		int id = userService.authenticate(currentUser.getUsername(), currentUser.getPassword());
		
		if(id != -1) {
			currentUser.setUserId(id);
		} else {
			logout();
		}
	}
	
	public String logout() {
		currentUser.setUsername(null);
		currentUser.setPassword(null);
		currentUser.setUserId(-1);
		return "homeXX";
	}
	
	public boolean isLoggedIn() {	
		return currentUser.getUserId() != -1 ? true : false;
	}

}
