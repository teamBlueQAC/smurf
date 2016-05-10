package com.qa.smurf.controllers;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

@Named(value = "user")
@RequestScoped
public class UserController {
	
	private CurrentUser currentUser;
	
	private String username;
	private String password;
	
	public CurrentUser getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}

	public String login() {			
		currentUser = new CurrentUser();
		currentUser.setUserId(1);
		System.out.println("Logged in");
		return "aboutus";		
	}
	
	public String logout() {		
		currentUser = null;
		return "homepage";
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
	
}

