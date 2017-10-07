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

import com.pa.db.DataBaseRecord;


public abstract class Person {

	private String personName;
	private String personSurname;
	private String personId;
	private String personGender;
	private String personPhoneNumber;
	
	
	public Person() {
		setPersonName(null);
		setPersonSurname(null);
		setPersonId(null);
		setPersonPhoneNumber(null);
		setPersonGender(null);
	}
	
	
	public Person(String name, String sName, String gender, String id, String pn) {
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
			this.personName = n;
		}

	}

	public void setPersonSurname(String sn) throws IllegalArgumentException {

		if (!validateOnlyLettersUsed(sn)) {

			throw new IllegalArgumentException("Wrong input! Surname should contain only letters");
		} else {
			this.personSurname = sn;
		}
	}
	
	public void setPersonGender(String g) throws IllegalArgumentException {

		if (!g.equalsIgnoreCase("male") && !g.equalsIgnoreCase("female")) {
			throw new IllegalArgumentException("Wrong input! Gender must be male or female");
		} else {
			this.personGender = g;
		}
	}

	public void setPersonId(String id) throws IllegalArgumentException {

		if (!isCorrectIDFormat(id)) {

			throw new IllegalArgumentException(
					"Wrong input! ID should contain only numbers and be " + ID_LENGTH + " digits long");
		} else {
			this.personId = id;
		}
	}

	public void setPersonPhoneNumber(String phone) throws IllegalArgumentException {

		if (!isCorrectPhoneNumberFormat(phone)) {

			throw new IllegalArgumentException("Wrong input! Phone number should be between " + PHONE_LENGTH_MIN
					+ " or " + PHONE_LENGTH_MAX + " digits long");
		} else {
			this.personPhoneNumber = phone;
		}
	}

	// getters
	public String getPersonName() {
		return this.personName;
	}

	public String getPersonSurname() {
		return this.personSurname;
	}

	public String getPersonGender() {
		return this.personGender;
	}

	public String getPersonId() {
		return this.personId;
	}

	public String getPersonPhoneNumber() {
		return this.personPhoneNumber;
	}

	public DataBaseRecord toDBRecord() {
		return new DataBaseRecord();
	}
	// toString
	public String toString() {

		return "Name: " + getPersonName() + "\n" + "Surname: " + getPersonSurname() + "\n" + "Gender: "
				+ getPersonGender() + "\n" + "ID: " + getPersonId() + "Phone: " + getPersonPhoneNumber();
	}

}
