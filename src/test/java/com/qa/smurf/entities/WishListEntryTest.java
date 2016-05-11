package com.qa.smurf.entities;

import java.util.Date;

import com.qa.smurf.util.ProductType;

import junit.framework.TestCase;

public class WishListEntryTest extends TestCase {

	WishListEntry wishListEntry;
	public WishListEntryTest(String name) {
		super(name);
		Product product = new Product(0, "", "", "", 0.0, false, "", 0, ProductType.GNOME, "", 0, 0);
		User user = new User(0, "", "", "", "", "", new Date(), false, new Address("", ""), new Date());
		wishListEntry = new WishListEntry(product, new Date(), user);
	}

	public void testGetProduct() {
		assertNotNull(wishListEntry.getProduct());
	}

	public void testSetProduct() {
		Product newProduct = new Product(1, "a", "a", "a", 1.5, false, "a", 0, ProductType.GNOME, "a", 0, 0);
		wishListEntry.setProduct(newProduct);
		assertEquals(newProduct, wishListEntry.getProduct());
	}

	public void testGetUser() {
		assertNotNull(wishListEntry.getUser());
	}

	public void testSetUser() {
		User newUser = new User(1, "a", "a", "a","a", "a", new Date(), false, new Address("a", "a"), new Date());
		wishListEntry.setUser(newUser);
		assertEquals(newUser, wishListEntry.getUser());
	}

	public void testGetDateAdded() {
		assertNotNull(wishListEntry.getDateAdded());
	}

	public void testSetDateAdded() {
		Date newDate = new Date();
		wishListEntry.setDateAdded(newDate);
		assertEquals(newDate, wishListEntry.getDateAdded());
	}

	public void testGetId() {
		assertNotNull(wishListEntry.getId());
	}

}
