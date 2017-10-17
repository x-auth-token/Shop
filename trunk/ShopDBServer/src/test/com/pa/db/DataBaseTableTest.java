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
		
		
		db = new DataBaseTable<NewCustomer>(tblName,testDatabasePath, new TypeToken<NewCustomer>() {});
				

	}

	@AfterClass
	public static void tearDownClass() throws Exception {

		File dir = new File(testDatabasePath);

		for (File file : dir.listFiles()) {
			//file.delete();
		}

	}

	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testDataBaseTableCreate() throws SecurityException, IOException {
		db.create();
		Assert.assertTrue(new File(db.getDBPath() + db.getTableName()).exists());
	}

//	@Test
//	public void testDataBaseTableCreateException() throws FileNotFoundException, IOException, SecurityException {
//
//		thrown.expect(FileAlreadyExistsException.class);
//		thrown.expectMessage(
//				testDatabasePath + File.separator + db.getTableName() + " -> : File already exists!");
//		db.create();
//	}

	@Test
	public void testDataBaseTableInsertMethod() {

		NewCustomer p = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
		NewCustomer p2 = new NewCustomer("asd", "asdasd", "male", "123456788", "0549002018");

		try {
			db.insert(p);
			db.insert(p2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	@Test
//	public void testDataBaseTableUpdateMethod() throws IOException {
//		//NewCustomer newC = new NewCustomer("asd", "asdasd", "male", "123456787", "0549002018");
//		
//		db.update("123456789","phoneNumber","0549144667" );
//		
//		//Assert.assertEquals("male", db.select("gender"));
//	}

//	 @Test
//	 public void testDataBaseTableSelectMethod() throws IOException {
//		 NewCustomer p2 = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
//		 NewCustomer p3 = db.select("123456789");
//		 //System.out.println(p3);
//		 Assert.assertEquals(p2.toString(), p3.toString());
//	 }

	

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
