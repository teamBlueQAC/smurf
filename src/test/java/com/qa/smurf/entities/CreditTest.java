package com.qa.smurf.entities;

import junit.framework.TestCase;

public class CreditTest extends TestCase {
	private Credit credit;	
	
	public CreditTest(String name) {
		super(name);
		credit = new Credit(new User(0, "", "", "", "", null, true, new Address("", ""), null), 0, 0, 1);
	}

	public void testGetUser() {
		assertNotNull(credit.getUser());
	}

	public void testSetUserID() {
		fail("Not yet implemented");
	}

	public void testGetAmount() {
		fail("Not yet implemented");
	}

	public void testSetAmount() {
		fail("Not yet implemented");
	}

	public void testGetAmountRemaining() {
		fail("Not yet implemented");
	}

	public void testSetAmountRemaining() {
		fail("Not yet implemented");
	}

	public void testGetQuarter() {
		fail("Not yet implemented");
	}

	public void testSetQuarter() {
		fail("Not yet implemented");
	}

}
