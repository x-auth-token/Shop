package com.pa.srv.customer;


import static com.pa.common.Validators.*;
import static com.pa.common.Constants.*;

public class Customer {
	
	
	private String customerName;
	private String customerSurename;
	private char customerGender;
	private String customerId;
	private String customerPhoneNumber;


	
	// Constructor
	public Customer(String cName, String cSName, char cGender, String cId, String pn) {
		
		setCustomerName(cName);
		setCustomerSurename(cSName);
		setCustomerGender(cGender);
		setCustomerId(cId);
		setCustomerPhoneNumber(pn);
		
		
	}
	
	// setters
	protected void setCustomerName(String n) throws IllegalArgumentException {
		
		if (!validateOnlyLettersUsed(n)) {
			
			throw new IllegalArgumentException("Wrong input! Name should contain only letters");	
		}
		else
			this.customerName = n; 
		
	}
	
	protected void setCustomerSurename(String sn) throws IllegalArgumentException {
		
		if (!validateOnlyLettersUsed(sn)) {
			
			throw new IllegalArgumentException("Wrong input! Surename should contain only letters");	
		}
		else
			this.customerSurename = sn;
		
	}
	
	protected void setCustomerGender(char g) throws IllegalArgumentException {

		if (g != 'm' && g != 'f')
			throw new IllegalArgumentException("Wrong input! Gender must be one character 'm' or 'f'"); 

		this.customerGender = g;
	}
	
	protected void setCustomerId(String id) throws IllegalArgumentException {
		
		if (!isCorrectIDFormat(id)) {
					
			throw new IllegalArgumentException("Wrong input! ID should contain only numbers and be " + ID_LENGTH + " digits long"); 
		}
		else			
			this.customerId = id;
	}
		
	
	protected void setCustomerPhoneNumber(String phone) throws IllegalArgumentException {
		
		if (!isCorrectPhoneNumberFormat(phone)) {
			
			throw new IllegalArgumentException("Wrong input! Phone number should be between " + PHONE_LENGTH_MIN + " or " + PHONE_LENGTH_MAX + " digits long");	
		}
		else
			this.customerPhoneNumber = phone;
	}
	
	// getters
	public String getCustomerName(){ return customerName;}
	public String getCustomerSurename(){ return this.customerSurename;}
	public char getCustomerGender(){ return this.customerGender;}
	public String getCustomerId(){ return this.customerId;}
	public String getCustomerPhoneNumber(){return this.customerPhoneNumber;}
	
	// toString
	public String toString() {
		
		return "Name: " + getCustomerName() + "\n" + "Surename: " + getCustomerSurename() + 
						   "\n" + "Gender: " + getCustomerGender() + "\n" + "ID: " + getCustomerId();
	}

}
