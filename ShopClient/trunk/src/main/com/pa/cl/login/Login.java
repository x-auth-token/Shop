/*******************************************************************************
 * Copyright (C) 2017 Pavel Mayzenberg and Amos Refael
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.pa.cl.login;

import com.pa.common.*;
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

public class Login {

	private JFrame frmLogin;
	private JPasswordField passwordField;
	private JTextField txtDfsd;
	private JTextField txtOnlyLaters;
//
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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
		frmLogin.setTitle("Login");
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
				JOptionPane.showMessageDialog(frmLogin,"you are Login");
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
