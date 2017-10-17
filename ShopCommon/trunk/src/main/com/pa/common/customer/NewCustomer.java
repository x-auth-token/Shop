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

import java.lang.reflect.Type;

public class NewCustomer extends Customer {

	private final double DEFAULT_DISCOUNT = 10.0;
	
	public NewCustomer(String cName, String cSName, String cGender, String cId, String pn) {
		super(cName, cSName, cGender, cId, pn);
		this.setDiscountPercent(DEFAULT_DISCOUNT);
	}
		// TODO Auto-generated constructor stub
}
