package comp.pa.srv.aaa;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pa.srv.aaa.Authentication;
import com.pa.srv.aaa.AuthenticationModule;


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
