package com.pa.srv.customer;

public class NewCustomer extends Customer {

	private final double DEFAULT_DISCOUNT = 10.0;
	
	public NewCustomer(String cName, String cSName, String cGender, String cId, String pn) {
		super(cName, cSName, cGender, cId, pn);
		this.setDiscountPercent(DEFAULT_DISCOUNT);
	}

	
}
