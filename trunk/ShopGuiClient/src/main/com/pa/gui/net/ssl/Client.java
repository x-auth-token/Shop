package com.pa.gui.net.ssl;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ConnectException;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;



public class Client implements Runnable {
	
	private static int serverPort = 8787;
	private static String serverHostname = "localhost";
	private static SSLSocketFactory clientSecuredSocketFactory;
	private static SSLSocket clientSecuredSocket;
	private boolean connectionStatus = true;
	

	public static int getServerPort() {
		return serverPort;
	}

	public static void setServerPort(int serverPort) {
		Client.serverPort = serverPort;
	}

	public static String getServerHostname() {
		return serverHostname;
	}

	public static void setServerHostname(String serverHostname) {
		Client.serverHostname = serverHostname;
	}

	
	public Client(String hostName, int port) throws IOException {
		
		Client.serverHostname = hostName;
		Client.serverPort = port;
		
		startClient();
		
	}
	
	public Client(SSLSocket s) {
		Client.clientSecuredSocket = s;
	}
	
	private void startClient() throws IOException {
			
			clientSecuredSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
			clientSecuredSocket = (SSLSocket) clientSecuredSocketFactory.createSocket(serverHostname, serverPort);
			System.out.println("--- Client connected to " + serverHostname + " on port " + serverPort);
			
			new Thread(new Client(clientSecuredSocket)).start();
		
	}
	
	@Override
	public void run() {
		while(connectionStatus)
			System.out.println("Still working");
		
	}
	

}
