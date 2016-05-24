package com.qa.smurf.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.String;

import com.qa.smurf.entities.User;

import org.junit.Before;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import com.qa.smurf.InitialData;
import com.qa.smurf.repositories.UserRepository;
import com.qa.smurf.repositories.offline.UserRepositoryOffline;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock
	private UserRepository uRep;
	@Mock 
	private UserRepositoryOffline uRepOff;
	@Mock
	private InitialData initialData;
	
	@InjectMocks
	private UserService uService;
	
	@Before
	public void initMockito(){
		MockitoAnnotations.initMocks(initialData);
		MockitoAnnotations.initMocks(uRep);
		MockitoAnnotations.initMocks(uRepOff);
		MockitoAnnotations.initMocks(this);
	}
	
	
	@Test
	public void testAuthenticate(){
		Mockito.when(uService.authenticate("tyu", "ghj")).thenReturn(1);
		assertNotNull(uService.authenticate("tyu", "ghj"));
		
	}
	
	
	@Test
	public void testAddUser() {
		User newUser = new User(1, "billy", "mayes");
		uService.addUser(newUser);
		String search = newUser.toString();
		Mockito.when(uService.userExists(newUser.getName())).thenReturn(true);
		assertTrue(uService.userExists(newUser.getName()));
	}
	
	
	/*
	@Test
	public void testUserExists() {
		fail("Not yet implemented");
	}
	*/
}
