package com.pa.srv.customer;

public class Customer {
	
	private String customerName;
	private String customerSurename;
	private char customerGender;
	private int customerId;
	private static final int ID_LENGTH = 9;
	
	public Customer(String cName, String cSName, char cGender, String cId) {
		
		setCustomerName(cName);
		setCustomerSurename(cSName);
		setCustomerGender(cGender);
		setCustomerId(cId);
		
	}
	
	// setters
	public void setCustomerName(String n) throws IllegalArgumentException {
		
		for (int i = 0; i < n.length(); i++) {
				
			if (!Character.isLetter(n.charAt(i))) {
					
				throw new IllegalArgumentException("Wrong input! Name should contain only letters"); 
			}
		}
		
		this.customerName = n;
	}
	
	public void setCustomerSurename(String sn) throws IllegalArgumentException {
		
		for (int i = 0; i < sn.length(); i++) {
				
			if (!Character.isLetter(sn.charAt(i))) {
					
				throw new IllegalArgumentException("Wrong input! Surename should contain only letters"); 
			}
		}
		
		this.customerSurename = sn;
	}
	
	public void setCustomerGender(char g) throws IllegalArgumentException {

		if (g != 'm' && g != 'f')
			throw new IllegalArgumentException("Wrong input! Gender must be one character 'm' or 'f'"); 

		this.customerGender = g;
	}
	
	public void setCustomerId(String id) throws IllegalArgumentException {
		
		for (int i = 0; i < id.length(); i++) {
				
			if (!Character.isDigit(id.charAt(i)) || id.length() != ID_LENGTH) {
					
				throw new IllegalArgumentException("Wrong input! ID should contain only numbers and be 9 digits long"); 
			}
		}
		
		this.customerId = Integer.parseInt(id);
	}
		
	// getters
	public String getCustomerName(){ return customerName;}
	public String getCustomerSurename(){ return this.customerSurename;}
	public char getCustomerGender(){ return this.customerGender;}
	public int getCustomerId(){ return this.customerId;}
	
	public String toString() {
		
		return "Name: " + getCustomerName() + "\n" + "Surename: " + getCustomerSurename() + 
						   "\n" + "Gender: " + getCustomerGender() + "\n" + "ID: " + getCustomerId();
	}

}
