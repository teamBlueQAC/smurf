package com.qa.smurf.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.qa.smurf.entities.Credit;
import com.qa.smurf.service.CreditService;

@Named(value = "credit")
@RequestScoped
public class CreditController {

	@Inject
	private CreditService creditService;
	@Inject
	private CurrentUser currentUser;

	private Credit credit;

	@PostConstruct
	public void init() {
		credit = creditService.findByUserId(currentUser.getUserId());
	}

	public Credit getCredit() {
		return this.credit;
	}
}