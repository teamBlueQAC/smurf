package com.qa.smurf.entities;

import java.util.Date;

import junit.framework.TestCase;

public class UserTest extends TestCase {
	
	User user;
	public UserTest(String name) {
		super(name);
		user = new User(0, "", "", "", "", new Date(), false, new Address("", ""), new Date());
	}

	public void testGetId() {
		assertNotNull(user.getId());
	}

	public void testSetId() {
		user.setId(1);
		assertEquals(1, user.getId());
	}

	public void testGetName() {
		assertNotNull(user.getName());
	}

	public void testSetName() {
		user.setName("a");
		assertEquals("a", user.getName());
	}

	public void testGetPassword() {
		assertNotNull(user.getPassword());
	}

	public void testSetPassword() {
		user.setPassword("a");
		assertEquals("a", user.getPassword());
	}

	public void testGetEmail() {
		assertNotNull(user.getEmail());
	}

	public void testSetEmail() {
		user.setEmail("a");
		assertEquals("a", user.getEmail());
	}

	public void testGetPhone() {
		assertNotNull(user.getPhone());
	}

	public void testSetPhone() {
		user.setPhone("a");
		assertEquals("a", user.getPhone());
	}

	public void testGetLastLogin() {
		assertNotNull(user.getLastLogin());
	}

	public void testSetLastLogin() {
		Date newDate = new Date();
		user.setLastLogin(newDate);
		assertEquals(newDate, user.getLastLogin());
		
	}

	public void testIsActivate() {
		assertFalse(user.isActivate());
	}

	public void testSetActivate() {
		user.setActivate(true);
		assertTrue(user.isActivate());
	}

	public void testSetAddress() {
		Address newAddress = new Address("a", "a");
		user.setAddress(newAddress);
		assertEquals(newAddress, user.getAddress());
	}
	
	public void testGetAddress() {
		assertNotNull(user.getAddress());
	}

	public void testGetCreated() {
		assertNotNull(user.getCreated());
	}

	public void testSetCreated() {
		Date newDate = new Date();
		user.setCreated(newDate);
		assertEquals(newDate, user.getCreated());
	}

}
