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
import com.qa.smurf.entities.Order;
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.offline.OrderRepositoryOffline;
@RunWith(MockitoJUnitRunner.class)
public class OrderRepositoryOfflineTest {

	@Mock
	private InitialData initialData;

	@InjectMocks
	private OrderRepositoryOffline oro; 
	
	@Test
	public void testPersistOrder() {
		User user = new User();
		Address address = new Address("", "");
		Payment payment = new Payment("", "", "", "", address , user);
		
		Order order = new Order(0, 0.0, new Date(), new Date(), payment, address, user, null);
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		
		Mockito.when(initialData.getOrders()).thenReturn(orderList);
		oro.persistOrder(order);
		assertNotNull(oro.getOrders());
	}

	@Test
	public void testPersistOrders() {
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0 , user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2" , address2, user2);
		
		Order order0 = new Order(0, 0.0, new Date(), new Date(), payment0, address0, user0, null);
		Order order1 = new Order(0, 1.1, new Date(), new Date(), payment1, address1, user1, null);
		Order order2 = new Order(0, 2.2, new Date(), new Date(), payment2, address2, user2, null);
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order0); orderList.add(order1); orderList.add(order2);
		
		
		Mockito.when(initialData.getOrders()).thenReturn(orderList);
		oro.persistOrders(orderList);
		assertNotNull(oro.getOrders());
	}

	@Test
	public void testFindByID() {
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0 , user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2" , address2, user2);
		
		Order order0 = new Order(0, 0.0, new Date(), new Date(), payment0, address0, user0, null);
		Order order1 = new Order(0, 1.1, new Date(), new Date(), payment1, address1, user1, null);
		Order order2 = new Order(0, 2.2, new Date(), new Date(), payment2, address2, user2, null);
		order0.setId(1); order1.setId(1); order2.setId(2);
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order0); orderList.add(order1); orderList.add(order2);
		
		Mockito.when(initialData.getOrders()).thenReturn(orderList);
		assertEquals(oro.findByID(order1.getId()).getId(), order1.getId());
		
	}

	@Test
	public void testFindByOrderStatus() {
		
	}

	@Test
	public void testFindByUser() {
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0 , user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2" , address2, user2);
		
		Order order0 = new Order(0, 0.0, new Date(), new Date(), payment0, address0, user0, null);
		Order order1 = new Order(0, 1.1, new Date(), new Date(), payment1, address1, user1, null);
		Order order2 = new Order(0, 2.2, new Date(), new Date(), payment2, address2, user2, null);
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order0); orderList.add(order1); orderList.add(order2);
		
		Mockito.when(initialData.getOrders()).thenReturn(orderList);
		assertEquals(oro.findByUser(user1).get(0), order1);
	}

	@Test
	public void testGetOrders() {
		User user = new User();
		Address address = new Address("", "");
		Payment payment = new Payment("", "", "", "", address , user);
		
		Order order = new Order(0, 0.0, new Date(), new Date(), payment, address, user, null);
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order);
		
		Mockito.when(initialData.getOrders()).thenReturn(orderList);
		oro.persistOrder(order);
		assertNotNull(oro.getOrders());
	}

	@Test
	public void testUpdateOrder() {
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		User newUser = new User();
		
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		Address newAddress = new Address("3", "3");
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0 , user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2" , address2, user2);
		Payment newPayment = new Payment("3", "3", "3", "3", newAddress, newUser);
		
		Order order0 = new Order(0, 0.0, new Date(), new Date(), payment0, address0, user0, null);
		Order order1 = new Order(0, 1.1, new Date(), new Date(), payment1, address1, user1, null);
		Order order2 = new Order(0, 2.2, new Date(), new Date(), payment2, address2, user2, null);
		Order newOrder = new Order(0, 3.3, new Date(), new Date(), newPayment, newAddress, newUser, null);
		order0.setId(0); order1.setId(1); order2.setId(2); newOrder.setId(1);
		
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order0); orderList.add(order1); orderList.add(order2);
		
		Mockito.when(initialData.getOrders()).thenReturn(orderList);
		oro.updateOrder(newOrder);
		assertEquals(newOrder, oro.getOrders().get(1));
	}

	@Test
	public void testRemoveOrder() {
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Address address0 = new Address("0", "0");
		Address address1 = new Address("1", "1");
		Address address2 = new Address("2", "2");
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0 , user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2" , address2, user2);
		
		Order order0 = new Order(0, 0.0, new Date(), new Date(), payment0, address0, user0, null);
		Order order1 = new Order(0, 1.1, new Date(), new Date(), payment1, address1, user1, null);
		Order order2 = new Order(0, 2.2, new Date(), new Date(), payment2, address2, user2, null);
		ArrayList<Order> orderList = new ArrayList<Order>();
		orderList.add(order0); orderList.add(order1); orderList.add(order2);
		Mockito.when(initialData.getOrders()).thenReturn(orderList);
		
		ArrayList<Order> compList = new ArrayList<Order>();
		compList.add(order0); compList.add(order2);
		oro.removeOrder(order1);
		assertEquals(oro.getOrders().size(), compList.size());
		
	}

}
