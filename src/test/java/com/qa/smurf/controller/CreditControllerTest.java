package com.qa.smurf.controller;

import javax.inject.Inject;
import org.junit.Test;
import com.qa.smurf.controllers.CreditController;
import com.qa.smurf.controllers.CurrentUser;
import junit.framework.TestCase;

public class CreditControllerTest extends TestCase {
	
	@Inject
	private CurrentUser currentUser;

	CreditController creditControllerTest = new CreditController();
	
	
	public void initTest(){
		creditControllerTest.init();
	}
	
	@Test
	public void getCreditTest(){
		currentUser.setUserId(1);
		assertNotNull(creditControllerTest.getCredit());
	}

}
