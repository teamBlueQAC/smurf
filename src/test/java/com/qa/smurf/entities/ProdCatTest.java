package com.qa.smurf.entities;

import junit.framework.TestCase;

public class ProdCatTest extends TestCase {

	ProdCat prodCat;
	public ProdCatTest(String name) {
		super(name);
		Product product = new Product(0, "", "", "", null, false, "", 0, null, name, 0, 0);
		Category category = new Category(0, "");
		prodCat = new ProdCat(product, category);
	}

	public void testGetProduct() {
		assertNotNull(prodCat.getProduct());
	}

	public void testGetCategory() {
		assertNotNull(prodCat.getCategory());
	}

}
