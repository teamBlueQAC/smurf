package com.qa.smurf.service;

import javax.inject.Inject;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.repositories.CreditRepository;
import com.qa.smurf.repositories.UserRepository;

public class CreditService {
	@Inject private CreditRepository creditRepository;
	@Inject private UserRepository userRepository;
	
	public Credit findByUserId(long id){
		return creditRepository.findByUser(userRepository.findByID(id));
	}
	
}