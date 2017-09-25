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
		char gender = 'm';
		String id = "123456789";
		String pn = "0549002019";
		
		@Before
		public void setUp() {
			c = new Customer(name,sname,gender, id, pn);
			
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
			Assert.assertEquals(id, c.getCustomerId());
		}
		
		@Test
		public void testCustomerIdSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! ID should contain only numbers and be " + ID_LENGTH + " digits long");
			c.setCustomerId("12345678");
		}
		
		@Test
		public void testCustomerPhoneNumberSetter() {
			
			c.setCustomerPhoneNumber(pn);
			Assert.assertEquals(pn, c.getCustomerPhoneNumber());
		}
		
		
		@Test
		public void testCustomerPhoneNumberSetterException() {
			
			thrown.expect(IllegalArgumentException.class);
			thrown.expectMessage("Wrong input! Phone number should be between " + PHONE_LENGTH_MIN + " or " + PHONE_LENGTH_MAX + " digits long");
			c.setCustomerPhoneNumber("05490020191111111");
		}

}
