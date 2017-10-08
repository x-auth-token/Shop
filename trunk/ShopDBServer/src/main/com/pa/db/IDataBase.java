package com.pa.db;

import java.util.List;

public interface IDataBase <T> {
	
	void insert(T item);
	void update(T item);
	void delete(T item);
	List<T> select(String str);
}


