package com.pa.cl.role;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.pa.common.branch.Stock;
import com.pa.cl.cashRegister.cashRegister;
import com.pa.cl.items.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		btncashRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				cashRegister cr=new cashRegister();
				cr.setVisible(true);
			}
		});
		btncashRegister.setBounds(108, 46, 223, 23);
		contentPane.add(btncashRegister);
		
		JButton btnCustomerInfo = new JButton("customer info");
		btnCustomerInfo.setBounds(108, 176, 223, 23);
		contentPane.add(btnCustomerInfo);
		
		JButton btnStoreInventory = new JButton("update inventory");
		btnStoreInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				updateItems uit=new updateItems();
				uit.setVisible(true);
			}
		});
		btnStoreInventory.setBounds(108, 90, 223, 23);
		contentPane.add(btnStoreInventory);
		
		JButton btnGetInventory = new JButton("get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				productInStock pis=new productInStock();
				pis.setVisible(true);
			}
		});
		btnGetInventory.setBounds(108, 134, 223, 23);
		contentPane.add(btnGetInventory);
	}
}