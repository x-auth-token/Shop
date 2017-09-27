package com.pa.srv.customer;

import com.pa.common.Person;

public class Customer extends Person {

	private double discountPercent;
	private String[] benefit;

	// Constructor
	
	public Customer() {
		super();
	}
	
	public Customer(String cName, String cSName, String cGender, String cId, String pn) {
		
		super(cName, cSName, cGender, cId, pn);
	}
	
	public void setDiscountPercent(double p) {
		this.discountPercent = p;
	}
	
	public double getDiscountPlan() {
		
		return this.discountPercent;
	}
	
	public void setBenefitPlan() {
		
		;
	}
	
	public String[] getBenefitPlan() {
		
		return this.benefit;
		
	}
}
