package com.pa.db;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

public interface DataBase <T> {
	
	void insert(String key, T object) throws IOException, Exception;
	void update(String key, String property, String value) throws IOException;
	void delete(T object);
	T select(String str) throws IOException;
	String getTableName();
}


