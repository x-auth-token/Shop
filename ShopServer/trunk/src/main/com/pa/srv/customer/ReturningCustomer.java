package com.pa.srv.customer;

public class ReturningCustomer extends Customer {
	
	private final double DEFAULT_DISCOUNT = 5.0;
	
	public ReturningCustomer(String cName, String cSName, String cGender, String cId, String pn) {
		super(cName, cSName, cGender, cId, pn);
		this.setDiscountPercent(DEFAULT_DISCOUNT);
	}

}
