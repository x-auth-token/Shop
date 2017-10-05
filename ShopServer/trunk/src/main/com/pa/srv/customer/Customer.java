/*******************************************************************************
 * Copyright (C) 2017 Pavel Mayzenberg and Amos Refael
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
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
