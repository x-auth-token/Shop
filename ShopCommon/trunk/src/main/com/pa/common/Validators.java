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
	
	public static boolean validateOnlyNumbersUsed(String n)
	{
		for(int i=0;i<n.length();i++)
			if(!Character.isDigit(n.charAt(i)))
				return false;
		return true;
					
	}
	




}
