package com.pa.dbconnector;

import org.junit.Before;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.rules.ExpectedException.*;

public class DataBaseConnectorTest {
	
	DataBaseConnector db;
	Credentials credentials;
	
	@Before
	public void setUP() {
		
		db = new DataBaseConnector();
		credentials.setCredentials(username, password);
		db.setDataBasePath(path);
		db.setDataBaseCredentials(credentials);
		db.connect();
	}
	
	@Test
	
}
