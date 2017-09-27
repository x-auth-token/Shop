package com.pa.common;

import static com.pa.common.Constants.ID_LENGTH;
import static com.pa.common.Constants.PHONE_LENGTH_MAX;
import static com.pa.common.Constants.PHONE_LENGTH_MIN;
import static com.pa.common.Validators.isCorrectIDFormat;
import static com.pa.common.Validators.isCorrectPhoneNumberFormat;
import static com.pa.common.Validators.validateOnlyLettersUsed;

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

	// toString
	public String toString() {

		return "Name: " + getPersonName() + "\n" + "Surname: " + getPersonSurname() + "\n" + "Gender: "
				+ getPersonGender() + "\n" + "ID: " + getPersonId() + "Phone: " + getPersonPhoneNumber();
	}

}
