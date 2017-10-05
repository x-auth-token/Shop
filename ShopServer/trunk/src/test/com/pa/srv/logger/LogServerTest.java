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
package com.pa.srv.logger;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;
import java.util.Date;
import java.util.logging.ErrorManager;
import java.util.logging.SimpleFormatter;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.pa.srv.netcom.Server;

public class LogServerTest {
	
	final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[0].getClassName());
	FileHandler fh = null;
	
	@Before
	public void setUp() throws IOException {
		
		try {
			fh = new FileHandler(new Date() + "%g.log",false);
			LOGGER.addHandler(fh);
			LOGGER.setLevel(Level.ALL);
			LOGGER.setUseParentHandlers(false);
		}
		catch (SecurityException | IOException e) {
			
			e.printStackTrace();
			
		}
		
		
		
	}
}
