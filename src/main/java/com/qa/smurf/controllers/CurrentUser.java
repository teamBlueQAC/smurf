package com.qa.smurf.controllers;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class CurrentUser implements Serializable {

	private static final long serialVersionUID = 1647685390330337075L;
	
	private long userId;

	protected long getUserId() {
		return userId;
	}

	protected void setUserId(long userId) {
		this.userId = userId;
	}	
	
}