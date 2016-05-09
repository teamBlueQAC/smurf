package com.qa.smurf.entities;

import junit.framework.TestCase;

public class EmployeeUserTest extends TestCase {

	private EmployeeUser employeeUser;
	
	public EmployeeUserTest(String name) {
		super(name);
		employeeUser = new EmployeeUser("");
	}


	public void testGetID() {
		assertNotNull(employeeUser.getID());
	}
	
	public void testSetID(){
		employeeUser.setID(1);
		assertEquals(1, employeeUser.getID());
	}
	
	public void testSetName(){
		employeeUser.setName("abc");
		assertEquals("abc", employeeUser.getName());
	}

	public void testGetName() {
		assertNotNull("abc", employeeUser.getName());
	}

}
