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
	private boolean connectionStatus = true;
	private ClientGui clientGui;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	volatile private String message;

	public Client(String hostName, int port, ClientGui gui) throws IOException {

		Client.serverHostname = hostName;
		Client.serverPort = port;
		this.clientGui = gui;
		
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

		// SSLSession session = clientSecuredSocket.getSession();

		// Certificate[] chain = session.getPeerCertificates();

		// System.out.println("The Certificates used by peer");
		// for (Certificate cert : chain) {
		// System.out.println(((X509Certificate) cert).getSubjectDN());
		// }
		
		new Thread(new Client(clientSecuredSocket)).start();
		this.clientGui.setMessage("Connected Successfully to " + serverHostname + " on port " + serverPort);
	}

	@Override
	public void run() {
		try {
			
			String clientInput = "nice";
			System.out.println("Sent to server " + clientInput);

			out = new ObjectOutputStream(clientSecuredSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(clientSecuredSocket.getInputStream());
			
			do {
				try {
					message = in.readObject().toString();
					sendMessage(clientInput);
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
			} while (!message.equals("goodbye"));
		} catch (Exception e) {

			e.printStackTrace();

		}

	}

	private void setMessage(String message) {
		// TODO Auto-generated method stub
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

	public String sendCredentials(String username, String password) {
		return "{\"username\":\"" + username + "\",\"password\":\"" + password + "\"";
	}
}
