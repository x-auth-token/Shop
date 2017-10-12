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
	}
	
	public DataBaseTable(String tName, String dPath) {
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
		
		dbPath = folder.getAbsolutePath() + "\\";
		
			
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
	
	public String getDBPath() {
		return dbPath;
	}
	
		
}


