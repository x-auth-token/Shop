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


import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;
//import com.pa.common.Validators.validateOnlyNumbersUsed;

import com.pa.cl.role.*;

public class Login {

	private JFrame frmLogin;
	private JPasswordField passwordField;
	private JTextField txtworkID;
	private JTextField txtuserName;
	

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
	 * @param <frmRegister>
	 */
	private <frmLogin> void initialize()
	{
		frmLogin = new JFrame();
		frmLogin.setFont(new Font("Arial Narrow", Font.BOLD, 12));
		frmLogin.setForeground(Color.DARK_GRAY);
		frmLogin.setTitle("login");
		frmLogin.getContentPane().setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		frmLogin.setBounds(100, 100, 450, 300);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JButton x = new JButton("Login");
		x.setBounds(241, 152, 85, 35);
		x.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
//				if(!validateOnlyNumbersUsed(txtworkID.getText()))
//				{
//					JOptionPane.showMessageDialog(frmLogin,"worker id : use only numbers");
//				}
//				
//				else if(!validateOnlyLettersUsed(txtuserName.getText()))
//				{
//					JOptionPane.showMessageDialog(frmLogin,"user name : use only in letters");
//				}
				
				// TODO validate the input with the db
				
				String employeeRole="shiftManager";// TODO attract info from db on the role position
				switch (employeeRole)
				{
				case "shiftManager" :
				{
						manager mng=new manager();
						mng.setVisible(true);
				}break;	
				case "cashier" :
				{
					cashier cash=new cashier();
					cash.setVisible(true);
				}break;
				case "salesMan" :
				{
					salesman slm=new salesman();
					slm.setVisible(true);
				}break;
				
				default:
					break;
				}
				frmLogin.dispose();//close the login menu  
			
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
		
		txtworkID = new JTextField();
		txtworkID.setBounds(83, 53, 109, 25);
		frmLogin.getContentPane().add(txtworkID);
		txtworkID.setColumns(10);
		
		txtuserName = new JTextField();
		txtuserName.setBounds(83, 90, 109, 23);
		frmLogin.getContentPane().add(txtuserName);
		txtuserName.setColumns(10);
	}
}
