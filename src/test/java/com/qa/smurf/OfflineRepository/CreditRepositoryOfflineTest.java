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
import com.qa.smurf.entities.Credit;
import com.qa.smurf.entities.User;
import com.qa.smurf.repositories.offline.CreditRepositoryOffline;
@RunWith(MockitoJUnitRunner.class)
public class CreditRepositoryOfflineTest {

	@Mock
	private InitialData initialData;

	@InjectMocks
	private CreditRepositoryOffline cro; 

	@Test
	public void testPersistCreditCredit() {
		Credit credit = new Credit(new User(), 0, 0);
		ArrayList<Credit> credList = new ArrayList<Credit>();
		credList.add(credit);
		
		Mockito.when(initialData.getCredit()).thenReturn(credList);
		cro.persistCredit(credit);
		assertNotNull(cro.getCredit());
	}

	@Test
	public void testPersistCreditListOfCredit() {
		Credit cred0 = new Credit(new User(), 0, 0);
		Credit cred1 = new Credit(new User(), 1, 1);
		Credit cred2 = new Credit(new User(), 2, 2);
		ArrayList<Credit> credList = new ArrayList<Credit>();
		credList.add(cred0);
		credList.add(cred1);
		credList.add(cred2);
		
		
		
		Mockito.when(initialData.getCredit()).thenReturn(credList);
		cro.persistCredit(credList);
		assertEquals(credList, cro.getCredit());
	}

	@Test
	public void testFindByUser() {
		Credit cred0 = new Credit(new User(), 0, 0);
		Credit cred1 = new Credit(new User(), 1, 1);
		Credit cred2 = new Credit(new User(), 2, 2);
		ArrayList<Credit> credList = new ArrayList<Credit>();
		credList.add(cred0);
		credList.add(cred1);
		credList.add(cred2);
		
		Mockito.when(initialData.getCredit()).thenReturn(credList);
		assertNotNull(cro.findByUser(cred1.getUser()));
	}

	@Test
	public void testGetCredit() {
		Credit credit = new Credit(new User(), 0, 0);
		ArrayList<Credit> credList = new ArrayList<Credit>();
		credList.add(credit);
		
		Mockito.when(initialData.getCredit()).thenReturn(credList);
		assertNotNull(cro.getCredit());
	}

	@Test
	public void testCheckCredit() {
		Credit cred0 = new Credit(new User(), 0, 0);
		Credit cred1 = new Credit(new User(), 1, 1);
		Credit cred2 = new Credit(new User(), 2, 2);
		ArrayList<Credit> credList = new ArrayList<Credit>();
		credList.add(cred0);
		credList.add(cred1);
		credList.add(cred2);
		
		Mockito.when(initialData.getCredit()).thenReturn(credList);
		assertNotNull(cro.checkCredit(cred1));
	}

}
