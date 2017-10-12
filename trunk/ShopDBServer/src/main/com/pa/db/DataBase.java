package com.pa.db;

import java.io.IOException;
import java.util.List;

public interface DataBase <T> {
	
	void insert(T item) throws IOException;
	void update(T item) throws IOException;
	void delete(T item);
	
	List<T> select(String str);
}


