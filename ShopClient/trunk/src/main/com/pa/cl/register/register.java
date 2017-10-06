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
package com.pa.cl.register;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class register {

	private JFrame frmRegister;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					register window = new register();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		frmRegister.setTitle("register");
		frmRegister.setBounds(100, 100, 450, 300);
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JLabel lblFirstName = new JLabel("full name :");
		lblFirstName.setBounds(10, 25, 79, 14);
		frmRegister.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("phone number :");
		lblLastName.setBounds(10, 50, 79, 14);
		frmRegister.getContentPane().add(lblLastName);
		
		JLabel lblId = new JLabel("id :");
		lblId.setBounds(10, 75, 79, 14);
		frmRegister.getContentPane().add(lblId);
		
		JLabel lblAcountNumber = new JLabel("acount number :");
		lblAcountNumber.setBounds(10, 100, 79, 14);
		frmRegister.getContentPane().add(lblAcountNumber);
		
		JLabel lblCityStreet = new JLabel("branch affiliation :");
		lblCityStreet.setBounds(10, 125, 92, 14);
		frmRegister.getContentPane().add(lblCityStreet);
		
		JLabel lblWorkerId = new JLabel("worker id :");
		lblWorkerId.setBounds(10, 150, 79, 14);
		frmRegister.getContentPane().add(lblWorkerId);
		
		JLabel lblEmployeePosition = new JLabel("employee position :");
		lblEmployeePosition.setBounds(10, 181, 97, 14);
		frmRegister.getContentPane().add(lblEmployeePosition);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("salesman");
		comboBox.addItem("cashier");
		comboBox.addItem("shift manager");
		comboBox.setMaximumRowCount(3);
		comboBox.setToolTipText("");
		comboBox.setBounds(110, 178, 133, 20);
		frmRegister.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(110, 22, 133, 20);
		frmRegister.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 47, 133, 20);
		frmRegister.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(109, 72, 133, 20);
		frmRegister.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(109, 97, 133, 20);
		frmRegister.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(110, 122, 133, 20);
		frmRegister.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(110, 150, 133, 20);
		frmRegister.getContentPane().add(textField_5);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				//TODO validate that the input is correct
				String f_name=textField.getText() ;
				String p_number=textField_1.getText();
				String id=textField_2.getText();
				String acc_number=textField_3.getText();
				String bra_aff=textField_4.getText();
				String workid=textField_5.getText();
				String emp_pos=(String)comboBox.getSelectedItem();
				String pass=textField_6.getText();
				//TODO update the db with all the info of the new worker
			}
		});
		btnRegister.setBounds(311, 205, 89, 31);
		frmRegister.getContentPane().add(btnRegister);
		
		JLabel lblPassword = new JLabel(" password :");
		lblPassword.setBounds(10, 206, 79, 14);
		frmRegister.getContentPane().add(lblPassword);
		
		textField_6 = new JTextField();
		textField_6.setBounds(110, 206, 133, 20);
		frmRegister.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
	}
}

