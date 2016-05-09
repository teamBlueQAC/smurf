package com.qa.smurf.entities;

import java.util.Date;

import com.qa.smurf.util.OrderStatus;

import junit.framework.TestCase;

public class SupplierOrderTest extends TestCase {

	private SupplierOrder supOrder;
	public SupplierOrderTest(String name) {
		super(name);
		Product product = new Product(0, "", "", "", 0.0, false, "", 0, null, "", 0, 0);
		OrderStatus orderStatus = OrderStatus.PENDING;
		Supplier supplier = new Supplier(new Address("", ""), "");
		supOrder = new SupplierOrder(product, orderStatus, supplier, 0, new Date(), 0);
	}

	public void testGetId() {
		assertNotNull(supOrder.getId());
	}

	public void testSetId() {
		supOrder.setId(1);
		assertEquals(1, supOrder.getId());
	}

	public void testGetOrderStatus() {
		assertNotNull(supOrder.getOrderStatus());
	}

	public void testSetOrderStatus() {
		fail("Not yet implemented");
	}

	public void testGetOrderAmount() {
		assertNotNull(supOrder.getOrderAmount());
	}

	public void testSetOrderAmount() {
		supOrder.setOrderAmount(1);
		assertEquals(1, supOrder.getOrderAmount());
	}

	public void testGetProductID() {
		assertNotNull(supOrder.getProductID());
	}

	public void testSetProductID() {
		Product newProduct = new Product(1, "a", "a", "a", 1.5, false, "a", 0, null, "a", 0, 0);
		supOrder.setProductID(newProduct);
		assertEquals(newProduct, supOrder.getProductID());
	}

	public void testGetDateReceived() {
		assertNotNull(supOrder.getDateReceived());
	}

	public void testSetDateReceived() {
		Date newDate = new Date();
		supOrder.setDateReceived(newDate);
		assertEquals(newDate, supOrder.getDateReceived());
	}

	public void testGetReceivedAmount() {
		assertNotNull(supOrder.getReceivedAmount());
	}

	public void testSetReceivedAmount() {
		supOrder.setReceivedAmount(1);
		assertEquals(1, supOrder.getReceivedAmount());
	}

	public void testGetSupplier() {
		assertNotNull(supOrder.getSupplier());
	}

	public void testSetSupplier() {
		Supplier newSupplier = new Supplier(new Address("a", "a"), "a");
		supOrder.setSupplier(newSupplier);
		assertEquals(newSupplier, supOrder.getSupplier());
	}

}
