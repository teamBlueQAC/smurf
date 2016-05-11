package com.qa.smurf.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "currentUser")
@SessionScoped
public class CurrentUser implements Serializable {

	private static final long serialVersionUID = 1647685390330337075L;
	
	private long userId = -1;
	
	private String username;
	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}	
	
}