package com.qa.smurf.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.User;
import com.qa.smurf.service.UserService;

@Named(value = "register")
@RequestScoped
public class RegisterController {
	
	@Inject
	private UserService userService;
	
	private User user;
	
	@PostConstruct
	public void init() {
		user = new User();
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void submit() {
		userService.addUser(user);
	}	

}
