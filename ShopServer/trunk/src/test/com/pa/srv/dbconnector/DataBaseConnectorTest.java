package com.pa.srv.dbconnector;

import org.junit.Before;
import org.junit.Rule;
import static org.junit.Assert.*;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExpectedException.*;

import com.pa.srv.db.DataBaseConnector;

public class DataBaseConnectorTest {
	
	DataBaseConnector db;
	//Credentials credentials;
	String path = Paths.get(".").toAbsolutePath().normalize().toString();
	
	@Before
	public void setUP() {
		
		db = new DataBaseConnector();
		db.setDataBasePath(path);
		
		//credentials.setCredentials(username, password);
		//db.setDataBasePath(path);
		//db.setDataBaseCredentials(credentials);
		System.out.println(path);
		
	}
	
	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testDataBasePermissions() {
		
		Assert.assertTrue(is)
	}
}
