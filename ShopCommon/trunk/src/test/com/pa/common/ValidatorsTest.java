package com.pa.common;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ValidatorsTest {

	private String str = "Test";
	
	@Test
	public void testValidateOnlyLettersUsed() {
		
		Assert.assertTrue(Validators.validateOnlyLettersUsed(str));
	}
}

