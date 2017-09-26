package com.pa.srv.db;

public class DataBaseConnector {

	private static String dbPath;
	private DataBaseFile dbFile;

	public DataBaseConnector() {

		dbPath = null;
		dbFile = null;
	}

	public static void setDataBasePath(String path) {

		dbPath = path;
	}

	public static String getDataBasePath() {

		return dbPath;
	}

}
