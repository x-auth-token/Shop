package com.pa.gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SalesmanInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesmanInterface frame = new SalesmanInterface();
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
	public SalesmanInterface() {
		setTitle("salesman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnInventory = new JButton("update inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UpdateStockInterface item=new UpdateStockInterface();
				item.setVisible(true);
				
			}
		});
		btnInventory.setBounds(98, 43, 220, 33);
		contentPane.add(btnInventory);
		
		JButton btnGetInventory = new JButton("get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ProductStockInterface st=new ProductStockInterface();
				st.setVisible(true);
				
			}
		});
		btnGetInventory.setBounds(98, 106, 220, 33);
		contentPane.add(btnGetInventory);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		btnNewButton.setBounds(165, 193, 89, 33);
		contentPane.add(btnNewButton);
	}
}

