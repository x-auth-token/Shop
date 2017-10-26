package com.pa.gui.main;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGui guiClient = new ClientGui();
					//LoginDialog login = new LoginDialog();
					guiClient.setExtendedState(JFrame.MAXIMIZED_BOTH);
					guiClient.pack();
					guiClient.setVisible(true);
					guiClient.loginInterfaceStart();

					if (guiClient.isAuthenticated()) {
						//login.dispose();
						switch (guiClient.getPermission()) {
						case CASHIER:
							CashierInteface cashierInterface = new CashierInteface("Cashier");
							guiClient.getDesktopPane().add(cashierInterface);
							cashierInterface.setMaximum(true);
							cashierInterface.setSelected(true);
							cashierInterface.revalidate();
							break;
						case SELLER:
							SellerInterface sellereInterface = new SellerInterface("Seller");
							guiClient.getDesktopPane().add(sellereInterface);
							sellereInterface.setMaximum(true);
							sellereInterface.setSelected(true);
							guiClient.revalidate();
							break;
						
						case MANAGER:
							ManagerInterface managerInterface = new ManagerInterface("Manager");
							guiClient.getDesktopPane().add(managerInterface);
							managerInterface.setMaximum(true);
							managerInterface.setSelected(true);
							guiClient.revalidate();
							break;
						
						default:
							break;
						}
					}  else {
						JOptionPane.showMessageDialog(null, "Invalid username or password! PLease try again.");
					}

				} catch (Exception e) {
					if (e.toString().contains("UnknownHost")) {

						JOptionPane.showMessageDialog(null, "Please Provide Valid Server IP or Name");
					} else if (e.toString().contains("ConnectException")) {
						JOptionPane.showMessageDialog(null,
								"Connection Refused! Check if you are allowed to connect or server running.");
					} else {
						JOptionPane.showMessageDialog(null, e);
					}
				}

			}
		});
	}
}
