package com.pa.gui.net.ssl;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Paths;
import java.rmi.ConnectException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;

import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSession;
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
		String currentWorkDir = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "security"
				+ File.separator + "cert" + File.separator;
		String trustedCertificateStore = "cacerts.jks";

		System.setProperty("javax.net.ssl.trustStore", currentWorkDir + trustedCertificateStore);
		System.setProperty("javax.net.ssl.trustStorePassword", "guessmeifyoucan");
		clientSecuredSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		clientSecuredSocket = (SSLSocket) clientSecuredSocketFactory.createSocket(serverHostname, serverPort);
		System.out.println("asd");
		clientSecuredSocket.getSupportedCipherSuites();
		SSLSession session = clientSecuredSocket.getSession();
		Certificate[] chain = session.getPeerCertificates();

		System.out.println("--- Client connected to " + serverHostname + " on port " + serverPort);
		System.out.println("The Certificates used by peer");
		for (Certificate cert : chain) {
			System.out.println(((X509Certificate) cert).getSubjectDN());
		}
		new Thread(new Client(clientSecuredSocket)).start();

	}

	@Override
	public void run() {
		while (connectionStatus)
			System.out.println("Still working");

	}

}
