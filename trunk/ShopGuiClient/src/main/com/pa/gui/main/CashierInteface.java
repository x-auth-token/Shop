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
				getParent().add(cr);
				
				
				try {
					cr.setSelected(true);
					cr.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				cr.setVisible(true);
				revalidate();
				getParent().revalidate();
				
				
				
			}
		});
		btncashRegister.setBounds(106, 33, 223, 30);
		contentPane.add(btncashRegister);
		
		JButton btnCustomerInfo = new JButton("customer info");
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerListInterface cl=new CustomerListInterface("Cashier - Customers List");
				getParent().add(cl);
				
				
				try {
					cl.setSelected(true);
					cl.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				cl.setVisible(true);
				revalidate();
				getParent().revalidate();
			}
		});
		btnCustomerInfo.setBounds(106, 162, 223, 31);
		contentPane.add(btnCustomerInfo);
		
		JButton btnStoreInventory = new JButton("update inventory");
		btnStoreInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent btnStoreInventoryClicked) 
			{
				UpdateStockInterface uit=new UpdateStockInterface("Cashier - Update Stock");
				getParent().add(uit);
				
				
				try {
					uit.setSelected(true);
					uit.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				uit.setVisible(true);
				revalidate();
				getParent().revalidate();	
			}
		});
		btnStoreInventory.setBounds(106, 74, 223, 33);
		contentPane.add(btnStoreInventory);
		
		JButton btnGetInventory = new JButton("get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent btnGetInventoryClicked)
			{
				ProductStockInterface pis=new ProductStockInterface("Cashier - Products Stock");
				getParent().add(pis);
				
				
				try {
					pis.setSelected(true);
					pis.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				pis.setVisible(true);
				revalidate();
				getParent().revalidate();
			}
		});
		btnGetInventory.setBounds(106, 118, 223, 33);
		contentPane.add(btnGetInventory);
		
		getContentPane().add(contentPane);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});

	}

}
