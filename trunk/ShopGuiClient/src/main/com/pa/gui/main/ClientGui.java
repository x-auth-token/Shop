package com.pa.gui.main;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.nio.file.Paths;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import com.pa.common.Permission;
import com.pa.srv.aaa.AuthenticationModule;
import com.pa.srv.aaa.AuthorizationModule;

import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JDesktopPane;

public class ClientGui extends JFrame implements AuthenticationModule, AuthorizationModule {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	// private static Client client;
	private String username;
	private String password;
	private String branch;
	private String server;
	private boolean authenticated = false;
	private int port;
	private JDesktopPane desktopPane;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private static SSLSocketFactory clientSecuredSocketFactory;
	private static SSLSocket clientSecuredSocket;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	public ClientGui() throws UnknownHostException, IOException {
		setTitle("MyShop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTest = new JMenu("Test");
		menuBar.add(mnTest);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		desktopPane = new JDesktopPane();
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		getContentPane().add(desktopPane, gbc_desktopPane);

		// JInternalFrame internalFrame = new JInternalFrame("New
		// JInternalFrame");
		//
		// internalFrame.setBounds(120, 74, 150, 65);
		// desktopPane.add(internalFrame);
		// internalFrame.setVisible(true);
		// try {
		// internalFrame.setMaximum(true);
		// } catch (PropertyVetoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
	}

	// private ClientGui(SSLSocket clientSecuredSocket) {
	// ClientGui.clientSecuredSocket = clientSecuredSocket;
	// }

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public void startClient(String user, String pass, String branch, String server, int port)
			throws UnknownHostException, IOException, ClassNotFoundException {

		String currentWorkDir = Paths.get(".").toAbsolutePath().normalize().toString() + File.separator + "security"
				+ File.separator + "cert" + File.separator;
		String trustedCertificateStore = "cacerts.jks";
		String certificateStore = "keystore-client.jks";

		System.setProperty("javax.net.ssl.keyStore", currentWorkDir + certificateStore);
		System.setProperty("javax.net.ssl.keyStorePassword", "guessmeifyoucan");
		System.setProperty("javax.net.ssl.trustStore", currentWorkDir + trustedCertificateStore);
		System.setProperty("javax.net.ssl.trustStorePassword", "guessmeifyoucan");

		clientSecuredSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
		clientSecuredSocket = (SSLSocket) clientSecuredSocketFactory.createSocket(server, port);
		

		out = new ObjectOutputStream(clientSecuredSocket.getOutputStream());

		in = new ObjectInputStream(clientSecuredSocket.getInputStream());
	
	
			
			sendMessage(user + "\\" + pass);
			
			message = (String)in.readObject();
			System.out.println(message);
			if (message.equals("Client authenticated successfully!")) {
				this.setAuthenticated(true);

			}
	
		
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public synchronized String getMessage() {
		return message;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	private synchronized void sendMessage(String message) throws IOException {
		out.writeObject(message);
		out.flush();
	}

	@Override
	public Permission getUserPermissionSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUserPermissionSet() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean validateUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validatePassword(String password) {
		// TODO Auto-generated method stub
		return false;
	}
}
