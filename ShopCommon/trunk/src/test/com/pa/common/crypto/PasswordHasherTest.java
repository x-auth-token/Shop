package com.pa.common.crypto;

import org.junit.Rule;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.apache.commons.codec.DecoderException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pa.common.crypto.PasswordHasher;

public class PasswordHasherTest {
	
	public static final String pass = "password";
	public static final String pass2 = "password2";
	public static final String pass3 = "password3";
	
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
			final String saltedPass = PasswordHasher.generateHashedPassword(pass3);
			System.out.println(saltedPass);
			Assert.assertTrue(PasswordHasher.validateHashedPassword(pass, saltedPass));
		} catch (DecoderException | InvalidKeySpecException | NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
	}
	
}
