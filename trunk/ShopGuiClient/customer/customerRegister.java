package com.pa.cl.customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class customerRegister extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerRegister frame = new customerRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public customerRegister() {
		setTitle("customerRegister");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFullName = new JLabel("full name :");
		lblFullName.setBounds(89, 11, 89, 40);
		contentPane.add(lblFullName);
		
		JLabel lblPhoneNumber = new JLabel("phone number :");
		lblPhoneNumber.setBounds(89, 55, 89, 32);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblId = new JLabel("id :");
		lblId.setBounds(89, 100, 68, 25);
		contentPane.add(lblId);
		
		JLabel lblNewLabel = new JLabel("customer type :");
		lblNewLabel.setBounds(89, 136, 89, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(188, 21, 126, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(188, 61, 126, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(188, 102, 126, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox cmbCustType = new JComboBox();
		cmbCustType.addItem("NewCustomer");
		cmbCustType.addItem("ReturningCustomer");
		cmbCustType.addItem("VipCustomer");
		cmbCustType.setBounds(188, 138, 126, 20);
		contentPane.add(cmbCustType);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String cusType=(String)cmbCustType.getSelectedItem();
				
			}
		});
		btnRegister.setBounds(103, 203, 89, 32);
		contentPane.add(btnRegister);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		btnCancel.setBounds(225, 203, 89, 32);
		contentPane.add(btnCancel);
	}

}
