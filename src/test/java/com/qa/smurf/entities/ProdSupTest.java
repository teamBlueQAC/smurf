package com.qa.smurf.entities;

import junit.framework.TestCase;

public class ProdSupTest extends TestCase {

	ProdSup prodSup;
	public ProdSupTest(String name) {
		super(name);
		Supplier supplier = new Supplier(new Address("", ""), "");
		Product product = new Product(0, "", "", "", null, false, "", 0, null, "", 0, 0);
		prodSup = new ProdSup(supplier, product, 0);
	}

	public void testGetSupplier() {
		assertNotNull(prodSup.getSupplier());
	}

	public void testGetProduct() {
		assertNotNull(prodSup.getProduct());
	}

	public void testGetCost() {
		assertNotNull(prodSup.getCost());
	}

	public void testSetCost() {
		prodSup.setCost(1.5);
		assertEquals(1.5, prodSup.getCost());
	}

}
