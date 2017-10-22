package com.pa.db;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import com.google.gson.reflect.TypeToken;
import com.pa.common.customer.*;
import com.pa.common.branch.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataBaseTableTest {

	static DataBaseTable<NewCustomer> db;
	static DataBaseTable<Stock> db2;
	static Stock s;
	static Stock s2;
	static ArrayList<Stock> stock = new ArrayList<Stock>();
	static String currentWorkingPath = Paths.get(".").toAbsolutePath().normalize().toString();
	static String testDatabasePath = Paths.get(currentWorkingPath, "db", "db_test_folder").toString();

	@BeforeClass
	public static void setUPClass() throws SecurityException, IOException {

		String tblName = "db_test";
		String tblName2 = "db2_test";

		db = new DataBaseTable<NewCustomer>( testDatabasePath, new TypeToken<NewCustomer>() {
		});

		db2 = new DataBaseTable<Stock>(testDatabasePath, new TypeToken<Stock>() {
		});
		
		s = new Stock("Jeans", "large", "blue", "Versace", 10, 50.0);
		s2 = new Stock("Jeans", "extralarge", "red", "KC", 10, 19.20);
		stock.add(s);
		stock.add(s2);
	}

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testDataBaseTableCreate() throws SecurityException, IOException {
		db.create();
		db2.create();
		Assert.assertTrue(new File(db.getDBPath() + db.getTableName()).exists());
	}

	@Test
	public void testDataBaseTableInsertMethod() {

		NewCustomer p = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
		NewCustomer p2 = new NewCustomer("asd", "asdasd", "male", "123456788", "0549002018");
		NewCustomer p3 = new NewCustomer("asd", "asdasd", "male", "123456787", "0549002020");
		ArrayList<NewCustomer> arr = new ArrayList<>();
		arr.add(p);
		arr.add(p2);
		arr.add(p3);
		for (NewCustomer n : arr) {
			try {
				db.insert(n.getPersonId(), n);
			} catch (Exception e) {
				e.getMessage();
			}
		}

		

		for (Stock st : stock) {
			try {
				db2.insert(st.getId(), st);
				//
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	@Test
	public void testDataBaseTableInsertMethodDuplicateNameException() throws Exception, IOException {

		NewCustomer p = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
		thrown.expect(Exception.class);
		thrown.expectMessage("Duplicate Key Has Been Found!");
		db.insert(p.getPersonId(), p);

	}

	@Test
	public void testDataBaseTableUpdateMethod() throws IOException {
		db.update("123456789", "phoneNumber", "0549144667");
		
		db2.update(s.getId(), "vendor", "DG");
		NewCustomer c = db.select("123456789");
		Assert.assertEquals(c.getPersonPhoneNumber(), "0549144667");
	}

	@Test
	public void testDataBaseTableSelectMethod() throws IOException {
		Assert.assertNotNull(db.select("123456789"));
	}

	@Test
	public void testDataBaseTableSelectMethodNonExistentObjectException() throws FileNotFoundException, IOException {
		Assert.assertNull(db.select("123456777"));

	}

	@Test
	public void testDataBaseTableRemoveObjectedMethod() throws FileNotFoundException, IOException {
		NewCustomer p3 = new NewCustomer("asd", "asdasd", "male", "123456787", "0549002020");
		Assert.assertTrue(db.delete(p3.getPersonId(), p3));

	}

	// @Test
	// public void testDataBaseOpenDataBase() {
	//
	// }

}
