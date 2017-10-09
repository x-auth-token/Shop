package com.pa.srv.crypto;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;

public class PasswordHasher {
	
	private static final int KEY_LENGTH = 512;
	private static final String ALGO_NAME = "PBKDF2WithHmacSHA512";
	private static final int ITERATIONS = 1000;
	
	private PasswordHasher() {
		
	}
	
	public static byte[] generateHashedPassword(String pass) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		final char[] password = pass.toCharArray();
		final byte[] salt = getSalt();
		
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGO_NAME);
		byte[] hashedPassword = secretKeyFactory.generateSecret(spec).getEncoded();
		
		//byte[] hashedPassword = getHash(password, salt, ITERATIONS, KEY_LENGTH);
		
		
		//return new String(ITERATIONS + ":" + Hex.encodeHexString(salt) + ":" + Hex.encodeHexString(hashedPassword));
		return hashedPassword;
	}
	
	private static byte[] getSalt() throws NoSuchAlgorithmException {
		SecureRandom sRandom = new SecureRandom();
		byte[] salt = new byte[512];
		sRandom.nextBytes(salt);
		
		System.out.println(sRandom.nextDouble());
		return salt;
	}
	
	private static byte[] getHash(char[] password, byte[] salt, int iterations, int keyLength ) throws NoSuchAlgorithmException, InvalidKeySpecException {
		
		PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
		SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(ALGO_NAME);
		byte[] temp = secretKeyFactory.generateSecret(spec).getEncoded();
		
		return temp;
	}
	
	public static final boolean validateHashedPassword(String origPass, String storedPass) throws DecoderException, NoSuchAlgorithmException, InvalidKeySpecException {
		
		String[] elements = storedPass.split(":");
		int iter = Integer.parseInt(elements[0]);
		byte[] salt = Hex.decodeHex(elements[1].toCharArray());
		byte[] hashedPass = Hex.decodeHex(elements[2].toCharArray());
		
		byte[] testPass = getHash(origPass.toCharArray(), salt, iter, KEY_LENGTH);
		
		
		if (!hashedPass.equals(testPass))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		String pass = "password";
		
		try {
			byte[] hash = generateHashedPassword(pass);
			byte[] hash2 = getHash();

			System.out.println(Arrays.equals(hash,hash2));
			
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
