package com.pa.customer;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import junit.framework.*;

public class CustomerTest {

		Customer c;
		String name = "Arnold";
		String sname = "Schwarzenegger";
		char gender = 'm';
		String id = "123456789";
		
		@Before
		public void setUp() throws Exception {
			c = new Customer(name,sname,gender, id);
			
		}
		
		@Rule
		public final ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void testCustomerNameSetter() {
			
			try {
				
				c.setCustomerName("qw");
				Assert.assertEquals("qw", c.getCustomerName());
			
			} 
			catch (IllegalArgumentException e) {
				
				System.out.println(e.getMessage());
			}
			
			
		}
		
		@Test
		public void testCustomerNameSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Name should contain only letters");
			c.setCustomerName("qw1");
		}
		
		@Test
		public void testCustomerSurenameSetter() {
			
			c.setCustomerSurename("qw");
			Assert.assertEquals("qw", c.getCustomerSurename());
		}
		
		@Test
		public void testCustomerSurenameSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Surename should contain only letters");
			c.setCustomerSurename("qw1");
		}
		
		@Test
		public void testCustomerGenderSetter() {
			
			c.setCustomerGender('m');
			Assert.assertEquals('m', c.getCustomerGender());
		}
		
		@Test
		public void testCustomerGenderSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Gender must be one character 'm' or 'f'");
			c.setCustomerGender('n');
		}
		
		@Test
		public void testCustomerIdSetter() {
			
			c.setCustomerId(id);
			Assert.assertEquals(Integer.parseInt(id), c.getCustomerId());
		}
		
		@Test
		public void testCustomerIdSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! ID should contain only numbers and be 9 digits long");
			c.setCustomerId("12345678");
		}
		

}
