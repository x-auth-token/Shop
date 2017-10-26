package com.pa.gui.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;

public class CashRegisterInterface extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4636527186366116564L;
	private JPanel contentPane = new JPanel();
	private JTable table = new JTable();
	private JTextField textQuantity = new JTextField();

	
	/**
	 * Create the frame.
	 */
	public CashRegisterInterface(String name) {
		setTitle(name);
		setResizable(false);
		setVisible(true);
		setBounds(0, 0, 450, 260);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(new Rectangle(0, 0, 450, 260));
		contentPane.add(scrollPane);
		
		JComboBox<String> cmbItems = new JComboBox<String>();
		cmbItems.addItem("ShortPants");
		cmbItems.addItem("Jeans");
		cmbItems.addItem("TailoredPants");
		cmbItems.addItem("Tshirt");
		cmbItems.addItem("LongSleeveShirt");
		cmbItems.addItem("Coat");
		cmbItems.addItem("Sweater");
		//contentPane.add(cmbItems);
		
		JComboBox<String> cmbSize = new JComboBox<String>();
		cmbSize.addItem("small");
		cmbSize.addItem("medium");
		cmbSize.addItem("large");
		cmbSize.addItem("extraLarge");
		//contentPane.add(cmbSize);
		
		JComboBox<String> cmbCtype = new JComboBox<String>();
		cmbCtype.addItem("NewCustomer");
		cmbCtype.addItem("ReturningCustomer");
		cmbCtype.addItem("VipCustomer");
		
	
		
		JLabel lblCustomerType = new JLabel("Customer Type :");
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Item :");
		
		JLabel lblQuantity = new JLabel("Quantity :");
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int numC=table.getModel().getColumnCount();
				Object [] fill= new Object[numC];
				fill[0]=cmbItems.getSelectedItem();
				fill[1]=cmbSize.getSelectedItem();
				fill[2]=99.90;
				fill[3]=textQuantity.getText();
				fill[4]=cmbCtype.getSelectedItem();
			
				((DefaultTableModel)table.getModel()).addRow(fill);
			}
			
		});
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int i=table.getSelectedRow();
				if(i>=0)
				((DefaultTableModel)table.getModel()).removeRow(i);
				else
					JOptionPane.showMessageDialog(null,"unable to delete");
			}
		});
		
		JButton btnCommit = new JButton("Commit");
		btnCommit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			}
		});
		
		
		
		
		
		JLabel lblSize = new JLabel("Size :");
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Add Customer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RegisterCustomerInterface cr=new RegisterCustomerInterface(name);
				cr.setVisible(true);
			}
		});
		
		JButton btnNewButton_1 = new JButton("Customer List");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				CustomerListInterface cl=new CustomerListInterface(name);
				cl.setVisible(true);
			}
		});
		
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCommit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
					.addGap(178)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCustomerType, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(cmbCtype, 0, 191, Short.MAX_VALUE)
							.addGap(2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
								.addComponent(cmbSize, 0, 193, Short.MAX_VALUE)
								.addComponent(cmbItems, Alignment.TRAILING, 0, 193, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(174)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addGap(419))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnAdd, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(btnDelete, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(30)
							.addComponent(btnCommit, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(36)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(cmbItems, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
									.addGap(34)
									.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(cmbSize, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)))
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCustomerType, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
								.addComponent(cmbCtype, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE))
							.addGap(36)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
								.addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Item", "Size", "Price", "Quantity", "CustomerType"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(87);
		table.getColumnModel().getColumn(2).setPreferredWidth(86);
		table.getColumnModel().getColumn(4).setPreferredWidth(89);
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		getContentPane().add(contentPane);
		
		
		
	}
}
