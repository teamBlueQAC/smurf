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
import com.qa.smurf.util.ProductType;
@RunWith(MockitoJUnitRunner.class)
public class ProductRepositoryOfflineTest {

	@Mock
	private InitialData initialData;
	
	@InjectMocks
	private ProductRepositoryOffline pro;
	
	
	@Test
	public void testPersistProduct() {
		Product product = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/ProductType.GNOME, "", 0, 0);
		ArrayList<Product> productList = new ArrayList<Product>(); 
		productList.add(product);
		
		Mockito.when(initialData.getProducts()).thenReturn(productList);
		pro.persistProduct(product);
		//assertEquals(pro.getProducts().get(0), product);
		Mockito.verify(initialData).addProduct(product);
	}

	@Test
	public void testPersistProducts() {
		Product product0 = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/ProductType.GNOME, "", 0, 0);
		Product product1 = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/ProductType.FURNITURE, "", 0, 0);
		Product product2 = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/ProductType.SEED, "", 0, 0);
		
		ArrayList<Product> productList = new ArrayList<Product>(); 
		productList.add(product0);
		productList.add(product1); 
		productList.add(product2);
		
		Mockito.when(initialData.getProducts()).thenReturn(productList);
		pro.persistProducts(productList);
		assertEquals(pro.getProducts(), productList);
		Mockito.verify(initialData).addProduct(product2);
	}

	@Test
	public void testFindByID() {
		Product product0 = new Product(0, "", "", "", 0.0, true, "", 0, ProductType.GNOME, "", 0, 0);
		Product product1 = new Product(1, "", "", "", 0.0, true, "", 0, ProductType.FURNITURE, "", 0, 0);
		Product product2 = new Product(2, "", "", "", 0.0, true, "", 0, ProductType.SEED, "", 0, 0);
		
		
		ArrayList<Product> productList = new ArrayList<Product>(); 
		productList.add(product0);
		productList.add(product1);
		productList.add(product2);
		
		
		
		Mockito.when(initialData.getProducts()).thenReturn(productList);
		//System.out.println(initialData.getProducts().size());
		assertEquals(pro.findByID(product2.getId()), product2);
	}

	@Test
	public void testFindByName() {
		Product product0 = new Product(0, "0", "0", "0", 0.0, true, "0", 0, /*Product type*/ProductType.GNOME, "0", 0, 0);
		Product product1 = new Product(0, "1", "1", "1", 0.0, true, "", 0, /*Product type*/ProductType.FURNITURE, "1", 0, 0);
		Product product2 = new Product(0, "2", "2", "2", 0.0, true, "", 0, /*Product type*/ProductType.SEED, "2", 0, 0);
		
		
		ArrayList<Product> productList = new ArrayList<Product>(); 
		productList.add(product0); productList.add(product1); productList.add(product2);
		
		Mockito.when(initialData.getProducts()).thenReturn(productList);
		assertEquals(pro.findByName(product2.getName()), product2);
	}

	@Test
	public void testGetProducts() {
		Product product = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/null, "", 0, 0);
		ArrayList<Product> productList = new ArrayList<Product>(); 
		productList.add(product);
		
		Mockito.when(initialData.getProducts()).thenReturn(productList);
		assertNotNull(pro.getProducts());
		Mockito.verify(initialData).addProduct(product);
	}

	@Test
	public void testUpdateProduct() {
		
	}

	@Test
	public void testRemoveProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByType() {
		Product product0 = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/ProductType.GNOME, "", 0, 0);
		Product product1 = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/ProductType.FURNITURE, "", 0, 0);
		Product product2 = new Product(0, "", "", "", 0.0, true, "", 0, /*Product type*/ProductType.SEED, "", 0, 0);
		
		ArrayList<Product> productList = new ArrayList<Product>(); 
		productList.add(product0); productList.add(product1); productList.add(product2);
		
		Mockito.when(initialData.getProducts()).thenReturn(productList);
		assertEquals(pro.findByType(product0.getProductType()), product0);
	}

}
