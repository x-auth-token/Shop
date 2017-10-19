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

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.*;
import java.nio.file.Paths;
import java.nio.file.SecureDirectoryStream;
import java.util.Date;

import javax.net.ServerSocketFactory;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.lang.*;

@SuppressWarnings("unused")
public class Server implements Runnable {

	private static final int port = 8787;
	private static SSLServerSocketFactory serverSocketFactory;
	private static SSLServerSocket securedSocket;
	private static SSLSocket sslSocket;

	public Server() throws SSLException {
		serverListnerStart();
	}

	private Server(SSLSocket s) {

		sslSocket = s;
	}

	private void serverListnerStart() throws SSLException {
		String currentWorkDir = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "security"
				+ File.separator + "cert" + File.separator;
		String certificateStore = "keystore.jks";
		try {
			System.setProperty("javax.net.ssl.keyStore", currentWorkDir + certificateStore);
			System.setProperty("javax.net.ssl.keyStorePassword", "guessmeifyoucan");
			serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
			
			securedSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(port);
			System.out.println("--- Server started and listening for connections on port " + port);

			while (true) {

				sslSocket = (SSLSocket) securedSocket.accept();
				sslSocket.setEnableSessionCreation(true);
				sslSocket.setSoTimeout(600);
				// sslSocket.setNeedClientAuth(true);
				SSLSession session = sslSocket.getSession();
				Certificate[] chain = session.getLocalCertificates();
			
				for (Certificate cert : chain) {
					System.out.println(((X509Certificate) cert).getSubjectDN());
				}

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
