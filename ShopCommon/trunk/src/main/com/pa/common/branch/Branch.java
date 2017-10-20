package com.pa.common.branch;

import java.util.ArrayList;

import com.pa.common.Constants.*;


public class Branch {
	
	enum Id {
		
		TEL_AVIV, KIRYAT_MALACHI, ARAD
	}
	
	private int id;
	private String address;
	private String branchPhoneNumber;
	private ArrayList<Stock> stock;
	
	public Branch() {
		
		setId(0);
		address="bla bla";
		branchPhoneNumber = "0544001258";
		stock = new ArrayList();
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBranchPhoneNumber() {
		return branchPhoneNumber;
	}

	public void setBranchPhoneNumber(String branchPhoneNumber) {
		this.branchPhoneNumber = branchPhoneNumber;
	}

	public ArrayList<Stock> getStock() {
		return stock;
	}

	public void setStock(ArrayList<Stock> stock) {
		this.stock = stock;
	}
	

	
	
	
}
