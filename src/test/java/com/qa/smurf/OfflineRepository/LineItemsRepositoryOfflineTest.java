package com.qa.smurf.OfflineRepository;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.smurf.InitialData;
import com.qa.smurf.entities.Address;
import com.qa.smurf.entities.LineItems;
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.Product;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.offline.EmployeeUserRepositoryOffline;
import com.qa.smurf.repositories.offline.LineItemsRepositoryOffline;
@RunWith(MockitoJUnitRunner.class)
public class LineItemsRepositoryOfflineTest {

	@Mock
	private InitialData initialData;

	@InjectMocks
	private LineItemsRepositoryOffline liro; 
	
	@Test
	public void testPersistLineItem() {
		LineItems li0 = new LineItems(new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null), null, 0, 0, 0);
		ArrayList<LineItems> liList = new ArrayList<LineItems>(); 
		
		Mockito.when(initialData.getLineItems()).thenReturn(liList);
		liro.persistLineItem(li0);
		assertNotNull(liro.getLineItems());
	}

	@Test
	public void testPersistLineItems() {
		LineItems li0 = new LineItems(new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null), null, 0, 0, 0);
		LineItems li1 = new LineItems(new Order(1, new Date(), new Date(), new Payment("b", "b", "b", "b", new Address("b", "b"), new User()), new Address("b", "b"), new User(), null), null, 1, 1, 1);
		LineItems li2 = new LineItems(new Order(2, new Date(), new Date(), new Payment("c", "c", "c", "c", new Address("c", "c"), new User()), new Address("c", "c"), new User(), null), null, 2, 2, 2);
		ArrayList<LineItems> liList = new ArrayList<LineItems>(); 
		ArrayList<LineItems> compList = new ArrayList<LineItems>();
		compList.add(li0); compList.add(li1); compList.add(li2); 
		
		Mockito.when(initialData.getLineItems()).thenReturn(liList);
		liro.persistLineItems(compList);
		assertNotNull(liro.getLineItems());
	}

	@Test
	public void testFindByCompositeKey() {
		Order order0 = new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null);
		Order order1 = new Order(1, new Date(), new Date(), new Payment("b", "b", "b", "b", new Address("b", "b"), new User()), new Address("b", "b"), new User(), null);
		Order order2 = new Order(2, new Date(), new Date(), new Payment("c", "c", "c", "c", new Address("c", "c"), new User()), new Address("c", "c"), new User(), null);
		
		Product product0 = new Product(0, "a", "a", "a", 0.0, false, "a", 0, null, "a", 0, 0);
		Product product1 = new Product(1, "b", "b", "b", 1.1, false, "b", 1, null, "b", 1, 1);
		Product product2 = new Product(2, "c", "c", "c", 2.2, false, "c", 2, null, "c", 2, 2);
		
		LineItems li0 = new LineItems(order0, product0, 0, 0, 0);
		LineItems li1 = new LineItems(order1, product1, 1, 1, 1);
		LineItems li2 = new LineItems(order2, product2, 2, 2, 2);
		
		ArrayList<LineItems> compList = new ArrayList<LineItems>();
		compList.add(li0); compList.add(li1); compList.add(li2); 
		
		Mockito.when(initialData.getLineItems()).thenReturn(compList);
		
		assertNotNull(liro.findByCompositeKey(order2, product2));
		
	}

	@Test
	public void testFindByProduct() {
		Order order0 = new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null);
		Order order1 = new Order(1, new Date(), new Date(), new Payment("b", "b", "b", "b", new Address("b", "b"), new User()), new Address("b", "b"), new User(), null);
		Order order2 = new Order(2, new Date(), new Date(), new Payment("c", "c", "c", "c", new Address("c", "c"), new User()), new Address("c", "c"), new User(), null);
		
		Product product0 = new Product(0, "a", "a", "a", 0.0, false, "a", 0, null, "a", 0, 0);
		Product product1 = new Product(1, "b", "b", "b", 1.1, false, "b", 1, null, "b", 1, 1);
		Product product2 = new Product(2, "c", "c", "c", 2.2, false, "c", 2, null, "c", 2, 2);
		
		LineItems li0 = new LineItems(order0, product0, 0, 0, 0);
		LineItems li1 = new LineItems(order1, product1, 1, 1, 1);
		LineItems li2 = new LineItems(order2, product2, 2, 2, 2);
		
		ArrayList<LineItems> compList = new ArrayList<LineItems>();
		compList.add(li0); compList.add(li1); compList.add(li2); 
		
		Mockito.when(initialData.getLineItems()).thenReturn(compList);
		
		assertNotNull(liro.findByProduct(product2));
		
	}

	@Test
	public void testGetLineItems() {
		LineItems li0 = new LineItems(new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null), null, 0, 0, 0);
		ArrayList<LineItems> liList = new ArrayList<LineItems>(); 
		
		Mockito.when(initialData.getLineItems()).thenReturn(liList);
		liro.persistLineItem(li0);
		assertNotNull(liro.getLineItems());
	}

	@Test
	public void testReadLineItems() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveLineItem() {
		Order order0 = new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null);
		Order order1 = new Order(1, new Date(), new Date(), new Payment("b", "b", "b", "b", new Address("b", "b"), new User()), new Address("b", "b"), new User(), null);
		Order order2 = new Order(2, new Date(), new Date(), new Payment("c", "c", "c", "c", new Address("c", "c"), new User()), new Address("c", "c"), new User(), null);
		
		Product product0 = new Product(0, "a", "a", "a", 0.0, false, "a", 0, null, "a", 0, 0);
		Product product1 = new Product(1, "b", "b", "b", 1.1, false, "b", 1, null, "b", 1, 1);
		Product product2 = new Product(2, "c", "c", "c", 2.2, false, "c", 2, null, "c", 2, 2);
		
		LineItems li0 = new LineItems(order0, product0, 0, 0, 0);
		LineItems li1 = new LineItems(order1, product1, 1, 1, 1);
		LineItems li2 = new LineItems(order2, product2, 2, 2, 2);
		
		ArrayList<LineItems> compList = new ArrayList<LineItems>();
		compList.add(li0); compList.add(li1); compList.add(li2); 
		
		ArrayList<LineItems> liList = new ArrayList<LineItems>();
		liList.add(li0); liList.add(li2);
		
		Mockito.when(initialData.getLineItems()).thenReturn(compList);
		liro.removeLineItem(li1);
		assertEquals(liList.size(), compList.size());
	}

	@Test
	public void testUpdateLineItem() {
		Order order0 = new Order(0, new Date(), new Date(), new Payment("a", "a", "a", "a", new Address("a", "a"), new User()), new Address("a", "a"), new User(), null);
		Order order1 = new Order(1, new Date(), new Date(), new Payment("b", "b", "b", "b", new Address("b", "b"), new User()), new Address("b", "b"), new User(), null);
		Order order2 = new Order(2, new Date(), new Date(), new Payment("c", "c", "c", "c", new Address("c", "c"), new User()), new Address("c", "c"), new User(), null);
		Product product0 = new Product(0, "a", "a", "a", 0.0, false, "a", 0, null, "a", 0, 0);
		Product product1 = new Product(1, "b", "b", "b", 1.1, false, "b", 1, null, "b", 1, 1);
		Product product2 = new Product(2, "c", "c", "c", 2.2, false, "c", 2, null, "c", 2, 2);
		
		LineItems li0 = new LineItems(order0, product0, 0, 0, 0);
		LineItems li1 = new LineItems(order1, product1, 1, 1, 1);
		LineItems li2 = new LineItems(order2, product2, 2, 2, 2);
		
		ArrayList<LineItems> compList = new ArrayList<LineItems>();
		compList.add(li0); compList.add(li1); compList.add(li2); 
	
		
		Mockito.when(initialData.getLineItems()).thenReturn(compList);
		LineItems newLineItem = new LineItems(order2, product2, 3, 2, 2);
		liro.updateLineItem(newLineItem);
		assertEquals(newLineItem, liro.getLineItems().get(liro.getLineItems().size()-1));
		
	}

}
