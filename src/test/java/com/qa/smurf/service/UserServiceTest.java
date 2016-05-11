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
	UserRepositoryOffline uRepOff;
	@Mock
	InitialData initialData;
	@InjectMocks
	private UserService uService = new UserService();
	//ArrayList<User> users = initialData.getUsers();
	@Before
	public void initMockito(){
		MockitoAnnotations.initMocks(this);
	}
	
	/*
	@Test
	public void testAuthenticate() {
		Mockito.stub(uService.authenticate(any(String()), any(String())));
		assertNotNull(uService.authenticate("Will", "Password123"));
	}
	*/
	@Test
	public void testAddUser() {
		User newUser = new User(1, "billy", "mayes");
		uService.addUser(newUser);
		String search = newUser.toString();
		//when(uService.addUser(newUser)).thenReturn(true);
		Mockito.stub(uService.userExists(search)).toReturn(true);
		assertTrue(uService.userExists(newUser.getName()));
	}
	
	/*

	@Test
	public void testUserExists() {
		fail("Not yet implemented");
	}
	*/
}
