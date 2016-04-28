package com.qa.smurf.controllers;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class CurrentUser {
	private long userId;

	protected long getUserId() {
		return userId;
	}

	protected void setUserId(long userId) {
		this.userId = userId;
	}	
}