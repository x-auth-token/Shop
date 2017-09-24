package com.pa.db;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class DataBaseFile extends RandomAccessFile {

	public DataBaseFile(String arg0, String arg1) throws FileNotFoundException {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public DataBaseFile(File arg0, String arg1) throws FileNotFoundException {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
