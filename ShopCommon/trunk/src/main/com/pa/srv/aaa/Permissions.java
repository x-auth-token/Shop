package com.pa.srv.aaa;

public abstract class Permissions {
	
	private Permissions() {};
	
	public enum Permission {
	MANAGER,
	CASHIER,
	SELLER
	}

	public static Permission toPermission(String permission) {
		
		switch (permission.toUpperCase()) {
		case "CASHIER":
			return Permission.CASHIER;
		case "SELLER":
			return Permission.SELLER;
		case "MANAGER":
			return Permission.MANAGER;
		default:
			return null;
		}
	
	}
}