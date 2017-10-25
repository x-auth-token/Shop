package com.pa.gui.main;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.ComponentOrientation;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.Box;

import com.pa.common.crypto.*;

public class LoginDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -430619037028254038L;
	/**
	 * 
	 */

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField txtPasswordField;
	private JTextField txtBranch;
	private JTextField txtServerIP;
	private ClientGui guiClient;

	public ClientGui getClientGui() {
		return guiClient;
	}

	public void setClientGui(ClientGui guiClient) {
		this.guiClient = guiClient;
	}

	private boolean cancelButtonPressed = false;
	private JTextField txtPort;

	public LoginDialog() {
		setResizable(false);
		setModal(true);
		getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			Component verticalStrut = Box.createVerticalStrut(20);
			GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
			gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_verticalStrut.gridx = 4;
			gbc_verticalStrut.gridy = 0;
			contentPanel.add(verticalStrut, gbc_verticalStrut);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 0;
			gbc_horizontalStrut.gridy = 1;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			Component horizontalStrut = Box.createHorizontalStrut(20);
			GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
			gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
			gbc_horizontalStrut.gridx = 1;
			gbc_horizontalStrut.gridy = 1;
			contentPanel.add(horizontalStrut, gbc_horizontalStrut);
		}
		{
			JLabel lblServerIp = new JLabel("Server IP");
			GridBagConstraints gbc_lblServerIp = new GridBagConstraints();
			gbc_lblServerIp.insets = new Insets(0, 0, 5, 5);
			gbc_lblServerIp.anchor = GridBagConstraints.EAST;
			gbc_lblServerIp.gridx = 3;
			gbc_lblServerIp.gridy = 1;
			contentPanel.add(lblServerIp, gbc_lblServerIp);
		}
		{
			txtServerIP = new JTextField();
			GridBagConstraints gbc_txtServerIP = new GridBagConstraints();
			gbc_txtServerIP.insets = new Insets(0, 0, 5, 5);
			gbc_txtServerIP.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtServerIP.gridx = 4;
			gbc_txtServerIP.gridy = 1;
			contentPanel.add(txtServerIP, gbc_txtServerIP);
			txtServerIP.setColumns(10);
		}
		{
			JLabel lblPort = new JLabel("Port");
			GridBagConstraints gbc_lblPort = new GridBagConstraints();
			gbc_lblPort.insets = new Insets(0, 0, 5, 5);
			gbc_lblPort.anchor = GridBagConstraints.EAST;
			gbc_lblPort.gridx = 3;
			gbc_lblPort.gridy = 2;
			contentPanel.add(lblPort, gbc_lblPort);
		}
		{
			txtPort = new JTextField();
			txtPort.setText("8787");
			GridBagConstraints gbc_txtPort = new GridBagConstraints();
			gbc_txtPort.insets = new Insets(0, 0, 5, 5);
			gbc_txtPort.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtPort.gridx = 4;
			gbc_txtPort.gridy = 2;
			contentPanel.add(txtPort, gbc_txtPort);
			txtPort.setColumns(10);
			
		}
		{
			JLabel lblUsername = new JLabel("Username");
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.gridx = 3;
			gbc_lblUsername.gridy = 3;
			contentPanel.add(lblUsername, gbc_lblUsername);
		}
		{
			txtUsername = new JTextField();
			GridBagConstraints gbc_txtUsername = new GridBagConstraints();
			gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
			gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsername.gridx = 4;
			gbc_txtUsername.gridy = 3;
			contentPanel.add(txtUsername, gbc_txtUsername);
			txtUsername.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 3;
			gbc_lblPassword.gridy = 4;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			txtPasswordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 4;
			gbc_passwordField.gridy = 4;
			contentPanel.add(txtPasswordField, gbc_passwordField);
		}
		{
			JLabel lblBranch = new JLabel("Branch");
			lblBranch.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblBranch = new GridBagConstraints();
			gbc_lblBranch.insets = new Insets(0, 0, 0, 5);
			gbc_lblBranch.gridx = 3;
			gbc_lblBranch.gridy = 5;
			contentPanel.add(lblBranch, gbc_lblBranch);
		}
		{
			txtBranch = new JTextField();
			GridBagConstraints gbc_txtBranch = new GridBagConstraints();
			gbc_txtBranch.insets = new Insets(0, 0, 0, 5);
			gbc_txtBranch.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBranch.gridx = 4;
			gbc_txtBranch.gridy = 5;
			contentPanel.add(txtBranch, gbc_txtBranch);
			txtBranch.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");

				okButton.addActionListener(new ActionListener() {
					private int failedLoginCounter;

					@SuppressWarnings("deprecation")
					public void actionPerformed(ActionEvent okButtonClicked) {

						String username = txtUsername.getText();
						String password = "";
						if (!txtPasswordField.getPassword().toString().isEmpty()) {
							password = txtPasswordField.getText();
						}

						String branch = txtBranch.getText();
						String server = txtServerIP.getText();
						int port = 8787;
						
					

						if (okButton.getActionCommand().equals(okButtonClicked.getActionCommand())) {

							if (!txtPort.getText().isEmpty()) {
								port = Integer.parseInt(txtPort.getText());
								txtPort.setText(String.valueOf(port));
								
							}

							if (username.isEmpty() || password.isEmpty() || branch.isEmpty() || server.isEmpty()) {
								JOptionPane.showMessageDialog(null, "All fields except port are mandatory!");
							} else {
								
								guiClient.setUsername(username);
								guiClient.setPassword(password);
								guiClient.setBranch(branch);
								guiClient.setServer(server);
								guiClient.setPort(port);
								
								try {
									guiClient.startClient(username, password, branch, server, port);
									
									if (guiClient.isAuthenticated()) {
										dispose();
									} else {
										
										failedLoginCounter++;
										
										if (failedLoginCounter == 3) {
											guiClient.dispatchEvent(new WindowEvent(guiClient, WindowEvent.WINDOW_CLOSING));
										} else {
											JOptionPane.showMessageDialog(null, "Invalid username or password! Please try again");
										}
										
										
									}
								} catch (ClassNotFoundException | IOException e) {
									if (e.toString().contains("UnknownHost")) {
										JOptionPane.showMessageDialog(null, "Please Provide Valid Server IP or Name");
									} else if (e.toString().contains("ConnectException")) {
										JOptionPane.showMessageDialog(null, "Connection Refused! Check if you are allowed to connect or server running.");
									} else {
										JOptionPane.showMessageDialog(null, e);
									}
								}
							}
						} else {
							JOptionPane.showMessageDialog(null, "Please provide Server IP or Name");

						}
				
					}
				});
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");

				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent cancelButtonClicked) {
						
						if (cancelButton.getActionCommand().equals(cancelButton.getActionCommand())) {
							cancelButtonPressed = true;

							dispose();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isCanceled() {
		return cancelButtonPressed;
	}

};