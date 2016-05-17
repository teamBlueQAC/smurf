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
import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.offline.ProductRepositoryOffline;
@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryOfflineTest {

	@Mock
	private InitialData initialData;
	
	@InjectMocks
	private ProductRepositoryOffline pro;
	
	
	@Test
	public void testPersistProduct() {
		Product product = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/null, "", 0, 0);
		ArrayList<Product> productList = new ArrayList<Product>(); productList.add(product);
		
		Mockito.when(initialData.getProducts()).thenReturn(productList);
		pro.persistProduct(product);
		assertEquals(pro.getProducts().get(0), product);
	}

	@Test
	public void testPersistProducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByID() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProducts() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByType() {
		fail("Not yet implemented");
	}

}
