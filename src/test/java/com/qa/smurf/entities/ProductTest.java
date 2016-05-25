package com.qa.smurf.entities;

import com.qa.smurf.util.ProductType;
import junit.framework.TestCase;

public class ProductTest extends TestCase {

	Product product;
	public ProductTest(String name) {
		super(name);
		ProductType prodType = ProductType.GNOME;
		product = new Product(0, "", "", "", 0.0, false, "", 0, prodType, "", 0, 0);
	}

	public void testGetId() {
		assertNotNull(product.getId());
	}

	public void testSetId() {
		product.setId(1);
		assertEquals(1, product.getId());
	} 

	public void testGetName() {
		assertNotNull(product.getName());
	}

	public void testSetName() {
		product.setName("a");
		assertEquals("a", product.getName());
	}

	public void testGetSerial() {
		assertNotNull(product.getSerial());
	}

	public void testSetSerial() {
		product.setSerial("a");
		assertEquals("a", product.getSerial());
	}

	public void testGetColour() {
		assertNotNull(product.getColour());
	}

	public void testSetColour() {
		product.setColour("a");
		assertEquals("a", product.getColour());
	}

	public void testGetPrice() {
		assertNotNull(product.getPrice());
	}

	public void testSetPrice() {
		product.setPrice(1.5);
		assertEquals(1.5, product.getPrice());
	}

	public void testIsDiscountinued() {
		assertNotNull(product.isDiscountinued());
	}

	public void testSetDiscountinued() {
		product.setDiscountinued(true);
		assertTrue(product.isDiscountinued());

	}

	public void testGetPictureLoc() {
		assertNotNull(product.getPictureLoc());
	}

	public void testSetPictureLoc() {
		product.setPictureLoc("a");
		assertEquals("a", product.getPictureLoc());
	}

	public void testGetQuantityAvailable() {
		assertNotNull(product.getQuantityAvailable());
	}

	public void testSetQuantityAvailable() {
		product.setQuantityAvailable(1);
		assertEquals(1, product.getQuantityAvailable());
	}

	public void testGetProductType() {
		assertNotNull(product.getProductType());
	}

	public void testSetProductType() {
		assertEquals(ProductType.GNOME, product.getProductType());
	}

	public void testGetDescription() {
		assertNotNull(product.getDescription());
	}

	public void testSetDescription() {
		product.setDescription("a");
		assertEquals("a", product.getDescription());
	}

	public void testGetReorderThreshold() {
		assertNotNull(product.getReorderThreshold());
	}

	public void testSetReorderThreshold() {
		product.setReorderThreshold(1);
		assertEquals(1, product.getReorderThreshold());
	}

	public void testGetReorderedAmount() {
		assertNotNull(product.getReorderedAmount());
	}

	public void testSetReorderedAmount() {
		product.setReorderedAmount(1);
		assertEquals(1, product.getReorderedAmount());
	}

}
