package com.pa.db;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.AfterClass;
import org.junit.Assert;

import java.nio.file.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import org.omg.PortableInterceptor.ORBInitInfoPackage.DuplicateName;

import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.pa.common.customer.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataBaseTableTest {

	static DataBaseTable<NewCustomer> db;
	static String currentWorkingPath = Paths.get(".").toAbsolutePath().normalize().toString();
	static String testDatabasePath = Paths.get(currentWorkingPath, "db", "db_test_folder").toString();

	@BeforeClass
	public static void setUPClass() throws SecurityException, IOException {

		String tblName = "db_test";

		db = new DataBaseTable<NewCustomer>(tblName, testDatabasePath, new TypeToken<NewCustomer>() {
		});

	}

	@AfterClass
	public static void tearDownClass() throws Exception {

		File dir = new File(testDatabasePath);

		for (File file : dir.listFiles()) {
			// file.delete();
		}

	}

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testDataBaseTableCreate() throws SecurityException, IOException {
		db.create();
		Assert.assertTrue(new File(db.getDBPath() + db.getTableName()).exists());
	}

	// @Test
	// public void testDataBaseTableCreateException() throws
	// FileNotFoundException, IOException, SecurityException {
	//
	// thrown.expect(FileAlreadyExistsException.class);
	// thrown.expectMessage(
	// testDatabasePath + File.separator + db.getTableName() + " -> : File
	// already exists!");
	// db.create();
	// }

	@Test
	public void testDataBaseTableInsertMethod() {

		NewCustomer p = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
		NewCustomer p2 = new NewCustomer("asd", "asdasd", "male", "123456788", "0549002018");

		try {
			db.insert(p.getPersonId(), p);
			db.insert(p2.getPersonId(), p2);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("duplicate");
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
		NewCustomer c = db.select("123456789");
		Assert.assertEquals(c.getPersonPhoneNumber(),"0549144667");
	}

	@Test
	public void testDataBaseTableSelectMethod() throws IOException {
		NewCustomer p2 = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
		Assert.assertNull(db.select("123456777"));


	}

	//
	// @Test
	// public void testDataBaseDelete() {
	//
	// }
	//
	// @Test
	// public void testDataBaseOpenDataBase() {
	//
	// }

}
