package com.qa.smurf.controller;

import static org.junit.Assert.*;

import org.junit.Test;

import com.qa.smurf.controllers.CurrentUser;

import junit.framework.TestCase;

public class CurrentUserTest extends TestCase {
	
	CurrentUser currentUser = new CurrentUser();

	@Test
	public void testGetUserId() {
		assertNotNull(currentUser.getUserId());
	}

	@Test
	public void testSetUserId() {
		currentUser.setUserId(2);
		assertEquals(2, currentUser.getUserId());
	}

}
