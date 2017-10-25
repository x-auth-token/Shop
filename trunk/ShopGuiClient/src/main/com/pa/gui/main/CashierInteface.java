package com.pa.gui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class CashierInteface extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5723551450669661039L;
	
	JPanel contentPane = new JPanel();
	public CashierInteface(String name) {
		setTitle(name);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 450, 260);
	
		
		JButton btncashRegister = new JButton("cash register");
		btncashRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				CashRegisterInterface cr = new CashRegisterInterface("Cashier - Cach Register");
				contentPane.add(cr);
				cr.setVisible(true);
				getParent().add(cr);
				
			}
		});
		btncashRegister.setBounds(106, 33, 223, 30);
		contentPane.add(btncashRegister);
		
		JButton btnCustomerInfo = new JButton("customer info");
		btnCustomerInfo.setBounds(106, 162, 223, 31);
		contentPane.add(btnCustomerInfo);
		
		JButton btnStoreInventory = new JButton("update inventory");
		btnStoreInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				UpdateStockInterface uit=new UpdateStockInterface("Cashier - Update Stock");
				uit.setVisible(true);
			}
		});
		
		JButton btnNewButton = new JButton("New button");
		contentPane.add(btnNewButton);
		btnStoreInventory.setBounds(106, 74, 223, 33);
		contentPane.add(btnStoreInventory);
		
		JButton btnGetInventory = new JButton("get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				ProductStockInterface pis=new ProductStockInterface("Cashier - Products Stock");
				pis.setVisible(true);
			}
		});
		btnGetInventory.setBounds(106, 118, 223, 33);
		contentPane.add(btnGetInventory);
		
		this.add(contentPane);
		
//		JButton btnExit = new JButton("Exit");
//		btnExit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) 
//			{
//				dispose();
//			}
//		});

	}

}
