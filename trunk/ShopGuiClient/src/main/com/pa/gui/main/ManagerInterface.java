package com.pa.gui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

public class ManagerInterface extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6268309166836831121L;
	private JPanel cpManager = new JPanel();;

	/**
	 * Create the frame.
	 */
	public ManagerInterface(String name) {

		setTitle(name);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 450, 260);
		getContentPane().add(cpManager);
		/**
		 * Create the frame.
		 */
		JButton btnRegister = new JButton("employee register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent btnRegisterClicked) {
				RegisterEmployee reg = new RegisterEmployee(name);
				getParent().add(reg);

				try {
					reg.setSelected(true);
					reg.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				reg.setVisible(true);
				revalidate();
				getParent().revalidate();
			}
		});

		btnRegister.setBounds(229, 41, 215, 39);
		cpManager.add(btnRegister);

		JButton btnstoreINventory = new JButton("update inventory");
		btnstoreINventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UpdateStockInterface itm = new UpdateStockInterface(name);
				getParent().add(itm);

				try {
					itm.setSelected(true);
					itm.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				itm.setVisible(true);
				revalidate();
				getParent().revalidate();
			}
		});
		btnstoreINventory.setBounds(229, 91, 215, 39);
		cpManager.add(btnstoreINventory);

		JButton btnReports = new JButton("reports");
		btnReports.setBounds(229, 321, 215, 33);
		cpManager.add(btnReports);

		JButton btnCustomerInfo = new JButton("customer info");
		btnCustomerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CustomerListInterface cl = new CustomerListInterface(name);
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
		btnCustomerInfo.setBounds(229, 229, 215, 33);
		cpManager.add(btnCustomerInfo);

		JButton btncashRegister = new JButton("cash register");
		btncashRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CashRegisterInterface cr = new CashRegisterInterface(name);
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
		btncashRegister.setBounds(229, 185, 215, 33);
		cpManager.add(btncashRegister);

		JButton btnGetInventory = new JButton("get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProductStockInterface stk = new ProductStockInterface(name);
				getParent().add(stk);

				try {
					stk.setSelected(true);
					stk.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				stk.setVisible(true);
				revalidate();
				getParent().revalidate();
			}
		});
		btnGetInventory.setBounds(229, 141, 215, 33);
		cpManager.add(btnGetInventory);

		JButton btnEmployeeInfo = new JButton("employee info");
		btnEmployeeInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EmpoyeeInfoInterface emp = new EmpoyeeInfoInterface(name);
				getParent().add(emp);

				try {
					emp.setSelected(true);
					emp.setMaximum(true);
				} catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				emp.setVisible(true);
				revalidate();
				getParent().revalidate();
			}
		});
		btnEmployeeInfo.setBounds(229, 273, 215, 33);
		cpManager.add(btnEmployeeInfo);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBounds(291, 399, 89, 33);
		cpManager.add(btnExit);
	}

}
