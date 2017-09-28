package com.pa.srv.dbconnector;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExpectedException.*;

import com.pa.srv.db.DataBaseConnector;


import org.junit.Ignore;

@SuppressWarnings("unused")
public class DataBaseConnectorTest {
	
	DataBaseConnector db;
	//Credentials credentials;
	String path = Paths.get(".").toAbsolutePath().normalize().toString();
	
	@Before
	public void setUP() throws SecurityException, IOException {
		
		db = new DataBaseConnector();
		db.setDataBasePath(path);
		
		//credentials.setCredentials(username, password);
		//db.setDataBasePath(path);
		//db.setDataBaseCredentials(credentials);
		System.out.println(path);
		
	}
	
	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
//	@Ignore
//	@Test
//	public void testDataBasePermissions() {
//		
//		Assert.assertTrue(isAllowedSelect());
//	}
	
	@Test
	public void testDataBaseFileOpen() {
		
		thrown.expect(FileNotFoundException.class);
		
		
	}
}
