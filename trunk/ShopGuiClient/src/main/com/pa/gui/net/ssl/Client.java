package com.pa.gui.net.ssl;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.nio.file.Paths;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

import com.pa.gui.main.ClientGui;

public class Client implements Runnable {

	private static int serverPort = 8787;
	private static String serverHostname = "localhost";
	private static SSLSocketFactory clientSecuredSocketFactory;
	private static SSLSocket clientSecuredSocket;
	private ClientGui clientGui = null;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	volatile private String message;
	private boolean authenticated;
	private Object use;
	private String username;
	private String password;

	public Client(String hostName, int port, String message) throws IOException {

		Client.serverHostname = hostName;
		Client.serverPort = port;
		this.message = message;
		setAuthenticated(false);
		startClient();

	}

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

	private Client(SSLSocket s) {
		Client.clientSecuredSocket = s;
	}

	private void startClient() throws UnknownHostException, IOException {
	
		String currentWorkDir = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "security"
		
				+ File.separator + "cert" + File.separator;
		String trustedCertificateStore = "cacerts.jks";
		String certificateStore = "keystore-client.jks";

		System.setProperty("javax.net.ssl.keyStore", currentWorkDir + certificateStore);
		System.setProperty("javax.net.ssl.keyStorePassword", "guessmeifyoucan");
		System.setProperty("javax.net.ssl.trustStore", currentWorkDir + trustedCertificateStore);
		System.setProperty("javax.net.ssl.trustStorePassword", "guessmeifyoucan");

		clientSecuredSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		clientSecuredSocket = (SSLSocket) clientSecuredSocketFactory.createSocket(serverHostname, serverPort);

		new Thread(new Client(clientSecuredSocket)).start();
		
		//gui.setMessage("Connected Successfully to " + serverHostname + " on port " + serverPort);
	
	}

	@Override
	public void run() {
		try {
			
		
			out = new ObjectOutputStream(clientSecuredSocket.getOutputStream());
		
			in = new ObjectInputStream(clientSecuredSocket.getInputStream());
			
			do {
				try {
					sendMessage(this.message);
					System.out.println(message);
					message = in.readObject().toString();
					System.out.println(message);
					if (message.equals("Client authenticated successfully!")) {
						this.setAuthenticated(true);
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
			} while (!message.equals("goodbye"));
		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				clientSecuredSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void setMessage(String message) {
		
		this.message = message;
	}

	public void sendMessage(String message) {
		try {
			out.writeObject(message);
			out.flush();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getMessage() {
		return message;
	}
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	
	public void setAuthenticated(boolean result) {
		this.authenticated = result;
	}
	
	public void setUsername(String username) {
		// TODO Auto-generated method stub
		this.username = username;
	}
	public String getUsername() {
		
		return username;
	}

	public void setPassword(String password) {
		// TODO Auto-generated method stub
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
	

}
