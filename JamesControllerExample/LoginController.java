package com.qac.nb_gardens_cos.controllers;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value="loginController")
@ConversationScoped
public class LoginController {
	@Inject CustomerService customerService;
	@Inject UserCredentials userCredentials;
	private String username = "";
	private String password = "";
	private String error = "";
	
	public String login(){
		if (username.equals("")){
			error = "please enter a username";
			password = "";
			return "login";
		} if (password.equals("")) {
			error = "please enter a password";
			password = "";
			return "login";
		} if(!customerService.validateDetails(username, password)) {
			error = "Invalid login";
			password = "";
			return "login";
		}
		userCredentials.setUser(customerService.getUserID(username));
		return "home";
	}
	
	public String logout() {
		userCredentials.setUser("");
		return "home";
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

	public String getError() {
		return error;
	}	
}