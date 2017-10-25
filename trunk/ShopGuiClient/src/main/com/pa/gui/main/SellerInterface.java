package com.pa.gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SellerInterface extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1732726058568782502L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param string 
	 */
	
	public SellerInterface(String name) {
		setTitle(name);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 450, 260);
		
		JButton btnInventory = new JButton("Update inventory");
		btnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				UpdateStockInterface item=new UpdateStockInterface(name);
				item.setVisible(true);
				
			}
		});
		btnInventory.setBounds(98, 43, 220, 33);
		contentPane.add(btnInventory);
		
		JButton btnGetInventory = new JButton("Get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				ProductStockInterface st=new ProductStockInterface(name);
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

