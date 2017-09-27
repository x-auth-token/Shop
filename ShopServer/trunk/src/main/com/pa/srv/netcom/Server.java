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

public class Server implements Runnable {

	public final int port = 8787;
	public ServerSocketFactory serverSocketFactory;
	public ServerSocket securedSocket;
	public Socket sslSocket;

	public Server(SSLSocket s) {

		this.sslSocket = s;
	}

	public void main (String args[]) throws IOException {
		
		try {
			serverSocketFactory = SSLServerSocketFactory.getDefault();
			securedSocket = serverSocketFactory.createServerSocket(port);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		while (true) {
			
			sslSocket = securedSocket.accept();
		}
		
	}

	public void run() {

		try {

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
