package com.pa.cl.role;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class cashier extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cashier frame = new cashier();
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
	public cashier() {
		setTitle("cashier");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btncashRegister = new JButton("cash register");
		btncashRegister.setBounds(108, 46, 223, 23);
		contentPane.add(btncashRegister);
		
		JButton btnCustomerInfo = new JButton("customer info");
		btnCustomerInfo.setBounds(108, 90, 223, 23);
		contentPane.add(btnCustomerInfo);
		
		JButton btnStoreInventory = new JButton("store inventory");
		btnStoreInventory.setBounds(108, 135, 223, 23);
		contentPane.add(btnStoreInventory);
	}

}