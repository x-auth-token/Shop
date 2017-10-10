package com.pa.common;

import java.util.List;
import java.util.UUID;
import com.pa.common.crypto.*;



public abstract class User {
	
	private String username;
	private String password;
	private UUID uuid;
	private List<Permission> permissions;
	
	
	public User(String un) {
		setUuid(UUID.randomUUID());
	}
	public User(String un, String pass) {
		setUuid(UUID.randomUUID());
		setUsername(un);
		setPassword(pass);
	}
	
	protected String getUsername() {
		return username;
	}
	protected void setUsername(String username) {
		this.username = username;
	}
	protected String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	protected List<Permission> getPermissions() {
		return permissions;
	}
	protected void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	public UUID getUuid() {
		return uuid;
	}
	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	
	
	
	
}
