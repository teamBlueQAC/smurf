package com.qa.smurf.entities;

import java.util.ArrayList;
import java.util.Date;

import com.qa.smurf.util.OrderStatus;

import junit.framework.TestCase;

public class OrderTest extends TestCase {

	Order order;
	OrderStatus orderStatus = OrderStatus.PENDING;
	public OrderTest(String name) {
		super(name);
		Payment payment = new Payment("", "", "", "", null, null);
		Address address = new Address("", "");
		User user = new User(0, "", "", "", "", "", null, false, address, null);
		order = new Order(0, new Date(), new Date(), payment, address, user, orderStatus);
		ArrayList<LineItems> LineItems = new ArrayList<LineItems>();
		order.setLineItem(LineItems);
	}

	public void testGetId() {
		assertNotNull(order.getId());
	}

	public void testSetId() {
		order.setId(1);
		assertEquals(1, order.getId());
	}

	public void testGetUser() {
		assertNotNull(order.getUser());
	}

	public void testSetUser() {
		User newUser = new User(1, "a", "a", "a", "a", "a", null, false, null, null);
		order.setUser(newUser);
		assertEquals(newUser, order.getUser());
	}

	public void testGetTotal() {
		assertNotNull(order.getTotal());
	}

	public void testSetTotal() {
		double newtotal = 1;
		order.setTotal(newtotal);
		assertEquals(newtotal, order.getTotal());
	}

	public void testGetDate() {
		assertNotNull(order.getDate());
	}

	public void testSetDate() {
		Date newDate = new Date();
		order.setDate(newDate);
		assertEquals(newDate, order.getDate());
	}

	public void testGetDispatchDate() {
		assertNotNull(order.getDispatchDate());
	}

	public void testSetDispatchDate() {
		Date newDispatchDate = new Date();
		order.setDispatchDate(newDispatchDate);
		assertEquals(newDispatchDate, order.getDispatchDate());
	}

	public void testGetOrderStatus() {
		assertNotNull(order.getOrderStatus());
	}
	
	/* - Need to releard how to use enums properly again D=
	public void testSetOrderStatusID() {
		OrderStatus newOrderStatus = OrderStatus.DELIVERED;
		orderStatus = newOrderStatus;
		assertEquals(OrderStatus.DELIVERED, orderStatus.getName());
		
	}
	*/

	public void testGetAddress() {
		assertNotNull(order.getAddress());
	}

	public void testSetAddress() {
		Address newAddress = new Address("a", "a");
		order.setAddress(newAddress);
		assertEquals(newAddress, order.getAddress());
	}

	public void testGetPaymentID() {
		assertNotNull(order.getPaymentID());
	}

	public void testSetPaymentID() {
		Payment newPayment = new Payment("a", "a", "a", "a", null, null);
		order.setPaymentID(newPayment);
		assertEquals(newPayment, order.getPaymentID());
	}

	public void testGetLineItem() {
		assertNotNull(order.getLineItem());
	}

	public void testSetLineItem() {
		ArrayList<LineItems> newLineItems = new ArrayList<LineItems>();
		order.setLineItem(newLineItems);
		assertEquals(newLineItems, order.getLineItem());
		
	}
	/*
	Methods do not actually have logic installed
	public void testSetOrderStatus() {
		fail("Not yet implemented");
	}

	public void testGetOrderLineItems() {
		
	}

	public void testAddLineItem() {
		
	}

	public void testRemoveLineItem() {
		fail("Not yet implemented");
	}
	 */
}
