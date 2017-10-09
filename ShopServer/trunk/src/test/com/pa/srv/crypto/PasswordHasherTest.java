package com.pa.srv.crypto;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.DecoderException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.ExpectException;
import org.junit.rules.ExpectedException;

public class PasswordHasherTest {
	
	public static final String pass = "password";
	public static final String pass2 = "password2";
	
	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testGenerateHashedPassword() {
		
		try {
			String sp = PasswordHasher.generateHashedPassword(pass);
			String sp2 = PasswordHasher.generateHashedPassword(pass2);
			Assert.assertNotEquals(sp, sp2);
			
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testValidateHashedPassword() {
		
		try {
			final String saltedPass = PasswordHasher.generateHashedPassword(pass);
			Assert.assertTrue(PasswordHasher.validateHashedPassword(pass, saltedPass));
		} catch (DecoderException | InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
}
