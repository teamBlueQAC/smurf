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
import com.qa.smurf.entities.Category;
import com.qa.smurf.entities.ProdCat;
import com.qa.smurf.entities.Product;
import com.qa.smurf.repositories.offline.ProdCatRepositoryOffline;

@RunWith(MockitoJUnitRunner.class)
public class ProdCatRepositoryOfflineTest {

	@Mock
	private InitialData initialData;
	
	@InjectMocks
	private ProdCatRepositoryOffline pcro;
	
	
	@Test
	public void testPersistProdCat() {
		Product product = new Product(0, "", "", "", 0.0, false, "", 0, null, "", 0, 0);
		Category category = new Category(0, "");
		ProdCat prodCat = new ProdCat(product, category);
		ArrayList<ProdCat> prodCatList = new ArrayList<ProdCat>();
		
		
		Mockito.when(initialData.getProdCats()).thenReturn(prodCatList);
		pcro.persistProdCat(prodCat);
		assertNotNull(pcro.getProdCats());
	}

	@Test
	public void testPersistProdCats() {
		Product product0 = new Product(0, "0", "0", "0", 0.0, false, "0", 0, null, "0", 0, 0);
		Product product1 = new Product(1, "1", "1", "1", 1.1, false, "1", 1, null, "1", 1, 1);
		Product product2 = new Product(2, "2", "2", "2", 2.2, false, "2", 2, null, "2", 2, 2);
		
		Category category0 = new Category(0, "0");
		Category category1 = new Category(1, "1");
		Category category2 = new Category(2, "2");
		
		ProdCat prodCat0 = new ProdCat(product0, category0);
		ProdCat prodCat1 = new ProdCat(product1, category1);
		ProdCat prodCat2 = new ProdCat(product2, category2);
		
		ArrayList<ProdCat> prodCatList = new ArrayList<ProdCat>();
		prodCatList.add(prodCat0); prodCatList.add(prodCat1); prodCatList.add(prodCat2);
		
		Mockito.when(initialData.getProdCats()).thenReturn(prodCatList);
		pcro.persistProdCats(prodCatList);
		assertEquals(pcro.getProdCats().get(1), prodCat1);
	}

	@Test
	public void testFindByCategory() {
		Product product0 = new Product(0, "0", "0", "0", 0.0, false, "0", 0, null, "0", 0, 0);
		Product product1 = new Product(1, "1", "1", "1", 1.1, false, "1", 1, null, "1", 1, 1);
		Product product2 = new Product(2, "2", "2", "2", 2.2, false, "2", 2, null, "2", 2, 2);
		
		Category category0 = new Category(0, "0");
		Category category1 = new Category(1, "1");
		Category category2 = new Category(2, "2");
		
		ProdCat prodCat0 = new ProdCat(product0, category0);
		ProdCat prodCat1 = new ProdCat(product1, category1);
		ProdCat prodCat2 = new ProdCat(product2, category2);
		
		ArrayList<ProdCat> prodCatList = new ArrayList<ProdCat>();
		prodCatList.add(prodCat0); prodCatList.add(prodCat1); prodCatList.add(prodCat2);
		
		Mockito.when(initialData.getProdCats()).thenReturn(prodCatList);
		assertEquals(pcro.findByCategory(category1).get(0), product1);
	}

	@Test
	public void testFindByProduct() {
		Product product0 = new Product(0, "0", "0", "0", 0.0, false, "0", 0, null, "0", 0, 0);
		Product product1 = new Product(1, "1", "1", "1", 1.1, false, "1", 1, null, "1", 1, 1);
		Product product2 = new Product(2, "2", "2", "2", 2.2, false, "2", 2, null, "2", 2, 2);
		
		Category category0 = new Category(0, "0");
		Category category1 = new Category(1, "1");
		Category category2 = new Category(2, "2");
		
		ProdCat prodCat0 = new ProdCat(product0, category0);
		ProdCat prodCat1 = new ProdCat(product1, category1);
		ProdCat prodCat2 = new ProdCat(product2, category2);
		
		ArrayList<ProdCat> prodCatList = new ArrayList<ProdCat>();
		prodCatList.add(prodCat0); prodCatList.add(prodCat1); prodCatList.add(prodCat2);
		
		Mockito.when(initialData.getProdCats()).thenReturn(prodCatList);
		assertEquals(pcro.findByProduct(product1).get(0), category1);
	}

	@Test
	public void testGetProdCats() {
		Product product = new Product(0, "", "", "", 0.0, false, "", 0, null, "", 0, 0);
		Category category = new Category(0, "");
		ProdCat prodCat = new ProdCat(product, category);
		ArrayList<ProdCat> prodCatList = new ArrayList<ProdCat>();
		
		
		Mockito.when(initialData.getProdCats()).thenReturn(prodCatList);
		pcro.persistProdCat(prodCat);
		assertNotNull(pcro.getProdCats());
	}

	@Test
	public void testRemoveProdCat() {
		Product product0 = new Product(0, "0", "0", "0", 0.0, false, "0", 0, null, "0", 0, 0);
		Product product1 = new Product(1, "1", "1", "1", 1.1, false, "1", 1, null, "1", 1, 1);
		Product product2 = new Product(2, "2", "2", "2", 2.2, false, "2", 2, null, "2", 2, 2);
		
		Category category0 = new Category(0, "0");
		Category category1 = new Category(1, "1");
		Category category2 = new Category(2, "2");
		
		ProdCat prodCat0 = new ProdCat(product0, category0);
		ProdCat prodCat1 = new ProdCat(product1, category1);
		ProdCat prodCat2 = new ProdCat(product2, category2);
		
		ArrayList<ProdCat> prodCatList = new ArrayList<ProdCat>();
		prodCatList.add(prodCat0); prodCatList.add(prodCat1); prodCatList.add(prodCat2);
		
		Mockito.when(initialData.getProdCats()).thenReturn(prodCatList);
		pcro.removeProdCat(prodCat1);
		assertEquals(pcro.getProdCats().size(), 2);
	}

}
