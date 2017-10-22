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
package com.pa.srv.net.ssl;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.file.Paths;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import com.google.gson.Gson;



public class Server implements Runnable {
	enum ConnectionState { LOGIN, COMMAND, LOGOUT };
	
	private static final int port = 8787;
	private static SSLServerSocketFactory serverSocketFactory;
	private static SSLServerSocket securedSocket;
	private static SSLSocket sslSocket;
	private  ConnectionState connectionState;
	
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String message;
	public  ConnectionState getConnectionState() {
		return connectionState;
	}

	public  void setConnectionState(ConnectionState state) {
		connectionState = state;
	}

	public Server() throws IOException, SSLException, SocketException {
		serverListnerStart();
	}

	private Server(SSLSocket s) {

		sslSocket = s;
		this.setConnectionState(ConnectionState.LOGIN);
	}

	private void serverListnerStart() throws IOException, SSLException, SocketException {
		String currentWorkDir = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "security"
				+ File.separator + "cert" + File.separator;
		String certificateStore = "keystore-server.jks";
		String trustedCertificateStore = "cacerts.jks";

		try {
			System.setProperty("javax.net.ssl.keyStore", currentWorkDir + certificateStore);
			System.setProperty("javax.net.ssl.keyStorePassword", "guessmeifyoucan");
			System.setProperty("javax.net.ssl.trustStore", currentWorkDir + trustedCertificateStore);
			System.setProperty("javax.net.ssl.trustStorePassword", "guessmeifyoucan");
			serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

			securedSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
			System.out.println("--- Server started and listening for connections on port " + port);

			while (true) {
				this.setConnectionState(ConnectionState.LOGIN);
				sslSocket = (SSLSocket) securedSocket.accept();
				sslSocket.setEnableSessionCreation(true);
				// sslSocket.setSoTimeout(600);
				sslSocket.setNeedClientAuth(true);

				new Thread(new Server(sslSocket)).start();
				System.out.println("--- Client connected from " + sslSocket.getInetAddress());
			}

		} catch (SSLException | SocketException e) {

			e.printStackTrace();
		} finally {
			sslSocket.close();
		}
	}

	@Override
	public void run() {
		try {
				
				out = new ObjectOutputStream(sslSocket.getOutputStream());
				out.flush();
				in = new ObjectInputStream(sslSocket.getInputStream());
				sendMessage("--- Connection Successfull ---");
				String json = "{\"username\":\"s\",\"password\":\"abc\"}";
				while (this.getConnectionState() != ConnectionState.LOGOUT) {
					System.out.println(this.getConnectionState().toString());
			
					switch (this.getConnectionState()) {
					case LOGIN:
//						do {
							try {
								message = in.readObject().toString();
								System.out.println(message);
								
								
								if (message.equals(json))
									sendMessage("Client authenticated successfully!");
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}
						//} while (!message.equals("bye"));
						this.setConnectionState(ConnectionState.COMMAND);
						break;
					case COMMAND:
						//System.out.println("test");
					case LOGOUT:
						break;
					default:
						break;
					
					}
					
					
				}

			} catch (Exception e) {

				e.printStackTrace();

			}
		
	}
	
	public void sendMessage(String message) {
		try {
			out.writeObject(message);
			out.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
