package com.pa.cl.login;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Color;
import javax.swing.JPasswordField;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;

public class login {

	private JFrame frmLogin;
	private JPasswordField passwordField;
	private JTextField txtDfsd;
	private JTextField txtOnlyLaters;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		frmLogin = new JFrame();
		frmLogin.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		frmLogin.setForeground(Color.DARK_GRAY);
		frmLogin.setTitle("login");
		frmLogin.getContentPane().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton x = new JButton("Login");
		x.setBounds(241, 152, 85, 35);
		x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//validate that the input is correct
				String workid= txtDfsd.getText();
				String username= txtOnlyLaters.getText();
				String pass= passwordField.getText();
				
			// TODO validate the input with the db
				if(workid.equals("4499")&&username.equals("amosr")&&pass.equals("1111"))
				{	
				JOptionPane.showMessageDialog(frmLogin,"you are login");
				}
				else
				{
					
					JOptionPane.showMessageDialog(frmLogin,"your pass/username is invalid");
				}
				//TODO options of worker in the system
			}
		});
		frmLogin.getContentPane().setLayout(null);
		frmLogin.getContentPane().add(x);
		
		JLabel lblUserName = new JLabel("user name :");
		lblUserName.setBounds(10, 89, 69, 25);
		frmLogin.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setBounds(10, 11, 69, 247);
		frmLogin.getContentPane().add(lblPassword);
		
		JLabel id = new JLabel("worker id :");
		id.setBounds(10, 53, 69, 25);
		frmLogin.getContentPane().add(id);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(83, 122, 109, 25);
		frmLogin.getContentPane().add(passwordField);
		
		txtDfsd = new JTextField();
		txtDfsd.setBounds(83, 53, 109, 25);
		frmLogin.getContentPane().add(txtDfsd);
		txtDfsd.setColumns(10);
		
		txtOnlyLaters = new JTextField();
		txtOnlyLaters.setBounds(83, 90, 109, 23);
		frmLogin.getContentPane().add(txtOnlyLaters);
		txtOnlyLaters.setColumns(10);
	}
}
