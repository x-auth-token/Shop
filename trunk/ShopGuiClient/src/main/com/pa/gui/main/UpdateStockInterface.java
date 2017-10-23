package com.pa.gui.main;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import com.pa.common.Constants.Id;
import com.pa.common.branch.*;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
public class UpdateStockInterface extends JFrame {

	private JPanel contentPane;
	private JTextField textVendor;
	private JTextField textColour;
	private JTextField textQuantity;
	private JTextField textPrice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateStockInterface frame = new UpdateStockInterface();
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
	public UpdateStockInterface() {
		setType(Type.POPUP);
		setTitle("items");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JComboBox cmbItems = new JComboBox();
		cmbItems.addItem("ShortPants");
		cmbItems.addItem("Jeans");
		cmbItems.addItem("TailoredPants");
		cmbItems.addItem("Tshirt");
		cmbItems.addItem("LongSleeveShirt");
		cmbItems.addItem("Coat");
		cmbItems.addItem("Sweater");
		cmbItems.setBounds(158, 13, 165, 20);
		contentPane.add(cmbItems);
		
		textVendor = new JTextField();
		textVendor.setColumns(10);
		textVendor.setBounds(158, 75, 165, 20);
		contentPane.add(textVendor);
		
		textColour = new JTextField();
		textColour.setColumns(10);
		textColour.setBounds(158, 106, 165, 20);
		contentPane.add(textColour);
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(158, 137, 165, 20);
		contentPane.add(textQuantity);
		
		JLabel lblNewLabel = new JLabel("type :");
		lblNewLabel.setBounds(77, 13, 107, 17);
		contentPane.add(lblNewLabel);
		
		JLabel lblSize = new JLabel("size :");
		lblSize.setBounds(77, 44, 107, 20);
		contentPane.add(lblSize);
		
		JLabel lblVendor = new JLabel("vendor :");
		lblVendor.setBounds(77, 78, 107, 14);
		contentPane.add(lblVendor);
		
		JLabel lblColour = new JLabel("colour :");
		lblColour.setBounds(77, 109, 107, 14);
		contentPane.add(lblColour);
		
		JLabel lblQuantity = new JLabel("quantity :");
		lblQuantity.setBounds(77, 140, 107, 14);
		contentPane.add(lblQuantity);
		
		JComboBox cmbSize = new JComboBox();
		cmbSize.addItem("small");
		cmbSize.addItem("medium");
		cmbSize.addItem("large");
		cmbSize.addItem("extraLarge");
		cmbSize.setBounds(158, 44, 165, 20);
		contentPane.add(cmbSize);
		
		JButton btnUpdat = new JButton("Update");
		btnUpdat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
		
				String iType=(String) cmbItems.getSelectedItem();
				String iSize=(String) cmbSize.getSelectedItem();
				int quntity = Integer.parseInt(textQuantity.getText());
				double price = Double.parseDouble(textPrice.getText());
				Stock st=new Stock(iType,iSize,textColour.getText(),textVendor.getText(),quntity,price);
				JOptionPane.showMessageDialog(contentPane,st.toString());
				
			}
		});
		btnUpdat.setBounds(110, 215, 89, 37);
		contentPane.add(btnUpdat);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent btnCancel)
			
			{
				dispose();
			}
		});
		btnCancel.setBounds(261, 213, 89, 37);
		contentPane.add(btnCancel);
		
		JLabel lblPrice = new JLabel("price :");
		lblPrice.setBounds(78, 170, 107, 14);
		contentPane.add(lblPrice);
		
		textPrice = new JTextField();
		textPrice.setColumns(10);
		textPrice.setBounds(157, 169, 165, 20);
		contentPane.add(textPrice);
	}
}