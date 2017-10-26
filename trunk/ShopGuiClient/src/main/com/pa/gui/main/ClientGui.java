package com.pa.gui.main;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.UnknownHostException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.file.Paths;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.JFrame;
import javax.swing.JMenuBar;


import com.pa.srv.aaa.Permissions;
import com.pa.srv.aaa.Permissions.Permission;

import javax.swing.JMenu;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class ClientGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String username;
	private String password;
	private String branch;
	private String server;
	private boolean authenticated = false;
	private int port;
	private JDesktopPane desktopPane;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String permission;
	private static SSLSocketFactory clientSecuredSocketFactory;
	private static SSLSocket clientSecuredSocket;

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

		JMenu mnTest = new JMenu("File");
		menuBar.add(mnTest);

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent exitButtonClicked) {
				
				if (mntmExit.getActionCommand().equals(exitButtonClicked.getActionCommand())) {
					
					int dialogButton = JOptionPane.YES_NO_OPTION;
					int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Warning", dialogButton);
					
					if (result == JOptionPane.YES_OPTION) {
						try {
							clientSecuredSocket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						dispose();
					}
					
				}
			}
		});
		
		JMenuItem mntmLogOut = new JMenuItem("Log out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Warning", dialogButton);
				
				if (result == JOptionPane.YES_OPTION)
					getDesktopPane().getSelectedFrame().dispose();
				try {
					clientSecuredSocket.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				loginInterfaceStart();
				
				try {
					if (isAuthenticated()) {
						// login.dispose();
						switch (getPermission()) {
						case CASHIER:
							CashierInteface cashierInterface = new CashierInteface("Cashier");
							getDesktopPane().add(cashierInterface);
							cashierInterface.setMaximum(true);
							cashierInterface.setSelected(true);
							cashierInterface.revalidate();
							break;
						case SELLER:
							SellerInterface sellereInterface = new SellerInterface("Seller");
							getDesktopPane().add(sellereInterface);
							sellereInterface.setMaximum(true);
							sellereInterface.setSelected(true);
							revalidate();
							break;

						case MANAGER:
							ManagerInterface managerInterface = new ManagerInterface("Manager");
							getDesktopPane().add(managerInterface);
							managerInterface.setMaximum(true);
							managerInterface.setSelected(true);
							revalidate();
							break;

						default:
							break;
						}

					} else {
						JOptionPane.showMessageDialog(null, "Invalid username or password! PLease try again.");
					}
				} catch (Exception e) {
					if (e.toString().contains("UnknownHost")) {

						JOptionPane.showMessageDialog(null, "Please Provide Valid Server IP or Name");
					} else if (e.toString().contains("ConnectException")) {
						JOptionPane.showMessageDialog(null,
								"Connection Refused! Check if you are allowed to connect or server running.");
					} else {
						JOptionPane.showMessageDialog(null, e);
					}

				}

			}
		});
		mnTest.add(mntmLogOut);
		mnTest.add(mntmExit);
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

	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}
	
	// Connects to server abd checks credentials
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

		String credentials = user + ":" + pass;

		sendMessage(credentials);

		message = in.readObject().toString();
		System.out.println(message);
		if (isValidCredentials(message)) {
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

	private void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	private void sendMessage(String message) throws IOException {
		out.writeObject(message);
		out.flush();
	}

	private boolean isValidCredentials(String serverResponce) {
		String[] splittedResponce = serverResponce.split(":");

		if (splittedResponce[0].equals("0")) {
			this.setPermission(splittedResponce[1]);
			return true;
		}
		return false;
	}

	private void setPermission(String permission) {
		this.permission = permission;

	}

	public Permission getPermission() {

		return Permissions.toPermission(permission);
	}
	
	public void loginInterfaceStart() {
		LoginDialog login = new LoginDialog();
		login.setLocationRelativeTo(null);
		login.setClientGui(this);
		login.setVisible(true);
		if (login.isCanceled()) {
			JOptionPane.showMessageDialog(null, "You should login first!. Closing");
			this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));

		}
	}
}
