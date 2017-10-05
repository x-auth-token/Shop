/*******************************************************************************
 * Copyright (C) 2017 Pavel Mayzenberg and Amos Refael
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
