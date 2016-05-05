package com.qa.smurf.controllers;

import javax.inject.Inject;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.User;
import com.qa.smurf.service.CreditService;

public class CreditController {
	
	@Inject
	CreditService creditService;
	
	public Credit findByUser(User user){
		return creditService.findByUser(user);
	}
}