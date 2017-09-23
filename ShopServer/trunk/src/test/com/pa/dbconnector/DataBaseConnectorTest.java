package com.pa.dbconnector;

import org.junit.Before;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExpectedException.*;

public class DataBaseConnectorTest {
	
	DataBaseConnector db;
	//Credentials credentials;
	String path = null;
	
	@Before
	public void setUP() {
		
		db = new DataBaseConnector();
		//credentials.setCredentials(username, password);
		//db.setDataBasePath(path);
		//db.setDataBaseCredentials(credentials);
		
	}
	
	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
//	@Test
//	public void testDatabaseConnectionException() {
//		
//		thrown.expect(AuthenticationFailedException.class);
//		thrown.expectMessage("Authentication failed! Unknown username or password");
//		db.connect();
//	}
}
