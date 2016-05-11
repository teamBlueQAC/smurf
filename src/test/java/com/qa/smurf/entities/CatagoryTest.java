package com.qa.smurf.entities;

import junit.framework.TestCase;

public class CatagoryTest extends TestCase {

	private Category category;
	public CatagoryTest(String name) {
		super(name);
		category = new Category(0, "");
	}

	public void testGetID() {
		assertNotNull(category.getID());
	}

	public void testGetName() {
		assertNotNull(category.getName());
	}

	public void testSetID() {
		category.setID(1);
		assertEquals(1, category.getID());
	}

	public void testSetName() {
		category.setName("str");
		assertEquals("str", category.getName());
	}

}
