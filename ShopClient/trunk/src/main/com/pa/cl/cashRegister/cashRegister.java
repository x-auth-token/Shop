package com.pa.cl.cashRegister;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cashRegister extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textQuantity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cashRegister frame = new cashRegister();
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
	public cashRegister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JComboBox cmbItems = new JComboBox();
		cmbItems.addItem("ShortPants");
		cmbItems.addItem("Jeans");
		cmbItems.addItem("TailoredPants");
		cmbItems.addItem("Tshirt");
		cmbItems.addItem("LongSleeveShirt");
		cmbItems.addItem("Coat");
		cmbItems.addItem("Sweater");
		
		JComboBox cmbSize = new JComboBox();
		cmbSize.addItem("small");
		cmbSize.addItem("medium");
		cmbSize.addItem("large");
		cmbSize.addItem("extraLarge");
		
		JComboBox cmbCtype = new JComboBox();
		cmbCtype.addItem("NewCustomer");
		cmbCtype.addItem("ReturningCustomer");
		cmbCtype.addItem("VipCustomer");
		
		JLabel lblCustomerType = new JLabel("Customer Type :");
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Item :");
		
		JLabel lblQuantity = new JLabel("Quantity :");
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int numC=table.getModel().getColumnCount();
				Object [] fill= new Object[numC];
				fill[0]=cmbItems.getSelectedItem();
				fill[1]=cmbSize.getSelectedItem();
				fill[2]=99.90;
				fill[3]=textQuantity.getText();
				fill[4]=cmbCtype.getSelectedItem();
			
				((DefaultTableModel)table.getModel()).addRow(fill);}
			
		});
		
		
		
		JLabel lblSize = new JLabel("Size :");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1344, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addGap(124)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerType, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(cmbSize, 0, 156, Short.MAX_VALUE)
							.addComponent(cmbItems, 0, 156, Short.MAX_VALUE)
							.addComponent(cmbCtype, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap(858, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 416, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cmbItems, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(cmbSize, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(cmbCtype, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCustomerType, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblQuantity, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(textQuantity, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(76))
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
	}
}
