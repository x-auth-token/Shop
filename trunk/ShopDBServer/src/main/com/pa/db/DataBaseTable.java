package com.pa.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.pa.common.Person;

public class DataBaseTable<T> implements DataBase<T> {
	
	private File folder;
	private File table;
	private String dbPath;
	private String tableName;

	
	
	public DataBaseTable(String tName) {
		this.folder = new File("db");
		
		this.tableName = tName + ".db";
		System.out.println(tableName);
	}
	
	public final void create() throws SecurityException, IOException, FileNotFoundException {
		
		File f;
		
		if (!folder.exists())
			folder.mkdirs();
		
		dbPath = folder.getAbsolutePath().toString() + "\\";
			
		f  = new File(dbPath + tableName);
			
		if (f.exists())
			throw new FileAlreadyExistsException(f.getAbsolutePath().toString(), "", "File already exists!");
		
		table = new File(dbPath + tableName);
		
		System.out.println("File created at: " + getDBPath());
		
		
	}

	@Override
	public void insert(T item) throws IOException {
		
		
		try (Writer writer = new FileWriter(table, true)) {
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(UUID.randomUUID() + "\"," + item);
			writer.append(json + "\n").close();
		}
	}

	@Override
	public void update(T item) throws IOException {
		try (Writer writer = new FileWriter(table, true)) {
			
			Gson gson = new GsonBuilder().create();
			String json = gson.toJson(item);
			writer.append(json + "\n").close();
		}
		
	}

	@Override
	public void delete(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<T> select(String str) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public final String getDBPath() {
		return this.dbPath;
	}
	public static class Test extends Person {
		
		public Test() {
			super();
		}
		
		public Test(String name, String sName, String gender, String id, String pn) {
			super(name, sName, gender, id, pn);
		}
		
	}
	
	public static void main(String[] args) {
		
		Person p = new Test("asd", "asdasd", "male", "123456789", "0549002019");
		Person p2 = new Test("asd", "asdasd", "male", "123456789", "0549002018");
		
		DataBaseTable<Person> dbt = new DataBaseTable<Person>("Customer");
		
		try {
			dbt.create();
		} catch (SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			dbt.insert(p);
			dbt.insert(p2);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

		
}


