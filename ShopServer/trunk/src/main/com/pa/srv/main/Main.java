package com.pa.srv.main;

import java.io.IOException;

import javax.net.ssl.SSLException;

import com.pa.common.*;
import com.pa.db.DataBaseTable;
import com.pa.srv.net.ssl.*;


public class Main {
	public static void main(String[] args) {
		try {
			Server srv = new Server();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
