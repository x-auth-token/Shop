package com.pa.db;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.AfterClass;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runners.MethodSorters;
import com.pa.common.customer.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataBaseTableTest {

	static DataBaseTable<NewCustomer> db;

	@BeforeClass
	public static void setUPClass() throws SecurityException, IOException {

		String tblName = "db_test";

		db = new DataBaseTable<NewCustomer>(tblName,
				"C:\\Users\\merka\\Dropbox\\1 Degree\\HIT\\2nd year\\Java\\ShopDBServer\\db\\db_test_folder");

	}

	@AfterClass
	public static void tearDownClass() throws Exception {

		File dir = new File(
				"C:\\Users\\merka\\Dropbox\\1 Degree\\HIT\\2nd year\\Java\\ShopDBServer\\db\\db_test_folder");

		for (File file : dir.listFiles()) {
			file.delete();
		}

	}

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Test
	public void testDataBaseTableCreate() throws SecurityException, IOException {
		db.create();
		Assert.assertTrue(new File(db.getDBPath() + db.getTableName()).exists());
	}

	@Test
	public void testDataBaseTableCreateException() throws FileNotFoundException, IOException, SecurityException {

		thrown.expect(FileAlreadyExistsException.class);
		thrown.expectMessage(
				"C:\\Users\\merka\\Dropbox\\1 Degree\\HIT\\2nd year\\Java\\ShopDBServer\\db\\db_test_folder\\db_test.db -> : File already exists!");
		db.create();
	}

	@Test
	public void testDataBaseTableInsertMethod() {

		NewCustomer p = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002019");
		NewCustomer p2 = new NewCustomer("asd", "asdasd", "male", "123456789", "0549002018");

		try {
			db.insert(p);
			db.insert(p2);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDataBaseUpdate() {
		NewCustomer p = new NewCustomer("asd", "asdasd", "female", "123456789", "0549002019");
		//db.update(p);
		Assert.assertEquals("female", db.select("gender"));
	}

	// @Test
	// public void testDataBaseSelectMethod() {
	// db.select("1000");
	// }

	//

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
