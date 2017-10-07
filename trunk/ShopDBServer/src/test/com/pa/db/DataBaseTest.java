/*******************************************************************************
 * Copyright (C) 2017 Pavel Mayzenberg and Amos Refael
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.pa.db;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.ExpectedException.*;
import org.junit.runners.MethodSorters;
import org.junit.rules.TemporaryFolder;

import com.pa.db.DataBase;
import com.pa.db.DataBaseFile;


import org.junit.Ignore;

@SuppressWarnings("unused")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DataBaseTest {

	static DataBase db;

	@BeforeClass
	public static void setUPClass() throws SecurityException, IOException {

		String dbName = "db_test";

		db = new DataBase(dbName,
				"C:\\Users\\merka\\Dropbox\\1 Degree\\HIT\\2nd year\\Java\\ShopServer\\db\\db_test_folder");

		// credentials.setCredentials(username, password);
		// db.setDataBasePath(path);
		// db.setDataBaseCredentials(credentials);
		// System.out.println(path);

	}

	@AfterClass
	public static void tearDownClass() throws Exception {

		File dir = new File("C:\\Users\\merka\\Dropbox\\1 Degree\\HIT\\2nd year\\Java\\ShopServer\\db\\db_test_folder");

		for (File file : dir.listFiles()) {
			file.delete();
		}

	}

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	// @Ignore
	// @Test
	// public void testDataBasePermissions() {
	//
	// Assert.assertTrue(isAllowedSelect());
	// }

	@Test
	public void testDataBaseCreate() throws SecurityException, IOException {
		db.create();
		Assert.assertTrue(new File(db.getDBPath(), db.getDBName()).exists());
	}

	@Test
	public void testDataBaseCreateException() throws FileNotFoundException, IOException, SecurityException {

		thrown.expect(FileAlreadyExistsException.class);
		thrown.expectMessage(
				"C:\\Users\\merka\\Dropbox\\1 Degree\\HIT\\2nd year\\Java\\ShopServer\\db\\db_test_folder\\db_test.db -> : File already exists!");
		db.create();
	}

	@Test
	public void testDataBaseSelectMethod() {
		db.select("1000");
	}

	@Test
	public void testDataBaseInsertMethod() {
		db.insert("veight");

	}
	//
	// @Test
	// public void testDataBaseUpdate() {
	//
	// }
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
