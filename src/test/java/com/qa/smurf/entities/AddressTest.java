package com.qa.smurf.entities;

import junit.framework.TestCase;

public class AddressTest extends TestCase {

	private Address address;
	public AddressTest(String name) {
		super(name);
		address = new Address("", "", "", "", "");
	}
	
	public void testGetLine1(){
		address.getLine1();
	}
	
	public void testSetLine1(){
		address.setLine1("str");
		assertEquals("str", address.getLine1());
	}
	
	public void testGetLine2(){
		assertNotNull(address.getLine2());
	}
	
	public void testSetline2(){
		address.setLine2("str");
		assertEquals("str", address.getLine2());
	}
	
	public void testGetLine3(){
		address.getLine3();
	}
	
	public void testSetLine3(){
		address.setLine3("str");
		assertEquals("str", address.getLine3());
	}
	
	public void testGetLine4(){
		assertNotNull(address.getLine4());
	}
	
	public void testSetline4(){
		address.setLine4("str");
		assertEquals("str", address.getLine4());
	}
	
	public void testGetPostcode(){
		assertNotNull(address.getPostcode());
	}
	
	public void testSetPostcode(){
		address.setPostcode("str");
		assertEquals("str", address.getPostcode());
	}

}
