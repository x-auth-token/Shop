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
package com.pa.srv.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;


public class DataBase {

	private String dbFullPath;
	private String dbName;
	private File dbFolder; 
	private DataBaseFile dbFile;
	

	public DataBase(String dbName) {

		this.dbFolder = new File("db");
		this.dbName = dbName + ".db";
		
		
	}
	
	public DataBase(String dbName, String dbPath) {
		
		this.dbFolder = new File(dbPath);
		this.dbName = dbName + ".db";
	}

	protected void indexManager() {};
	
	public final void create() throws SecurityException, IOException, FileNotFoundException {
		
		File f;
		
		if (!dbFolder.exists())
			dbFolder.mkdirs();
		
		dbFullPath = dbFolder.getAbsolutePath().toString() + "\\";
			
		f  = new File(dbFullPath + dbName);
			
		if (f.exists())
			throw new FileAlreadyExistsException(f.getAbsolutePath().toString(), "", "File already exists!");
		
		dbFile = new DataBaseFile(dbFullPath + dbName, "rw");
		
		System.out.println("File created at: " + getDBPath());
		
		dbFile.close();
		
	}
	
	
	public void select(String key) {
		
	}	
	
	public void insert(String key) {
		;
	}
	
	public void update() {
		
	}
	
	public void delete() {
		
	}
	
	public void setDBPath(String path) {

		dbFullPath = path;
	}

	public final String getDBPath() {


		return dbFullPath;
	}

	public final File getDBFolder() {
		
		return this.dbFolder;
	}
	public final DataBaseFile getDBFile() {
		
		return this.dbFile;
	}
	
	public final String getDBName() {
		
		return this.dbName;
	}
	

}
