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
