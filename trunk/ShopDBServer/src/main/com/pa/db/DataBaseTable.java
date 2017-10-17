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
import java.util.Iterator;

import org.junit.rules.TemporaryFolder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
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
	public void insert(T item) throws IOException {

		ArrayList<String> collectionOfItems = new ArrayList<>();
		GsonBuilder gson = new GsonBuilder();

		if (table.length() == 0) {
			try (Writer writer = new FileWriter(table, true)) {
				collectionOfItems.add(gson.create().toJson(item, this.getDataBaseType().getType()));
				writer.write(collectionOfItems.toString());
			}
		} else {

			try (Reader reader = new FileReader(table)) {
				JsonElement json = new JsonParser().parse(reader);
				JsonArray jsonArray = json.getAsJsonArray();
				Iterator<JsonElement> iterator = jsonArray.iterator();
				while (iterator.hasNext()) {
					JsonElement temp = (JsonElement) iterator.next();
					collectionOfItems.add(temp.toString());

				}

				if (!collectionOfItems.contains(item)) {
					collectionOfItems.add(gson.create().toJson(item, this.getDataBaseType().getType()));
					try (Writer writer = new FileWriter(table, false)) {
						writer.write(collectionOfItems.toString());

					}
				}

			}

		}

	}

	@Override
	public void update(String key, String property, String value) throws IOException {

		try (JsonReader reader = new JsonReader(new FileReader(table))) {
			reader.setLenient(true);

			try (Writer writer = new FileWriter(table, true)) {

				GsonBuilder gson = new GsonBuilder();

				while (reader.hasNext()) {

					JsonObject jsonObject = gson.create().fromJson(reader, JsonObject.class);

					if (jsonObject.get("id").getAsString().equals(key)) {

						jsonObject.remove(property);
						jsonObject.addProperty(property, value);

					}

					gson.setPrettyPrinting().create().toJson(jsonObject);

					System.out.println(gson.setPrettyPrinting().create().toJson(jsonObject));

				}
				writer.close();
			}
			reader.close();

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
					return gson.create().fromJson(obj, this.getDataBaseType().getType());
				}
			}

			return null;
		}

	}

	public String getDBPath() {
		return dbPath;
	}

}
