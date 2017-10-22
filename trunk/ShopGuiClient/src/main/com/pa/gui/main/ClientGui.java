package com.pa.gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
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
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private boolean authenticated = false;
	private int port;
	private JDesktopPane desktopPane;

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
					
					//gc.getMessage();
					
						
					//String json = "{\"username\":\"" + gc.getUsername() + "\",\"password\":\"" + gc.getPassword() + "\"}";
//					String json = "{\"username\":\"" + gc.getUsername() + "\",\"password\":\"abc\"}";
//					JOptionPane.showMessageDialog(null, "Sending to server :" + json);
//					client.sendMessage(json);
					//gc.getMessage();
					
					
					
					CashierInteface cs = new CashierInteface("Cashier");
					gc.getDesktopPane().add(cs);
					cs.setMaximum(true);
					cs.setSelected(true);
					gc.revalidate();
					
					
					
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
		
		desktopPane = new JDesktopPane();
		GridBagConstraints gbc_desktopPane = new GridBagConstraints();
		gbc_desktopPane.fill = GridBagConstraints.BOTH;
		gbc_desktopPane.gridx = 0;
		gbc_desktopPane.gridy = 0;
		getContentPane().add(desktopPane, gbc_desktopPane);
		
//		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
//		
//		internalFrame.setBounds(120, 74, 150, 65);
//		desktopPane.add(internalFrame);
//		internalFrame.setVisible(true);
//		try {
//			internalFrame.setMaximum(true);
//		} catch (PropertyVetoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	public JDesktopPane getDesktopPane() {
		return desktopPane;
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


	public boolean isAuthenticated() {
		return authenticated;
	}



	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
