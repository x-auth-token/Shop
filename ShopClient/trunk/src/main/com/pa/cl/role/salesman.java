package com.pa.cl.role;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.pa.cl.items.*;
public class salesman extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salesman frame = new salesman();
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
	public salesman() {
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
				updateItems item=new updateItems();
				item.setVisible(true);
				dispose();
				
			}
		});
		btnInventory.setBounds(98, 43, 220, 33);
		contentPane.add(btnInventory);
		
		JButton btnGetInventory = new JButton("get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				productInStock st=new productInStock();
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

