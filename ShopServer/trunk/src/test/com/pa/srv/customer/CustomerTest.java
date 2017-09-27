package com.pa.srv.customer;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pa.srv.customer.Customer;
import static com.pa.common.Constants.*;

public class CustomerTest {

		Customer c;
		String name = "Arnold";
		String sname = "Schwarzenegger";
		String gender = "male";
		String id = "123456789";
		String pn = "+972549002019";
		
		@Before
		public void setUp() {
			c = new Customer(name,sname,gender, id, pn);
			
		}
		
		@Rule
		public final ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void testCustomerNameSetter() {
			
			try {
				
				c.setPersonName("qw");
				System.out.println(c.getPersonName());
				Assert.assertEquals("qw", c.getPersonName());
			
			} 
			catch (IllegalArgumentException e) {
				
				System.out.println(e.getMessage());
			}
			
			
		}
		
		@Test
		public void testCustomerNameSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Name should contain only letters");
			c.setPersonName("qw1");
		}
		
		@Test
		public void testCustomerSurenameSetter() {
			
			c.setPersonSurname("qw");
			Assert.assertEquals("qw", c.getPersonSurname());
		}
		
		@Test
		public void testCustomerSurenameSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Surname should contain only letters");
			c.setPersonSurname("qw1");
		}
		
		@Test
		public void testCustomerGenderSetter() {
			
			c.setPersonGender("male");
			Assert.assertEquals("male", c.getPersonGender());
		}
		
		@Test
		public void testCustomerGenderSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Gender must be male or female");
			c.setPersonGender("none");
		}
		
		@Test
		public void testCustomerIdSetter() {
			
			c.setPersonId(id);
			Assert.assertEquals(id, c.getPersonId());
		}
		
		@Test
		public void testCustomerIdSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! ID should contain only numbers and be " + ID_LENGTH + " digits long");
			c.setPersonId("12345678");
		}
		
		@Test
		public void testCustomerPhoneNumberSetter() {
			
			c.setPersonPhoneNumber(pn);
			Assert.assertEquals(pn, c.getPersonPhoneNumber());
		}
		
		
		@Test
		public void testCustomerPhoneNumberSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Phone number should be between " + PHONE_LENGTH_MIN + " or " + PHONE_LENGTH_MAX + " digits long");
			c.setPersonPhoneNumber("+054900201922222");
		}

}
