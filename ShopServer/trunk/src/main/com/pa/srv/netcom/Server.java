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
package com.pa.srv.netcom;

import java.io.IOException;
import java.net.*;
import java.nio.file.SecureDirectoryStream;
import java.util.Date;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import java.lang.*;

@SuppressWarnings("unused")
public class Server implements Runnable {

	public static final int port = 8787;
	public static ServerSocketFactory serverSocketFactory;
	public static ServerSocket securedSocket;
	public static Socket sslSocket;

	public Server(Socket s) {

		sslSocket = s;
	}

	public static void main (String args[]) throws IOException {
		
		try {
			serverSocketFactory = SSLServerSocketFactory.getDefault();
			securedSocket = serverSocketFactory.createServerSocket(port);
			System.out.println("--- Listening for connections on port " + port);
			
		
		
			while (true) {
				
				sslSocket = securedSocket.accept();
				System.out.println("--- Client connected from " + sslSocket.getInetAddress());
				new Thread(new Server(sslSocket)).start();	
			}
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void run() {

		try {

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
