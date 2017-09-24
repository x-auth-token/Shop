package com.pa.aaa;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class AuthenticationModuleTest {
	
	Authentication auth;
	
	@Before
	public void setUp() {
		
		auth = new AuthenticationModule();
	}
	
	@Ignore
	@Test
	public void testIfUserAndPasswordValidationWorks() {
		
		//assertTrue(auth.authenticate(username,password));
		fail("Not implemented yet");
	}
	
	
}
