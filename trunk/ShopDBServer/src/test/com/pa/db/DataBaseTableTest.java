package com.pa.db;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import com.google.gson.reflect.TypeToken;
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

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testDataBaseTableCreate() throws SecurityException, IOException {
		db.create();
		Assert.assertTrue(new File(db.getDBPath() + db.getTableName()).exists());
	}

	
	@Test
	public void testDataBaseTableInsertMethod() {

		NewCustomer p = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
		NewCustomer p2 = new NewCustomer("asd", "asdasd", "male", "123456788", "0549002018");
		NewCustomer p3 = new NewCustomer("asd", "asdasd", "male", "123456787", "0549002020");

		try {
			db.insert(p.getPersonId(), p);
			db.insert(p2.getPersonId(), p2);
			db.insert(p3.getPersonId(), p3);

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
		Assert.assertNotNull(db.select("123456789"));
	}
	
	@Test
	public void testDataBaseTableSelectMethodNonExistentObjectException() throws FileNotFoundException, IOException {
		Assert.assertNull(db.select("123456777"));


	}

	
	 @Test
	 public void testDataBaseTableRemoveObjectedMethod() throws FileNotFoundException, IOException {
		 NewCustomer p3 = new NewCustomer("asd", "asdasd", "male", "123456787", "0549002020");
		 Assert.assertTrue(db.delete("123456787", p3));
		
	 }
	
//	 @Test
//	 public void testDataBaseOpenDataBase() {
//	
//	 }

}
