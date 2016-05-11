package com.qa.smurf.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named(value = "currentUser")
@SessionScoped
public class CurrentUser implements Serializable {

	private static final long serialVersionUID = 1647685390330337075L;
	
	private long userId = 1;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}	
	
}