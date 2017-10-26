package com.pa.gui.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProductStockInterface extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2904959173320700748L;
	private JPanel contentPane = new JPanel();
	private JTable table = new JTable();
	private JButton btnNewButton = new JButton();
	private JButton btnClose = new JButton();
	
	
	/**
	 * Create the frame.
	 */
	public ProductStockInterface(String name) {
		setTitle(name);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 450, 260);
		getContentPane().add(contentPane);
		JScrollPane scrollPane = new JScrollPane();
		
		btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(441)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addGap(175)
					.addComponent(btnClose, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(370, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(14)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnClose)
						.addComponent(btnNewButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Item Type", "Size", "Colour", "Vendor", "Quantity", "Price", "Branch"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(136);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		int numC=table.getModel().getColumnCount();
		Object [] fill= new Object[numC];
		for(int i=0;i<numC;i++)
			{fill[i]="sad";
		((DefaultTableModel)table.getModel()).addRow(fill);}
	}
}