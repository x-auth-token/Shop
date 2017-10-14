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
import java.io.IOException;
import java.awt.event.ActionEvent;
import com.pa.gui.netcom.*;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUsername;
	private JPasswordField passwordField;
	private JTextField txtBranch;
	private JTextField txtServerIP;
	private Client cl;

	public LoginDialog() {
		getContentPane().setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
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
			JLabel lblUsername = new JLabel("Username");
			GridBagConstraints gbc_lblUsername = new GridBagConstraints();
			gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
			gbc_lblUsername.gridx = 3;
			gbc_lblUsername.gridy = 2;
			contentPanel.add(lblUsername, gbc_lblUsername);
		}
		{
			txtUsername = new JTextField();
			GridBagConstraints gbc_txtUsername = new GridBagConstraints();
			gbc_txtUsername.insets = new Insets(0, 0, 5, 5);
			gbc_txtUsername.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtUsername.gridx = 4;
			gbc_txtUsername.gridy = 2;
			contentPanel.add(txtUsername, gbc_txtUsername);
			txtUsername.setColumns(10);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			GridBagConstraints gbc_lblPassword = new GridBagConstraints();
			gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
			gbc_lblPassword.gridx = 3;
			gbc_lblPassword.gridy = 3;
			contentPanel.add(lblPassword, gbc_lblPassword);
		}
		{
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.insets = new Insets(0, 0, 5, 5);
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.gridx = 4;
			gbc_passwordField.gridy = 3;
			contentPanel.add(passwordField, gbc_passwordField);
		}
		{
			JLabel lblBranch = new JLabel("Branch");
			lblBranch.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gbc_lblBranch = new GridBagConstraints();
			gbc_lblBranch.insets = new Insets(0, 0, 0, 5);
			gbc_lblBranch.gridx = 3;
			gbc_lblBranch.gridy = 4;
			contentPanel.add(lblBranch, gbc_lblBranch);
		}
		{
			txtBranch = new JTextField();
			GridBagConstraints gbc_txtBranch = new GridBagConstraints();
			gbc_txtBranch.insets = new Insets(0, 0, 0, 5);
			gbc_txtBranch.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtBranch.gridx = 4;
			gbc_txtBranch.gridy = 4;
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
					public void actionPerformed(ActionEvent okButtonClicked) {
						if (okButton.getActionCommand().equals(okButtonClicked.getActionCommand()))
							try {
								cl = new Client(txtServerIP.getText(), 8787);
							} catch (IOException e) {
								JOptionPane.showMessageDialog(null, e.getMessage());
							}
						
						dispose();
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
						//Object event  = cancelButtonClicked.getSource();
						if (cancelButton.getActionCommand().equals(cancelButton.getActionCommand())) {
							dispose();
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
