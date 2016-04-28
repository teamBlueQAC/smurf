package com.qac.nb_gardens_cos.controllers;

import javax.enterprise.context.SessionScoped;

@SessionScoped
public class UserCredentials {
	private String user;
	
	protected String getUser() {
		return user;
	}
	
	protected void setUser(String user) {
		this.user = user;
	}
}