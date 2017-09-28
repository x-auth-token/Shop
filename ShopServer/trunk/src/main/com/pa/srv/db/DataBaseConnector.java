package com.pa.srv.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataBaseConnector {

	private String dbPath;
	private File dbFolder; 
	private DataBaseFile dbFile;

	public DataBaseConnector() throws IOException, SecurityException {

		dbFolder = new File("db");
		
		try {
			if (!dbFolder.exists()) {
				
				dbFolder.mkdirs();
			}
			
			dbPath = dbFolder.getAbsolutePath().toString();
						
			dbFile = new DataBaseFile(dbPath + "/Inventory.db", "rw");
			
			System.out.println("File created at: " + getDataBasePath());
		} catch (SecurityException | IOException e) {
			
			e.printStackTrace();
		}
	}

	public void setDataBasePath(String path) {

		dbPath = path;
	}

	public final String getDataBasePath() {

		return dbPath;
	}
	
	public DataBaseFile getDataBaseFile() {
		
		return this.dbFile;
	}
	
	public static void main (String args[]) throws SecurityException, FileNotFoundException, IOException {
		
		DataBaseConnector dbc = new DataBaseConnector();
		//dbc.getDataBaseFile().write("Hello World".getBytes());
		try {
			dbc.getDataBaseFile().append("\nAddedd This");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dbc.getDataBaseFile().close();

	}
	
	

}
