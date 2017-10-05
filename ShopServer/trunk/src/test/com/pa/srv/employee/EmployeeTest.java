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
package com.pa.srv.employee;

import static com.pa.common.Constants.ID_LENGTH;
import static com.pa.common.Constants.PHONE_LENGTH_MAX;
import static com.pa.common.Constants.PHONE_LENGTH_MIN;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pa.srv.employee.Employee;

public class EmployeeTest {
	Employee emp;
	String name = "Arnold";
	String sname = "Schwarzenegger";
	String gender = "male";
	String id = "123456789";
	String pn = "+972549002019";
	
	@Before
	public void setUp() {
		emp = new Employee(name,sname,gender, id, pn);
		
	}
	
	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testEmployeeNameSetter() {
		
		try {
			
			emp.setPersonName("qw");
			System.out.println(emp.getPersonName());
			Assert.assertEquals("qw", emp.getPersonName());
		
		} 
		catch (IllegalArgumentException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	@Test
	public void testEmployeeNameSetterException() {
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong input! Name should contain only letters");
		emp.setPersonName("qw1");
	}
	
	@Test
	public void testEmployeeSurenameSetter() {
		
		emp.setPersonSurname("qw");
		Assert.assertEquals("qw", emp.getPersonSurname());
	}
	
	@Test
	public void testEmployeeSurenameSetterException() {
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong input! Surname should contain only letters");
		emp.setPersonSurname("qw1");
	}
	
	@Test
	public void testEmployeeGenderSetter() {
		
		emp.setPersonGender("male");
		Assert.assertEquals("male", emp.getPersonGender());
	}
	
	@Test
	public void testEmployeeGenderSetterException() {
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong input! Gender must be male or female");
		emp.setPersonGender("none");
	}
	
	@Test
	public void testEmployeeIdSetter() {
		
		emp.setPersonId(id);
		Assert.assertEquals(id, emp.getPersonId());
	}
	
	@Test
	public void testEmployeeIdSetterException() {
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong input! ID should contain only numbers and be " + ID_LENGTH + " digits long");
		emp.setPersonId("12345678");
	}
	
	@Test
	public void testEmployeePhoneNumberSetter() {
		
		emp.setPersonPhoneNumber(pn);
		Assert.assertEquals(pn, emp.getPersonPhoneNumber());
	}
	
	
	@Test
	public void testEmployeePhoneNumberSetterException() {
		
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Wrong input! Phone number should be between " + PHONE_LENGTH_MIN + " or " + PHONE_LENGTH_MAX + " digits long");
		emp.setPersonPhoneNumber("+054900201922222");
	}

}
