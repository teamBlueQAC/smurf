package com.qa.smurf.OfflineRepository;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.qa.smurf.entities.Address;
import com.qa.smurf.repositories.offline.AddressRepositoryOffline;

import junit.framework.TestCase;

public class AddressRepositoryOfflineTest extends TestCase {

	AddressRepositoryOffline aro = new AddressRepositoryOffline();
	@Test
	public void testPersistAddress() {
		Address newAddress = new Address("a", "a");
		aro.persistAddress(newAddress);
		assertEquals(newAddress, aro.getAddresses().get(aro.getAddresses().size()-1));
	}

	@Test
	public void testPersistAddresses() {
		ArrayList<Address> newAdds = new ArrayList<Address>();
		Address ad1 = new Address("b", "b");
		Address ad2 = new Address("c", "c");
		Address ad3 = new Address("d", "d");
		
		newAdds.add(ad1);
		newAdds.add(ad2);
		newAdds.add(ad3);
		aro.persistAddresses(newAdds);
		assertEquals(ad1, aro.getAddresses().get(aro.getAddresses().size()-3));
		assertEquals(ad2, aro.getAddresses().get(aro.getAddresses().size()-2));
		assertEquals(ad3, aro.getAddresses().get(aro.getAddresses().size()-1));
	}

	@Test
	public void testFindByPostCodeAndLine1() {
		assertNotNull(aro.findByPostCodeAndLine1("b", "b"));
	}

	@Test
	public void testFindByPostCode() {
		assertNotNull(aro.findByPostCode("c"));
	}

	@Test
	public void testFindByLine1() {
		assertNotNull(aro.findByLine1("a"));
	}

	@Test
	public void testGetAddresses() {
		assertNotNull(aro.getAddresses());
	}

	/*
	public void testUpdateAddress() {
		fail("Not yet implemented");
	}

	
	public void testRemoveAddress() {
		fail("Not yet implemented");
	}
	*/

}
