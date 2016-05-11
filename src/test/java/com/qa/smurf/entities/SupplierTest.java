package com.qa.smurf.entities;

import junit.framework.TestCase;

public class SupplierTest extends TestCase {

	private Supplier supplier;
	public SupplierTest(String name) {
		super(name);
		supplier = new Supplier(new Address("", ""), "");
	}

	public void testSetId() {
		supplier.setId(1);
		assertEquals(1, supplier.getId());
	}

	public void testGetId() {
		assertNotNull(supplier.getId());
	}
	
	public void testGetName() {
		assertNotNull(supplier.getName());
	}

	public void testSetName() {
		supplier.setName("a");
		assertEquals("a", supplier.getName());
	}

	public void testGetAddress() {
		assertNotNull(supplier.getAddress());
	}

	public void testSetAddress() {
		Address newAddress = new Address("a", "a");
		supplier.setAddress(newAddress);
		assertEquals(newAddress, supplier.getAddress());
	}

}
