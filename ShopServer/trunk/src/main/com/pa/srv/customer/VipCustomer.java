package com.pa.srv.customer;

public class VipCustomer extends Customer {
	
	private final double DEFAULT_DISCOUNT = 10;
	
	public VipCustomer(String cName, String cSName, String cGender, String cId, String pn) {
		super(cName, cSName, cGender, cId, pn);
		this.setDiscountPercent(DEFAULT_DISCOUNT);
	}

}
