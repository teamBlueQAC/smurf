package com.qa.smurf.service;

import javax.inject.Inject;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.CreditRepository;

public class CreditService {
	
	@Inject
	CreditRepository creditRepository;
	
	
	public Credit findByUser(User user){
		return creditRepository.findByUser(user);
	}
	
}