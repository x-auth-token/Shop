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
package com.pa.common;

import static com.pa.common.Constants.ID_LENGTH;
import static com.pa.common.Constants.PHONE_LENGTH_MAX;
import static com.pa.common.Constants.PHONE_LENGTH_MIN;
import static com.pa.common.Validators.isCorrectIDFormat;
import static com.pa.common.Validators.isCorrectPhoneNumberFormat;
import static com.pa.common.Validators.validateOnlyLettersUsed;



public abstract class Person {

	private String name;
	private String surname;
	private String id;
	private String gender;
	private String phoneNumber;
	//private UUID uuid;
	
	
	public Person() {
		//this.uuid = UUID.randomUUID();
		setPersonName(null);
		setPersonSurname(null);
		setPersonId(null);
		setPersonPhoneNumber(null);
		setPersonGender(null);
	}
	
	
	public Person(String name, String sName, String gender, String id, String pn) {
		//this.uuid = UUID.randomUUID();
		setPersonName(name);
		setPersonSurname(sName);
		setPersonId(id);
		setPersonPhoneNumber(pn);
		setPersonGender(gender);
	}
	
	public void setPersonName(String n) throws IllegalArgumentException {

		if (!validateOnlyLettersUsed(n)) {

			throw new IllegalArgumentException("Wrong input! Name should contain only letters");
		} else {
			this.name = n;
		}

	}

	public void setPersonSurname(String sn) throws IllegalArgumentException {

		if (!validateOnlyLettersUsed(sn)) {

			throw new IllegalArgumentException("Wrong input! Surname should contain only letters");
		} else {
			this.surname = sn;
		}
	}
	
	public void setPersonGender(String g) throws IllegalArgumentException {

		if (!g.equalsIgnoreCase("male") && !g.equalsIgnoreCase("female")) {
			throw new IllegalArgumentException("Wrong input! Gender must be male or female");
		} else {
			this.gender = g;
		}
	}

	public void setPersonId(String id) throws IllegalArgumentException {

		if (!isCorrectIDFormat(id)) {

			throw new IllegalArgumentException(
					"Wrong input! ID should contain only numbers and be " + ID_LENGTH + " digits long");
		} else {
			this.id = id;
		}
	}

	public void setPersonPhoneNumber(String phone) throws IllegalArgumentException {

		if (!isCorrectPhoneNumberFormat(phone)) {

			throw new IllegalArgumentException("Wrong input! Phone number should be between " + PHONE_LENGTH_MIN
					+ " or " + PHONE_LENGTH_MAX + " digits long");
		} else {
			this.phoneNumber = phone;
		}
	}

	// getters
	public String getPersonName() {
		return this.name;
	}

	public String getPersonSurname() {
		return this.surname;
	}

	public String getPersonGender() {
		return this.gender;
	}

	public String getPersonId() {
		return this.id;
	}

	public String getPersonPhoneNumber() {
		return this.phoneNumber;
	}

	
	// toString
	@Override
	public String toString() {

		return "Name: " + getPersonName() + "\n" + "Surname: " + getPersonSurname() + "\n" + "Gender: "
				+ getPersonGender() + "\n" + "ID: " + getPersonId() +"\n"+ "Phone: " + getPersonPhoneNumber();
	}

}
