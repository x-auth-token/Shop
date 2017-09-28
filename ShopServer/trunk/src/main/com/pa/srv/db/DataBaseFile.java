package com.pa.srv.db;

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
	
	public void append(String text) throws Exception {
		this.seek(this.length());
		this.writeBytes(text);
		this.close();
	}

}

