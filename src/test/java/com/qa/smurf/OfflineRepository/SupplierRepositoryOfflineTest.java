package com.qa.smurf.OfflineRepository;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Address;
import com.qa.smurf.entities.Supplier;
import com.qa.smurf.repositories.offline.SupplierRepositoryOffline;

@RunWith(MockitoJUnitRunner.class)
public class SupplierRepositoryOfflineTest {

	
	@Mock
	private InitialData initialData;
	
	@InjectMocks
	private SupplierRepositoryOffline sro;
	
	@Test
	public void testPersistSupplierOrder() {
		Supplier supplier = new Supplier(new Address("0", "0"), "0");
		ArrayList<Supplier> supList = new ArrayList<Supplier>();
		supList.add(supplier);
		
		Mockito.when(initialData.getSuppliers()).thenReturn(supList);
		sro.persistSupplier(supplier);
		assertNotNull(sro.getSuppliers());
	}

	@Test
	public void testPersistSupplierOrders() {
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		
		Supplier supplier0 = new Supplier(address0, "0");
		Supplier supplier1 = new Supplier(address1, "0");
		Supplier supplier2 = new Supplier(address2, "0");
		
		ArrayList<Supplier> supList = new ArrayList<Supplier>();
		supList.add(supplier0); supList.add(supplier1); supList.add(supplier2);
		
		Mockito.when(initialData.getSuppliers()).thenReturn(supList);
		sro.persistSuppliers(supList);
		assertEquals(sro.getSuppliers().size(), 3);
	}

	@Test
	public void testFindByID() {
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		
		Supplier supplier0 = new Supplier(address0, "0");
		Supplier supplier1 = new Supplier(address1, "0");
		Supplier supplier2 = new Supplier(address2, "0");
		
		ArrayList<Supplier> supList = new ArrayList<Supplier>();
		supList.add(supplier0); supList.add(supplier1); supList.add(supplier2);
		supplier0.setId(0); supplier1.setId(1); supplier2.setId(2);
		Mockito.when(initialData.getSuppliers()).thenReturn(supList);
		
		assertEquals(sro.findByID(1), supplier1);
	}

	@Test
	public void testFindBySupplier() {
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		
		Supplier supplier0 = new Supplier(address0, "0");
		Supplier supplier1 = new Supplier(address1, "0");
		Supplier supplier2 = new Supplier(address2, "0");
		
		ArrayList<Supplier> supList = new ArrayList<Supplier>();
		supList.add(supplier0); supList.add(supplier1); supList.add(supplier2);
		supplier0.setId(0); supplier1.setId(1); supplier2.setId(2);
		Mockito.when(initialData.getSuppliers()).thenReturn(supList);
		
		assertEquals(sro, supplier1);
	}

	@Test
	public void testFindByProduct() {
		/*Can't find a find by product method in SupplierRepositoryOffline class*/
	}

	@Test
	public void testFindByOrderStatus() {
		/*Can't find a find by OrderStatus method in SupplierRepositoryOffline class*/
	}

	@Test
	public void testGetSupplierOrders() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateSupplierOrder() {
		/* No business logic in this method*/
	}

	@Test
	public void testRemoveSupplierOrder() {
		/* No business logic in this method*/
	}

}
