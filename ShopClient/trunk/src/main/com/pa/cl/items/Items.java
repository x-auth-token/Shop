package com.pa.cl.items;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.pa.common.Items.*;
public class Items extends JFrame {

	private JPanel contentPane;
	private JTextField textVendor;
	private JTextField textColour;
	private JTextField textQuantity;
	private JTextField textBranch;
	private JTextField textInStok;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Items frame = new Items();
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
	public Items() {
		setTitle("items");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox cmbItems = new JComboBox();
		cmbItems.addItem("ShortPents");
		cmbItems.addItem("Jeans");
		cmbItems.addItem("TailoredPents");
		cmbItems.addItem("Tshirt");
		cmbItems.addItem("LongSleeveShirt");
		cmbItems.addItem("Coat");
		cmbItems.addItem("Sweater");
		cmbItems.setBounds(127, 31, 165, 20);
		contentPane.add(cmbItems);
		
		textVendor = new JTextField();
		textVendor.setColumns(10);
		textVendor.setBounds(127, 93, 165, 20);
		contentPane.add(textVendor);
		
		textColour = new JTextField();
		textColour.setColumns(10);
		textColour.setBounds(127, 124, 165, 20);
		contentPane.add(textColour);
		
		textQuantity = new JTextField();
		textQuantity.setColumns(10);
		textQuantity.setBounds(127, 155, 165, 20);
		contentPane.add(textQuantity);
		
		textBranch = new JTextField();
		textBranch.setColumns(10);
		textBranch.setBounds(127, 217, 165, 20);
		contentPane.add(textBranch);
		
		textInStok = new JTextField();
		textInStok.setColumns(10);
		textInStok.setBounds(127, 186, 165, 20);
		contentPane.add(textInStok);
		
		JLabel lblNewLabel = new JLabel(" type :");
		lblNewLabel.setBounds(10, 34, 107, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblSize = new JLabel("size :");
		lblSize.setBounds(10, 65, 107, 14);
		contentPane.add(lblSize);
		
		JLabel lblVendor = new JLabel("vendor :");
		lblVendor.setBounds(10, 96, 107, 14);
		contentPane.add(lblVendor);
		
		JLabel lblColour = new JLabel("colour :");
		lblColour.setBounds(10, 127, 107, 14);
		contentPane.add(lblColour);
		
		JLabel lblQuantity = new JLabel("quantity :");
		lblQuantity.setBounds(10, 158, 107, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblInStock = new JLabel("in stock :");
		lblInStock.setBounds(10, 189, 107, 14);
		contentPane.add(lblInStock);
		
		JLabel lblInBranch = new JLabel("in branch :");
		lblInBranch.setBounds(10, 220, 107, 14);
		contentPane.add(lblInBranch);
		
		JComboBox cmbSize = new JComboBox();
		cmbSize.addItem("small");
		cmbSize.addItem("medium");
		cmbSize.addItem("large");
		cmbSize.addItem("extraLarge");
		cmbSize.setBounds(127, 62, 165, 20);
		contentPane.add(cmbSize);
		
		JButton btnUpdat = new JButton("Update");
		btnUpdat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String iType=(String) cmbItems.getSelectedItem();
				String iSize=(String) cmbSize.getSelectedItem();
			}
		});
		btnUpdat.setBounds(335, 155, 89, 37);
		contentPane.add(btnUpdat);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(335, 203, 89, 37);
		contentPane.add(btnCancel);
	}
}
