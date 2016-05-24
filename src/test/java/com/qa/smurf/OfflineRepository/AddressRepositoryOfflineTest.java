package com.qa.smurf.OfflineRepository;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Address;
import com.qa.smurf.repositories.offline.AddressRepositoryOffline;

import junit.framework.TestCase;
@RunWith(MockitoJUnitRunner.class)
public class AddressRepositoryOfflineTest extends TestCase {

	
	@Mock
	private InitialData initialData;

	@InjectMocks
	private AddressRepositoryOffline aro; 

	@Test
	public void testPersistAddress() {
	    Address newAddress = new Address("a", "a");
	    ArrayList<Address> addList = new ArrayList<Address>();
	    addList.add(newAddress);
	    
	   aro.persistAddress(newAddress);
	    Mockito.when(initialData.getAddresses()).thenReturn(addList);
	    assertEquals(newAddress, aro.getAddresses().get(0));
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
		Mockito.when(initialData.getAddresses()).thenReturn(newAdds);
		aro.persistAddresses(newAdds);
		assertEquals(ad1, aro.getAddresses().get(aro.getAddresses().size()-3));
		assertEquals(ad2, aro.getAddresses().get(aro.getAddresses().size()-2));
		assertEquals(ad3, aro.getAddresses().get(aro.getAddresses().size()-1));
		
	}
	
	
	@Test
	public void testFindByPostCodeAndLine1() {
		Address address = new Address("a", "a");
		ArrayList<Address> newAdds = new ArrayList<Address>();
		newAdds.add(address);
		aro.findByPostCodeAndLine1(address.getPostcode(), address.getLine1());
		Mockito.when(initialData.getAddresses()).thenReturn(newAdds);
		assertEquals(address, aro.findByPostCodeAndLine1(address.getPostcode(), address.getLine1()));
	}
	
	@Test
	public void testFindByPostCode() {
		ArrayList<Address> newAdds = new ArrayList<Address>();
		ArrayList<Address> compAdds = new ArrayList<Address>();
		Address ad1 = new Address("b", "b");
		Address ad2 = new Address("c", "c");
		Address ad3 = new Address("b", "d");
		newAdds.add(ad1); compAdds.add(ad1);
		newAdds.add(ad2);
		newAdds.add(ad3); compAdds.add(ad3);
		
		Mockito.when(initialData.getAddresses()).thenReturn(newAdds);
		
		ArrayList<Address> newList = aro.findByPostCode("b");
		int i =0;
		for(Address a: newList){
			assertEquals(compAdds.get(i).getPostcode(), a.getPostcode());
		}
	}
	
	@Test
	public void testFindByLine1() {
		ArrayList<Address> newAdds = new ArrayList<Address>();
		ArrayList<Address> compAdds = new ArrayList<Address>();
		Address ad1 = new Address("a", "a");
		Address ad2 = new Address("b", "c");
		Address ad3 = new Address("c", "a");
		newAdds.add(ad1); compAdds.add(ad1);
		newAdds.add(ad2);
		newAdds.add(ad3); compAdds.add(ad3);
		
		Mockito.when(initialData.getAddresses()).thenReturn(newAdds);
		
		ArrayList<Address> newList = aro.findByLine1("a");
		int i =0;
		for(Address a: newList){
			assertEquals(compAdds.get(i).getLine1(), a.getLine1());
		}
	}
	
	@Test
	public void testGetAddresses() {
		ArrayList<Address> newAdds = new ArrayList<Address>();
		Address ad1 = new Address("a", "a");
		newAdds.add(ad1);
		Mockito.when(initialData.getAddresses()).thenReturn(newAdds);
		assertNotNull(aro.getAddresses());
	}

	
	public void testUpdateAddress() {
		fail("Not yet implemented");
	}

	/*
	public void testRemoveAddress() {
		fail("Not yet implemented");
	}
	*/

}
