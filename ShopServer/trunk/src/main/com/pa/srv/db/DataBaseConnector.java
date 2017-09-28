package com.pa.srv.db;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class DataBaseConnector {

	private static String dbPath;
	private DataBaseFile dbFile;

	public DataBaseConnector() {

		dbPath = Paths.get(".").toAbsolutePath().normalize().toString();
		
		try {
			dbFile = new DataBaseFile(dbPath + "/db/Inventory.db", "rw");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public static void setDataBasePath(String path) {

		dbPath = path;
	}

	public static String getDataBasePath() {

		return dbPath;
	}

}
