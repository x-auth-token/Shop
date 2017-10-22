package com.pa.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

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
		// this.tableName = tName + ".db";

		this.tableName = buildTableNameFromType(dataBaseType) + ".db";
	}

	public DataBaseTable(String tName, String dPath, TypeToken<T> dataBaseType) {
		setDataBaseType(dataBaseType);
		this.folder = new File("db");
		// this.tableName = tName + ".db";
		this.tableName = buildTableNameFromType(dataBaseType) + ".db";
		this.folder = new File(dPath);

	}

	private String buildTableNameFromType(TypeToken<T> dataBaseType) {
		String temp = dataBaseType.toString();
		String[] words = temp.split("\\.");

		for (String word : words) {
			if (Character.isUpperCase(word.charAt(0))) {
				temp = word;
			}
		}

		return temp;
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

		if (!folder.exists())
			folder.mkdirs();

		dbPath = folder.getAbsolutePath() + File.separator;

		table = new File(dbPath + this.getTableName());

		if (!table.exists()) {
			table.createNewFile();
			System.out.println("File created at: " + this.getDBPath());

		}

	}

	@Override
	public void insert(String key, T object) throws Exception {

		ArrayList<String> collectionOfObjects = new ArrayList<>();
		GsonBuilder gson = new GsonBuilder();
		String serializedObject = gson.create().toJson(object, this.getDataBaseType().getType());

		if (table.length() == 0) {
			try (Writer writer = new FileWriter(table, false)) {
				collectionOfObjects.add(serializedObject);
				writer.write(collectionOfObjects.toString());
			}
		} else if (this.select(key) == null) {
			copyCurrentCollectionOfObjects(collectionOfObjects);
			collectionOfObjects.add(serializedObject);
			try (Writer writer = new FileWriter(table, false)) {
				writer.write(collectionOfObjects.toString());
			}

		} else {
			throw new Exception("Duplicate Key Has Been Found!");
		}
	}

	private void copyCurrentCollectionOfObjects(ArrayList<String> collection)
			throws FileNotFoundException, IOException {
		try (Reader reader = new FileReader(table)) {
			JsonElement json = new JsonParser().parse(reader);
			JsonArray jsonArray = json.getAsJsonArray();
			Iterator<JsonElement> iterator = jsonArray.iterator();
			while (iterator.hasNext()) {
				JsonElement temp = (JsonElement) iterator.next();
				collection.add(temp.toString());
			}
		}
	}

	@Override
	public void update(String key, String property, String value) throws IOException {
		ArrayList<String> collectionOfObjects = new ArrayList<>();
		if (findObjectByKey(key) != null) {
			try (Reader reader = new FileReader(table)) {
				JsonElement json = new JsonParser().parse(reader);
				JsonArray jsonArray = json.getAsJsonArray();
				Iterator<JsonElement> iterator = jsonArray.iterator();
				JsonObject temp;

				while (iterator.hasNext()) {
					temp = (JsonObject) iterator.next();
					if (temp.has("id") && temp.get("id").getAsString().equals(key)) {

						temp.remove(property);
						temp.addProperty(property, value);
					}
					collectionOfObjects.add(temp.toString());
				}
			}

			try (Writer writer = new FileWriter(table, false)) {
				writer.write(collectionOfObjects.toString());

			}
		}
	}

	// public void update(T oldObject, T newObject) throws IOException {
	// JsonObject jsonedOld = new
	// Gson().toJsonTree(oldObject).getAsJsonObject();
	// JsonObject jsonedNew = new
	// Gson().toJsonTree(newObject).getAsJsonObject();
	//
	// ArrayList<String> collectionOfObjects = new ArrayList<>();
	// try (Reader reader = new FileReader(table)) {
	// JsonElement json = new JsonParser().parse(reader);
	// JsonArray jsonArray = json.getAsJsonArray();
	// Iterator<JsonElement> iterator = jsonArray.iterator();
	// JsonObject temp;
	//
	// while (iterator.hasNext()) {
	// temp = (JsonObject) iterator.next();
	// if (temp.equals(jsonedOld)) {
	//
	// delete(oldObject);
	//
	// }
	// collectionOfObjects.add(jsonedNew.toString());
	// }
	//
	// try (Writer writer = new FileWriter(table, false)) {
	// writer.write(collectionOfObjects.toString());
	//
	// }
	// }
	// }

	@Override
	public boolean delete(String key, T object) throws FileNotFoundException, IOException {
		ArrayList<String> collectionOfObjects = new ArrayList<>();
		copyCurrentCollectionOfObjects(collectionOfObjects);
		if (collectionOfObjects.remove(findObjectByKey(key).toString())) {
			try (Writer writer = new FileWriter(table, false)) {
				writer.write(collectionOfObjects.toString());
				return true;
			}
		}
		return false;
	}

	// @Override
	// public boolean delete(T object) throws FileNotFoundException, IOException
	// {
	// ArrayList<String> collectionOfObjects = new ArrayList<>();
	// copyCurrentCollectionOfObjects(collectionOfObjects);
	// if (collectionOfObjects.remove(findObject(object).toString())) {
	// try (Writer writer = new FileWriter(table, false)) {
	// writer.write(collectionOfObjects.toString());
	// return true;
	// }
	// }
	// return false;
	// }

	@Override
	public T select(String key) throws IOException, NullPointerException {

		Gson gson = new Gson();
		T object = null;
		object = gson.fromJson(findObjectByKey(key), getDataBaseType().getType());
		return object;

	}

	private JsonObject findObject(T object) throws FileNotFoundException, IOException {
		Gson gson = new Gson();
		JsonObject jsoned = gson.toJsonTree(object).getAsJsonObject();
		try (Reader reader = new FileReader(table)) {
			JsonElement json = new JsonParser().parse(reader);
			JsonArray jsonArray = json.getAsJsonArray();
			Iterator<JsonElement> iterator = jsonArray.iterator();
			JsonObject temp;
			while (iterator.hasNext()) {
				temp = (JsonObject) iterator.next();

				if (temp.equals(jsoned)) {
					return temp;
				}
			}
		}
		return null;
	}

	private JsonObject findObjectByKey(String key) throws FileNotFoundException, IOException {
		try (Reader reader = new FileReader(table)) {
			JsonElement json = new JsonParser().parse(reader);
			JsonArray jsonArray = json.getAsJsonArray();
			Iterator<JsonElement> iterator = jsonArray.iterator();
			JsonObject temp;
			while (iterator.hasNext()) {
				temp = (JsonObject) iterator.next();

				if (temp.has("id") && temp.get("id").getAsString().equals(key)) {
					return temp;
				}
			}
		}

		return null;

	}

	public String getDBPath() {
		return dbPath;
	}

}
