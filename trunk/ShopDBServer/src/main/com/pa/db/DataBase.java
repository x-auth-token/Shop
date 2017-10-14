package com.pa.db;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

public interface DataBase <T> {
	
	void insert(T item) throws IOException;
	void update(T item, String field) throws IOException;
	void delete(T item);
	T select(String str) throws IOException;
	String getTableName();
}


