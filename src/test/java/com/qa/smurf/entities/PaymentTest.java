package com.qa.smurf.entities;

import junit.framework.TestCase;

public class PaymentTest extends TestCase {

	Payment payment;
	public PaymentTest(String name) {
		super(name);
		Address address = new Address("", "");
		User user = new User(0, "", "", "", "", "", null, false, address, null);
		payment = new Payment("", "", "", "", address, user);
	}

	public void testGetId() {
		assertNotNull(payment.getId());
	}

	public void testSetId() {
		payment.setId(1);
		assertEquals(1, payment.getId());
	}

	public void testGetCardNumber() {
		assertNotNull(payment.getCardNumber());
	}

	public void testSetCardNumber() {
		payment.setCardNumber("a");
		assertEquals("a", payment.getCardNumber());
	}

	public void testGetCardType() {
		assertNotNull(payment.getCardType());
	}

	public void testSetCardType() {
		payment.setCardType("a");
		assertEquals("a", payment.getCardType());
	}

	public void testGetExpiryDate() {
		assertNotNull(payment.getExpiryDate());
	}

	public void testSetExpiryDate() {
		payment.setExpiryDate("a");
		assertEquals("a", payment.getExpiryDate());
	}

	public void testGetNameOnCard() {
		assertNotNull(payment.getNameOnCard());
	}

	public void testSetNameOnCard() {
		payment.setNameOnCard("a");
		assertEquals("a", payment.getNameOnCard());
	}

	public void testGetUser() {
		assertNotNull(payment.getUser());
	}

	public void testSetUser() {
		User newUser = new User(1, "a", "a", "a", "a", "a", null, false, null, null);
		payment.setUser(newUser);
		assertEquals(newUser, payment.getUser());
	}

	public void testGetAddress() {
		assertNotNull(payment.getAddress());
	}

	public void testSetAddress() {
		Address newAddress = new Address("a", "a");
		payment.setAddress(newAddress);
		assertEquals(newAddress, payment.getAddress());
	}

}
