package com.qa.smurf.entities;

import junit.framework.TestCase;

public class LineItemsTest extends TestCase {

	private LineItems lineItems;
	public LineItemsTest(String name) {
		super(name);
		Product product = new Product(0, "a", "a", "a", null, false, "a", 0, null, "a", 0, 0);
		Order order = new Order(0, null, null, null, null, null, null);
		lineItems = new LineItems(order, product, 0, 0, 0);
	}

	public void testGetOrder() {
		assertNotNull(lineItems.getOrder());
	}

	public void testGetProduct() {
		assertNotNull(lineItems.getProduct());
	}

	public void testGetQuantity() {
		assertNotNull(lineItems.getQuantity());
	}

	public void testGetSubtotal() {
		assertNotNull(lineItems.getSubtotal());
	}

	public void testGetReturnedQty() {
		assertNotNull(lineItems.getReturnedQty());
	}

	public void testSetOrder() {
		Order order = new Order(1, null, null, null, null, null, null);
		lineItems.setOrder(order);
		assertEquals(order, lineItems.getOrder());
	}

	public void testSetProduct() {
		Product product = new Product(1, "", "", "", null, false, "", 0, null, "", 0, 0);
		lineItems.setProduct(product);
		assertEquals(product, lineItems.getProduct());
	}

	public void testSetQuantity() {
		int newQty = 5;
		lineItems.setQuantity(newQty);
		assertEquals(newQty, lineItems.getQuantity());
	}

	public void testSetSubtotal() {
		double newSub = 1.5;
		lineItems.setSubtotal(newSub);
		assertEquals(newSub, lineItems.getSubtotal());
	}

	public void testSetReturnedQty() {
		int newRQty = 5;
		lineItems.setReturnedQty(newRQty);
		assertEquals(newRQty, lineItems.getReturnedQty());
	}

}
