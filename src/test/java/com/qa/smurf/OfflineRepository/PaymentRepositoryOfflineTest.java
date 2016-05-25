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
import com.qa.smurf.entities.Payment;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.offline.PaymentRepositoryOffline;

@RunWith(MockitoJUnitRunner.class)
public class PaymentRepositoryOfflineTest {

	@Mock
	private InitialData initialData;
	
	@InjectMocks
	private PaymentRepositoryOffline pro;
	
	@Test
	public void testPersistPaymentPayment() {
		Payment payment = new Payment("", "", "", "", new Address("", ""), new User());
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		paymentList.add(payment);
		
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		pro.persistPayment(payment);
		assertNotNull(pro.getPayments());
	}
	
	@Test
	public void testPersistPaymentListOfPayment() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		pro.persistPayment(paymentList);
		assertNotNull(pro.getPayments());
	}

	@Test
	public void testFindByID() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		payment0.setId(0); payment1.setId(1); payment2.setId(2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		assertEquals(pro.findByID(payment1.getId()), payment1);
		
		
	}

	@Test
	public void testFindByCardNumber() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		payment0.setId(0); payment1.setId(1); payment2.setId(2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		assertEquals(pro.findByCardNumber(payment1.getCardNumber()), payment1);
		
	}

	@Test
	public void testFindByCardType() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		payment0.setId(0); payment1.setId(1); payment2.setId(2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		assertEquals(pro.findByCardNumber(payment1.getCardType()), payment1);
	}

	@Test
	public void testFindByExpiryDate() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		payment0.setId(0); payment1.setId(1); payment2.setId(2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		assertEquals(pro.findByCardNumber(payment1.getExpiryDate()), payment1);
	}

	@Test
	public void testFindByNameOnCard() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		payment0.setId(0); payment1.setId(1); payment2.setId(2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		assertEquals(pro.findByCardNumber(payment1.getNameOnCard()), payment1);
	}

	@Test
	public void testGetPayments() {
		Payment payment = new Payment("", "", "", "", new Address("", ""), new User());
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		paymentList.add(payment);
		
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		pro.persistPayment(payment);
		assertNotNull(pro.getPayments());
	}

	@Test
	public void testCreatePayment() {
		Payment payment = new Payment("", "", "", "", new Address("", ""), new User());
		ArrayList<Payment> paymentList = new ArrayList<Payment>();
		paymentList.add(payment);
		
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		pro.createPayment(payment);;
		assertNotNull(pro.getPayments());
	}

	@Test
	public void testReadPayment() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		payment0.setId(0); payment1.setId(1); payment2.setId(2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		assertEquals(pro.readPayment(payment1), payment1);
	}

	@Test
	public void testUpdatePayment() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		Address newAddress = new Address("", "");
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		User newUser = new User();
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		Payment newPayment = new Payment("3", "3", "3", "3", newAddress, newUser);
		payment0.setId(0); payment1.setId(1); payment2.setId(2); newPayment.setId(1);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		pro.updatePayment(newPayment);
		assertEquals(pro.getPayments().get(1), newPayment);
	}

	@Test
	public void testRemovePayment() {
		Address address0 = new Address("", "");
		Address address1 = new Address("", "");
		Address address2 = new Address("", "");
		
		
		User user0 = new User();
		User user1 = new User();
		User user2 = new User();
		
		
		Payment payment0 = new Payment("0", "0", "0", "0", address0, user0);
		Payment payment1 = new Payment("1", "1", "1", "1", address1, user1);
		Payment payment2 = new Payment("2", "2", "2", "2", address2, user2);
		
		payment0.setId(0); payment1.setId(1); payment2.setId(2);
		
		ArrayList<Payment> paymentList = new ArrayList<Payment>(); 
		paymentList.add(payment0); paymentList.add(payment1);paymentList.add(payment2);
		Mockito.when(initialData.getPayments()).thenReturn(paymentList);
		
		pro.removePayment(payment1);
		assertEquals(pro.getPayments().size(), 2);
	}
	
	/*
	public void testFindBySecurityNumber() {
		fail("Not yet implemented");
	}

	
	public void testFindByUserId() {
		fail("Not yet implemented");
	}
	
	*/

}
