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
package com.pa.common.customer;

import java.util.ArrayList;
import java.util.List;

import com.pa.common.Person;

public class Customer extends Person {

	private double discountPercent;
	private List<String> benefit;
	private int customerNumber;

	// Constructor
	
	public Customer() {
		super();
		this.customerNumber = assignNumber();
	}
	
	public Customer(String cName, String cSName, String cGender, String cId, String pn) {
		
		super(cName, cSName, cGender, cId, pn);
		this.customerNumber = assignNumber();
		this.benefit = new ArrayList<String>();
		this.discountPercent = 0.0;
	
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
	
	public List<String> getBenefitPlan() {
		
		return this.benefit;
		
	}
	
	protected int assignNumber() {
		int number = 0;
		return  number; 
	}
	
	@Override
	public String toString() {

		return "Name: " + getPersonName() + "\n" + "Surname: " + getPersonSurname() + "\n" + "Gender: "
				+ getPersonGender() + "\n" + "ID: " + getPersonId() + "\n" + "Phone: " + getPersonPhoneNumber() + "\n" + "Discount: " + getDiscountPlan() + "%";
	}
	
}
