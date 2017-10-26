package com.pa.gui.main;


import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

//import com.pa.common.Validators.validateOnlyLettersUsed;

public class RegisterEmployee extends JInternalFrame {

	private JPanel cpRegister = new JPanel();
	private JTextField textfullName  = new JTextField();
	private JTextField textphoneNumber  = new JTextField();
	private JTextField textemployeeID  = new JTextField();
	private JTextField textacountNumber  = new JTextField();
	private JTextField textbranchID  = new JTextField();
	private JPasswordField passwordField = new JPasswordField();


	/**
	 * Create the frame.
	 */
	public RegisterEmployee(String name) {
		setTitle(name);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 450, 260);
		
		JLabel lblFullName = new JLabel("full name :");
		lblFullName.setBounds(103, 25, 110, 14);
		cpRegister.add(lblFullName);
		
		JLabel lblPhoneNumber = new JLabel("phone number :");
		lblPhoneNumber.setBounds(103, 50, 110, 14);
		cpRegister.add(lblPhoneNumber);
		
		JLabel lblEmployeeId = new JLabel("employee id :");
		lblEmployeeId.setBounds(103, 75, 110, 14);
		cpRegister.add(lblEmployeeId);
		
		JLabel lblAcountNumber = new JLabel("acount number :");
		lblAcountNumber.setBounds(103, 100, 110, 14);
		cpRegister.add(lblAcountNumber);
		
		JLabel lblBranchId = new JLabel("branch id :");
		lblBranchId.setBounds(103, 125, 110, 14);
		cpRegister.add(lblBranchId);
		
		JLabel lblRole = new JLabel("role :");
		lblRole.setBounds(103, 150, 110, 14);
		cpRegister.add(lblRole);
		
		JLabel lblPassword = new JLabel("password :");
		lblPassword.setBounds(103, 175, 110, 14);
		cpRegister.add(lblPassword);
		
		textfullName = new JTextField();
		textfullName.setBounds(223, 22, 119, 20);
		cpRegister.add(textfullName);
		textfullName.setColumns(10);
		
		textphoneNumber = new JTextField();
		textphoneNumber.setColumns(10);
		textphoneNumber.setBounds(223, 47, 119, 20);
		cpRegister.add(textphoneNumber);
		
		textemployeeID = new JTextField();
		textemployeeID.setColumns(10);
		textemployeeID.setBounds(223, 72, 119, 20);
		cpRegister.add(textemployeeID);
		
		textacountNumber = new JTextField();
		textacountNumber.setColumns(10);
		textacountNumber.setBounds(223, 97, 119, 20);
		cpRegister.add(textacountNumber);
		
		textbranchID = new JTextField();
		textbranchID.setColumns(10);
		textbranchID.setBounds(223, 122, 119, 20);
		cpRegister.add(textbranchID);
		
		JComboBox comboBoxRole = new JComboBox();
		comboBoxRole.addItem("salesman");
		comboBoxRole.addItem("cashier");
		comboBoxRole.addItem("shift manager");
		comboBoxRole.setBounds(223, 147, 119, 20);
		cpRegister.add(comboBoxRole);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 172, 119, 20);
		cpRegister.add(passwordField);
	
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
//				//TODO validate that the input is correct
//				if(!validateOnlyLettersUsed(textfullName.getText()))
//				{
//					JOptionPane.showMessageDialog(cpRegister,"full name : use only in letters");
//				}
//				else if(!isCorrectPhoneNumberFormat(textphoneNumber.getText()))
//				{
//					JOptionPane.showMessageDialog(cpRegister,"phone number : use correct phone format");
//				}
//				else if(!isCorrectIDFormat(textemployeeID.getText()))
//				{
//					JOptionPane.showMessageDialog(cpRegister,"employee id : use correct id format");
//				}
//				else if(!validateOnlyNumbersUsed(textacountNumber.getText()))
//				{
//					JOptionPane.showMessageDialog(cpRegister,"acount number : use only in numbers");
//				}
//				else if(!validateOnlyNumbersUsed(textbranchID.getText()))
//				{
//					JOptionPane.showMessageDialog(cpRegister,"branch id : use only in numbers");
//				}
				
				//TODO generate worker id 
				
				//TODO update the db with all the info of the new worker
				
			}
		});
		btnRegister.setBounds(95, 220, 89, 30);
		cpRegister.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});
		btnCancel.setBounds(240, 220, 89, 27);
		cpRegister.add(btnCancel);
	}
}
