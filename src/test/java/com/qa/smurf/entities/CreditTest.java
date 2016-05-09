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

	public void testSetUser() {
		User newUser = new User(1, "q", "w", "e", "r", null, true, new Address("t", "y"), null);
		credit.setUser(newUser);
		assertEquals(newUser , credit.getUser());
	}

	public void testGetAmount() {
		assertNotNull(credit.getAmount());
	}

	public void testSetAmount() {
		credit.setAmount(1.5);
		assertEquals(1.5, credit.getAmount());
	}

	public void testGetAmountRemaining() {
		assertNotNull(credit.getAmountRemaining());
	}

	public void testSetAmountRemaining() {
		credit.setAmountRemaining(1.5);
		assertEquals(1.5, credit.getAmountRemaining());
	}

	public void testGetQuarter() {
		assertNotNull(credit.getQuarter());
	}

	public void testSetQuarter() {
		credit.setQuarter(2);
		assertEquals(2, credit.getQuarter());
	}

}
