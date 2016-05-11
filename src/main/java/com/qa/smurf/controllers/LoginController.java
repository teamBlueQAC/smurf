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
	
	private String username;
	private String password;
	
	@Inject
	private CurrentUser currentUser;
	
	public void login() {
		int id = userService.authenticate(username, password);
		
		if(id != -1) {
			currentUser.setUserId(id);
		} else {
			logout();
		}
	}
	
	public void logout() {
		username = null;
		password = null;
		currentUser.setUserId(-1);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isLoggedIn() {
		return username != null;
	}

}
