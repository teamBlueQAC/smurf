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
import com.qa.smurf.entities.EmployeeUser;
import com.qa.smurf.repositories.offline.EmployeeUserRepositoryOffline;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeUserRepositoryOfflineTest {

	@Mock
	private InitialData initialData;

	@InjectMocks
	private EmployeeUserRepositoryOffline euro; 
	

	@Test
	public void testPersistEmployeeUser() {
		EmployeeUser eu = new EmployeeUser("a");
		ArrayList<EmployeeUser> euList = new ArrayList<EmployeeUser>();
		euList.add(eu);
		
		Mockito.when(initialData.getEmployeeUser()).thenReturn(euList);
		euro.persistEmployeeUser(eu);
		assertNotNull(euro.getEmployeeUsers());
	}

	@Test
	public void testPersistEmployeeUsers() {
		EmployeeUser eu0 = new EmployeeUser("a");
		EmployeeUser eu1 = new EmployeeUser("b");
		EmployeeUser eu2 = new EmployeeUser("c");
		ArrayList<EmployeeUser> euList = new ArrayList<EmployeeUser>();
		euList.add(eu0); euList.add(eu1); euList.add(eu2);
		
		Mockito.when(initialData.getEmployeeUser()).thenReturn(euList);
		euro.persistEmployeeUsers(euList);
		assertNotNull(euro.getEmployeeUsers());
	}

	@Test
	public void testFindByID() {
		EmployeeUser eu0 = new EmployeeUser("a");
		EmployeeUser eu1 = new EmployeeUser("b");
		EmployeeUser eu2 = new EmployeeUser("c");
		ArrayList<EmployeeUser> euList = new ArrayList<EmployeeUser>();
		euList.add(eu0); euList.add(eu1); euList.add(eu2);
		
		Mockito.when(initialData.getEmployeeUser()).thenReturn(euList);
		assertEquals(eu0, euro.findByID(eu0.getID()));
	}

	@Test
	public void testGetEmployeeUsers() {
		EmployeeUser eu = new EmployeeUser("a");
		ArrayList<EmployeeUser> euList = new ArrayList<EmployeeUser>();
		euList.add(eu);
		
		Mockito.when(initialData.getEmployeeUser()).thenReturn(euList);
		assertNotNull(euro.getEmployeeUsers());
	}

	@Test
	public void testUpdateEmployeeUser() {
		EmployeeUser eu0 = new EmployeeUser(0, "a");
		EmployeeUser eu1 = new EmployeeUser(1, "b");
		EmployeeUser eu2 = new EmployeeUser(2, "c");
		EmployeeUser newEu0 = new EmployeeUser(0, "d");
		ArrayList<EmployeeUser> euList = new ArrayList<EmployeeUser>();
		euList.add(eu0); euList.add(eu1); euList.add(eu2);
		
		Mockito.when(initialData.getEmployeeUser()).thenReturn(euList);
		euro.updateEmployeeUser(newEu0);
		assertEquals(newEu0, euro.getEmployeeUsers().get(0));
	}

	@Test
	public void testRemoveEmployeeUser() {
		EmployeeUser eu0 = new EmployeeUser(0, "a");
		EmployeeUser eu1 = new EmployeeUser(1, "b");
		EmployeeUser eu2 = new EmployeeUser(2, "c");
		ArrayList<EmployeeUser> euList = new ArrayList<EmployeeUser>();
		ArrayList<EmployeeUser> compList = new ArrayList<EmployeeUser>();
		euList.add(eu0); compList.add(eu0);
		euList.add(eu1); compList.add(eu1);
		euList.add(eu2);
		Mockito.when(initialData.getEmployeeUser()).thenReturn(euList);
		euro.removeEmployeeUser(eu2);
		assertEquals(euro.getEmployeeUsers().size(), compList.size());
	}

}
