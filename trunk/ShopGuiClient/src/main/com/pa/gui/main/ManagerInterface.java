package com.pa.gui.main;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ManagerInterface extends JInternalFrame {
	private JPanel cpManager = new JPanel();;
	
	/**
	 * Create the frame.
	 */
	public ManagerInterface(String name) {
		
		setTitle(name);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 450, 260);
		
			/**
			 * Create the frame.
			 */
		JButton btnRegister = new JButton("employee register");
				btnRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						RegisterEmployee reg=new RegisterEmployee();
						reg.setVisible(true);
					}
				});

				btnRegister.setBounds(229, 41, 215, 39);
				cpManager.add(btnRegister);
				
				JButton btnstoreINventory = new JButton("update inventory");
				btnstoreINventory.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0)
					{
						UpdateStockInterface itm=new UpdateStockInterface();
						itm.setVisible(true);
					}
				});
				btnstoreINventory.setBounds(229, 91, 215, 39);
				cpManager.add(btnstoreINventory);
				
				JButton btnReports = new JButton("reports");
				btnReports.setBounds(229, 321, 215, 33);
				cpManager.add(btnReports);
				
				JButton btnCustomerInfo = new JButton("customer info");
				btnCustomerInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						CustomerListInterface cl=new CustomerListInterface();
						cl.setVisible(true);
					}
				});
				btnCustomerInfo.setBounds(229, 229, 215, 33);
				cpManager.add(btnCustomerInfo);
				
				JButton btncashRegister = new JButton("cash register");
				btncashRegister.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						CashRegisterInterface cr=new CashRegisterInterface();
						cr.setVisible(true);
					}
				});
				btncashRegister.setBounds(229, 185, 215, 33);
				cpManager.add(btncashRegister);
				
				JButton btnGetInventory = new JButton("get inventory");
				btnGetInventory.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						ProductStockInterface stk=new ProductStockInterface();
						stk.setVisible(true);
					}
				});
				btnGetInventory.setBounds(229, 141, 215, 33);
				cpManager.add(btnGetInventory);
				
				JButton btnEmployeeInfo = new JButton("employee info");
				btnEmployeeInfo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)
					{
						EmpoyeeInfoInterface emp= new EmpoyeeInfoInterface();
						emp.setVisible(true);
					}
				});
				btnEmployeeInfo.setBounds(229, 273, 215, 33);
				cpManager.add(btnEmployeeInfo);
				
				JButton btnExit = new JButton("Exit");
				btnExit.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) 
					{
						dispose();
					}
				});
				btnExit.setBounds(291, 399, 89, 33);
				cpManager.add(btnExit);
			}

		


	

}
