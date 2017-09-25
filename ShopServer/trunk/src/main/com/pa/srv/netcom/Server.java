package com.pa.srv.netcom;

import java.io.IOException;
import java.net.*;
import java.util.Date;
import java.lang.*;


public class Server {
	
	public static final int port = 8787;
	
	public void listner() throws IOException {
		
		try {
			

			final ServerSocket server = new ServerSocket(port);
			System.out.println(new Date() + "--- Server started on port " + port);
			
			while (true) {
				
				final Socket socket = server.accept();
				
				new Thread() ;
			}
		}
		catch (IOException e) {
			
			System.out.println(e.getMessage());
		}
	}
}
