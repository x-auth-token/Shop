package com.pa.aaa;

import com.pa.dbconnector.*;

public class AuthenticationModule implements Authentication {

	//DataBaseConnetor db = new DataBaseConnector();
	
	@Override
	public boolean authenticate(String username, String password) {
		
		return false;
	}

}
