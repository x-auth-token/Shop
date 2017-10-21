package com.pa.cl.role;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import com.pa.cl.register.*;
import com.pa.cl.cashRegister.cashRegister;
import com.pa.cl.items.*;



public class manager extends JFrame {

	private JPanel cpManager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manager frame = new manager();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void close()
	{
		WindowEvent winClosingEvent=new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
	};
	/**
	 * Create the frame.
	 */
	public manager() {
		setTitle("manager");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		cpManager = new JPanel();
		cpManager.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(cpManager);
		cpManager.setLayout(null);
		
		JButton btnRegister = new JButton("new employee register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				register reg=new register();
				reg.setVisible(true);
				close();
			}
		});

		btnRegister.setBounds(100, 24, 215, 23);
		cpManager.add(btnRegister);
		
		JButton btnstoreINventory = new JButton("update inventory");
		btnstoreINventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				updateItems itm=new updateItems();
				itm.setVisible(true);
			}
		});
		btnstoreINventory.setBounds(100, 58, 215, 23);
		cpManager.add(btnstoreINventory);
		
		JButton btnReports = new JButton("reports");
		btnReports.setBounds(100, 199, 215, 23);
		cpManager.add(btnReports);
		
		JButton btnCustomerInfo = new JButton("customer info");
		btnCustomerInfo.setBounds(100, 161, 215, 23);
		cpManager.add(btnCustomerInfo);
		
		JButton btncashRegister = new JButton("cash register");
		btncashRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				cashRegister cr=new cashRegister();
				cr.setVisible(true);
			}
		});
		btncashRegister.setBounds(100, 126, 215, 23);
		cpManager.add(btncashRegister);
		
		JButton btnGetInventory = new JButton("get inventory");
		btnGetInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				productInStock stk=new productInStock();
				stk.setVisible(true);
			}
		});
		btnGetInventory.setBounds(100, 92, 215, 23);
		cpManager.add(btnGetInventory);
	}

}
