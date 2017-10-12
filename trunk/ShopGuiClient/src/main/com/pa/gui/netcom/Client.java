package com.pa.gui.netcom;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;



public class Client implements Runnable {
	
	private static int serverPort = 8787;
	private static String serverHostname = "localhost";
	private static SocketFactory clientSecuredSocketFactory;
	private static Socket clientSecuredSocket;
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

	
	public Client(String hostName, int port) {
		
		Client.serverHostname = hostName;
		Client.serverPort = port;
		
		startClient();
		
	}
	
	public Client(Socket s) {
		Client.clientSecuredSocket = s;
	}
	
	private void startClient() {
		try {
						
			clientSecuredSocketFactory = SSLSocketFactory.getDefault();
			clientSecuredSocket = clientSecuredSocketFactory.createSocket(serverHostname, serverPort);
			System.out.println("--- Client connected to " + serverHostname + " on port " + serverPort);
			
			new Thread(new Client(clientSecuredSocket)).start();
					
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(connectionStatus)
			System.out.println("Still working");
		
	}
	

}
