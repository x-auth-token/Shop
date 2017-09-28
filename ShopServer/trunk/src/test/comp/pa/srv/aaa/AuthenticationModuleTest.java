package comp.pa.srv.aaa;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import com.pa.srv.aaa.AuthenticationModule;
import com.sun.net.httpserver.Authenticator;


public class AuthenticationModuleTest {
	
	Authenticator auth;
	
	@Before
	public void setUp() {
		
		//auth = new Authenticator();
	}
	
	@Ignore
	@Test
	public void testIfUserAndPasswordValidationWorks() {
		
		//assertTrue(auth.authenticate(username,password));
		fail("Not implemented yet");
	}
	
	
}
