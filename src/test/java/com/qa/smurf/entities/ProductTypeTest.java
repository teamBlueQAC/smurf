package com.qa.smurf.entities;

import junit.framework.TestCase;

public class ProductTypeTest extends TestCase {

	private ProductType prodType;
	public ProductTypeTest(String name) {
		super(name);
		prodType = new ProductType(0, "");
	}

	public void testGetId() {
		assertNotNull(prodType.getId());
	}

	public void testGetName() {
		assertNotNull(prodType.getName());
	}

	public void testSetName() {
		prodType.setName("a");
		assertEquals("a", prodType.getName());
	}

}
