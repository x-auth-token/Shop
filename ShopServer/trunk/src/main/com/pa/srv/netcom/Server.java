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
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		while (true) {
			
			sslSocket = securedSocket.accept();
			System.out.println("Connected");
			new Thread(new Server(sslSocket)).start();
			
			
		}
		
	}

	public void run() {

		try {

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
