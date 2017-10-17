package com.pa.db;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface DataBase <T> {
	
	void insert(String key, T object) throws IOException, Exception;
	void update(String key, String property, String value) throws IOException;
	boolean delete(String key, T object) throws FileNotFoundException, IOException;
	T select(String str) throws IOException;
	String getTableName();
}


