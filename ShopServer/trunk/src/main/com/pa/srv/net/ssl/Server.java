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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.nio.file.Paths;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

import org.apache.commons.codec.DecoderException;

import com.google.gson.Gson;
import com.pa.common.crypto.*;
import com.pa.srv.aaa.AuthenticationModule;
import com.pa.srv.aaa.AuthorizationModule;
import com.pa.srv.aaa.Permissions;
import com.pa.srv.aaa.Permissions.*;

public class Server implements Runnable {
	enum ConnectionState {
		LOGIN, COMMAND, LOGOUT
	};

	private static final int port = 8787;
	private static SSLServerSocketFactory serverSocketFactory;
	private static SSLServerSocket securedSocket;
	private static SSLSocket sslSocket;
	private ConnectionState connectionState;

	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String message;
	private String currentWorkDir = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator;

	public ConnectionState getConnectionState() {
		return connectionState;
	}

	public void setConnectionState(ConnectionState state) {
		connectionState = state;
	}

	public Server() throws IOException, SSLException, SocketException {
		serverListnerStart();
	}

	private Server(SSLSocket s) {

		sslSocket = s;

	}

	private void serverListnerStart() throws IOException, SSLException, SocketException {
		String certPath = currentWorkDir + "security" + File.separator + "cert" + File.separator;
		String certificateStore = "keystore-server.jks";
		String trustedCertificateStore = "cacerts.jks";

		try {
			System.setProperty("javax.net.ssl.keyStore", certPath + certificateStore);
			System.setProperty("javax.net.ssl.keyStorePassword", "guessmeifyoucan");
			System.setProperty("javax.net.ssl.trustStore", certPath + trustedCertificateStore);
			System.setProperty("javax.net.ssl.trustStorePassword", "guessmeifyoucan");
			serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

			securedSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
			System.out.println("--- Server started and listening for connections on port " + port);

			while (true) {
				this.setConnectionState(ConnectionState.LOGIN);
				sslSocket = (SSLSocket) securedSocket.accept();
				sslSocket.setEnableSessionCreation(true);
				sslSocket.setNeedClientAuth(true);

				new Thread(new Server(sslSocket)).start();
				System.out.println("--- Client connected from " + sslSocket.getInetAddress());
			}

		} catch (SSLException | SocketException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		try {
			in = new ObjectInputStream(sslSocket.getInputStream());
			out = new ObjectOutputStream(sslSocket.getOutputStream());

			this.setConnectionState(ConnectionState.LOGIN);

			while (this.getConnectionState() != ConnectionState.LOGOUT) {
				switch (this.getConnectionState()) {
				case LOGIN:

					try {
						message = (String) in.readObject();
					
						if (validateCredentials(message)) {
					
							sendMessage("0:" + getUserPermission(message).toString());
						
							this.setConnectionState(ConnectionState.COMMAND);
						} else {
							sendMessage("-1");
						}
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}

					break;
				case COMMAND:
					break;
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

	private void sendMessage(String message) {
		try {
			out.writeObject(message);
			out.flush();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean validateCredentials(String creds) throws NoSuchAlgorithmException, InvalidKeySpecException,
			DecoderException, FileNotFoundException, IOException {

		String[] splittedProvidedCredentials = creds.split(":");
		String username = splittedProvidedCredentials[0];
		String password = splittedProvidedCredentials[1];

		try (BufferedReader br = new BufferedReader(new FileReader(currentWorkDir + "db" + File.separator + "users"))) {
			for (String s; (s = br.readLine()) != null;) {
				String[] splittedStoredCredentials = s.split(":");
				String storedUsername = splittedStoredCredentials[0];
				String storedPassword = splittedStoredCredentials[2] + ":" + splittedStoredCredentials[3] + ":" + splittedStoredCredentials[4];
				System.out.println(storedPassword);
				if (username.equals(storedUsername)
						&& PasswordHasher.validateHashedPassword(password, storedPassword)) {
					return true;
				}
			}

		}

		return false;
	}

	private Permission getUserPermission(String creds) throws FileNotFoundException, IOException {
		String[] splittedProvidedCredentials = creds.split(":");
		String username = splittedProvidedCredentials[0];
		
		try (BufferedReader br = new BufferedReader(new FileReader(currentWorkDir + "db" + File.separator + "users"))) {
			for (String s; (s = br.readLine()) != null;) {
				String[] splittedStoredCredentials = s.split(":");
				String storedUsername = splittedStoredCredentials[0];
				String storedPermission = splittedStoredCredentials[1];

				if (username.equals(storedUsername)) {
					br.close();
					return Permissions.toPermission(storedPermission);
				}
				
			}
			br.close();
		}
		
		return null;

	}

}
