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
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.junit.rules.TemporaryFolder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
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

		f = new File(dbPath + this.getTableName());

		if (!f.exists()) {
			// throw new FileAlreadyExistsException(f.getAbsolutePath(), "",
			// "File already exists!");

			table = new File(dbPath + this.getTableName());

			System.out.println("File created at: " + this.getDBPath());

			table.createNewFile();
		}
		
	}

	@Override
	public void insert(T item) throws IOException {
		

		try (Writer writer = new FileWriter(table, true)) {
			
			GsonBuilder gson = new GsonBuilder();
			
			String json = gson.create().toJson(item, this.getDataBaseType().getType());
			writer.append(json + "\n");
		}
	}

	@Override
	public void update(String key, String property, String value) throws IOException {
		
		try (FileReader fReader = new FileReader(table))
//		try (JsonReader reader = new JsonReader(new FileReader(table))) {
//			reader.setLenient(true);
//			GsonBuilder gson = new GsonBuilder();
//			while (reader.hasNext()) {
//				String str = gson.create().fromJson(reader, JsonObject.class).toString();
//				System.out.println(str);
//			}

			// try (Writer writer = new FileWriter(table,true)) {
			//
			// GsonBuilder gson = new GsonBuilder();
			//
			// gson.serializeNulls();
			//
			// while (reader.hasNext()) {
			//
			// JsonObject jsonObject = gson.create().fromJson(reader,
			// JsonObject.class);
			//
			// if (jsonObject.get("id").getAsString().equals(key)) {
			//
			// jsonObject.remove(property);
			// jsonObject.addProperty(property, value);
			//
			// }
			//
			// String obj = gson.create().toJson(jsonObject);
			// System.out.println("111");
			// writer.write(obj);
			// System.out.println("112");
			// }
			// System.out.println("113");
			// }
			// System.out.println("114");

		}
	}

	@Override
	public void delete(T item) {
		// TODO Auto-generated method stub

	}

	@Override
	public T select(String key) throws IOException {

		try (JsonReader reader = new JsonReader(new FileReader(table))) {

			reader.setLenient(true);
			GsonBuilder gson = new GsonBuilder();

			while (reader.hasNext()) {

				JsonObject obj = gson.create().fromJson(reader, JsonObject.class);

				if (obj.has("id") && obj.get("id").getAsString().equals(key)) {
					// return gson.create().fromJson(obj,
					// this.getDataBaseType().getType());
					;
				}
			}

		}

		return null;
	}

	public String getDBPath() {
		return dbPath;
	}

}

