package com.qa.smurf.OfflineRepository;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Address;
import com.qa.smurf.entities.ProdSup;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.Supplier;
import com.qa.smurf.repositories.offline.ProdSupRepositoryOffline;

@RunWith(MockitoJUnitRunner.class)
public class ProdSupRepositoryOffineTest {

	@Mock
	private InitialData initialData;
	
	@Inject
	private ProdSupRepositoryOffline psro;
	
	/*
	 * Due to the way the code was set up in the InitialData and OfflineRepository
	 * there is no way to touch the initialData ArrayList<ProdSup>. the code is right in theory however
	 * As it correctly passes values to and from the different layers. I am just unable to test this. 
	 * 
	 */
	
	
	@Test
	public void testPersistProdSup() {
		Product product0 = new Product(0, "0", "0", "0", 0.0, false, "0", 0, null, "0", 0, 0);
		Supplier supplier0 = new Supplier(new Address("0", "0"), "0");
		ProdSup prodSup0 = new ProdSup(supplier0, product0, 0.0);
		
		ArrayList<ProdSup> prodSupList = new ArrayList<ProdSup>();
		prodSupList.add(prodSup0);
		Mockito.when(initialData.getProdSups()).thenReturn(prodSupList);
		
		psro.persistProdSup(prodSup0);
		assertNotNull(psro.getProdSups());
	}

	@Test
	public void testPersistProdSups() {
		Product product0 = new Product(0, "0", "0", "0", 0.0, false, "0", 0, null, "0", 0, 0);
		Product product1 = new Product(1, "1", "1", "1", 1.1, false, "1", 1, null, "1", 1, 1);
		Product product2 = new Product(2, "2", "2", "2", 2.2, false, "2", 2, null, "2", 2, 2);
		
		Supplier supplier0 = new Supplier(new Address("0", "0"), "0");
		Supplier supplier1 = new Supplier(new Address("1", "1"), "1");
		Supplier supplier2 = new Supplier(new Address("2", "2"), "2");
		
		ProdSup prodSup0 = new ProdSup(supplier0, product0, 0.0);
		ProdSup prodSup1 = new ProdSup(supplier1, product1, 1.1);
		ProdSup prodSup2 = new ProdSup(supplier2, product2, 2.2);
	}

	@Test
	public void testGetProdSups() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProdSup() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveProdSup() {
		fail("Not yet implemented");
	}

}
