package com.pa.common;

import static com.pa.common.Constants.*;

public abstract class Validators {

	public static boolean validateOnlyLettersUsed(String s) {

		for (int i = 0; i < s.length(); i++) {

			if (!Character.isLetter(s.charAt(i))) {

				return false;
			}
		}
		return true;
	}

	public static boolean isCorrectIDFormat(String id) {

		for (int i = 0; i < id.length(); i++) {

			if (!Character.isDigit(id.charAt(i)) || id.length() != ID_LENGTH) {

				return false;
			}
		}
		return true;
	}

	public static boolean isCorrectPhoneNumberFormat(String pn) {

		if (pn.length() < PHONE_LENGTH_MIN || pn.length() > PHONE_LENGTH_MAX)
			return false;

		for (int i = 0; i < pn.length(); i++) {
			if (i == 0 && pn.charAt(0) == '+')
				i++;
			if (!Character.isDigit(pn.charAt(i)))
				return false;
		}

		return true;
	}

}
