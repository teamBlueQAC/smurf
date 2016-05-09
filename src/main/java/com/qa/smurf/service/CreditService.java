package com.qa.smurf.service;

import javax.inject.Inject;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.repositories.CreditRepository;
import com.qa.smurf.repositories.UserRepository;

public class CreditService {
	
	@Inject
	CreditRepository creditRepository;
	@Inject
	UserRepository userRepository;
	
	
	public Credit findByUserId(long id){
		return creditRepository.findByUser(userRepository.findByID(id));
	}
	
}