package com.pa.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.pa.common.Person;
import com.pa.common.customer.NewCustomer;

public class DataBaseTable<T> implements DataBase<T> {
	
	private File folder;
	private File table;
	private String dbPath;
	private String tableName;
	
	private TypeToken<T> dataBaseType;
	private T response;
	
	public TypeToken<T> getDataBaseType() {
		return dataBaseType;
	}

	public void setDataBaseType(TypeToken<T> dataBaseType) {
		this.dataBaseType = dataBaseType;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	
	//Type type = new TypeToken<T>() {}.getType();
	
	public DataBaseTable(String tName, TypeToken<T> dataBaseType) {
		setDataBaseType(dataBaseType);
		this.folder = new File("db");
		this.tableName = tName + ".db";
	}
	
	public DataBaseTable(String tName, String dPath, TypeToken<T> dataBaseType) {
		setDataBaseType(dataBaseType);
		this.folder = new File("db");
		this.tableName = tName + ".db";
		this.folder = new File(dPath);
		
	}
	public File getFolder() {
		return folder;
	}

	public void setFolder(File folder) {
		this.folder = folder;
	}

	public File getTable() {
		return table;
	}

	public void setTable(File table) {
		this.table = table;
	}


	public void setDBPath(String dbPath) {
		this.dbPath = dbPath;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public final void create() throws SecurityException, IOException, FileNotFoundException {
		
		File f;
		
		if (!folder.exists())
			folder.mkdirs();
		
		dbPath = folder.getAbsolutePath() + File.separator;
		
			
		f  = new File(dbPath + this.getTableName());
			
		if (f.exists())
			throw new FileAlreadyExistsException(f.getAbsolutePath(), "", "File already exists!");
		
		table = new File(dbPath + this.getTableName());
		
		System.out.println("File created at: " + this.getDBPath());
		
		table.createNewFile();
	}

	@Override
	public void insert(T item) throws IOException {
		
		
		try (Writer writer = new FileWriter(table, true)) {
			Gson gson = new Gson();
			
			String json = gson.toJson(item, this.getDataBaseType().getType());
			writer.append(json).close();
		}
	}

	@Override
	public void update(T item, String field) throws IOException {
		try (Writer writer = new FileWriter(table, true)) {
			
			Gson gson = new GsonBuilder().create();
			gson.serializeNulls();
			String json = gson.toJson(item);
			writer.append(json).close();
		}
		
	}

	@Override
	public void delete(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T select(String str) throws IOException {
		
		try (JsonReader reader = new JsonReader(new FileReader(table))) {
			
			reader.setLenient(true);
			GsonBuilder gson = new GsonBuilder();
			
			
			T elements;
			while (reader.hasNext()) {
				elements = gson.create().fromJson(reader, this.getDataBaseType().getType());
				
				if (elements.toString().contains(str)) {
					//System.out.println(elements.toString());
					return elements;
				}
			}
			//System.out.println(elements.toString());
			return null;
		}
		
	}
	
	
	public String getDBPath() {
		return dbPath;
	}
	
		
}

