package com.pa.gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.security.auth.spi.LoginModule;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.pa.gui.net.ssl.Client;

import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;

public class ClientGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String serverInput;
	private static Client client;
	private String username;
	private String password;
	private String branch;
	private String server;
	private String result = null;
	private int port;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGui gc = new ClientGui();
					LoginDialog login = new LoginDialog();
					gc.pack();
					gc.setVisible(true);
					login.setLocationRelativeTo(null);
					login.setClientGui(gc);
					login.setVisible(true);
					if (login.isCanceled()) {
						JOptionPane.showMessageDialog(null, "You should login first!. Closing");
						gc.dispatchEvent(new WindowEvent(gc, WindowEvent.WINDOW_CLOSING));
						
					}
					
					client = new Client(gc.getServer(), gc.port, gc);
					gc.getMessage();;
					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


	/**
	 * Create the frame.
	 */
	public ClientGui() {
		setTitle("MyShop");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnTest = new JMenu("Test");
		menuBar.add(mnTest);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 0;
		gbc_table.gridy = 0;
		getContentPane().add(table, gbc_table);
	}
	public void connect(String username, String password, String branch, String serverIp, int port) throws IOException {
		this.setClient(new Client(serverIp, port, this));
		client.sendCredentials(username, password);
	}
	public void setMessage(String message) {
		this.serverInput = message;
	}
	
	public void getMessage() {
		JOptionPane.showMessageDialog(this, this.serverInput);
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
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



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}

}
