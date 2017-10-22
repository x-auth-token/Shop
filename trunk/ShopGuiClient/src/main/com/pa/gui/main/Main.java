package com.pa.gui.main;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientGui gc = new ClientGui();
					LoginDialog login = new LoginDialog();

					gc.pack();
					gc.setVisible(true);

					login.setLocationRelativeTo(null);
					login.setClientGui(gc);
					login.setVisible(true);
					if (login.isCanceled()) {
						JOptionPane.showMessageDialog(null, "You should login first!. Closing");
						gc.dispatchEvent(new WindowEvent(gc, WindowEvent.WINDOW_CLOSING));

					}

					gc.startClient(gc.getUsername(), gc.getPassword(), gc.getBranch(), gc.getServer(), gc.getPort());

					if (gc.isAuthenticated()) {

						switch (gc.getUserPermissionSet()) {
						case CASHIER:
							CashierInteface cs = new CashierInteface("Cashier");
							gc.getDesktopPane().add(cs);
							cs.setMaximum(true);
							cs.setSelected(true);
							gc.revalidate();
							break;
						case SELLER:
							break;
						case MANAGER:
							break;
						default:
							break;
						}
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
