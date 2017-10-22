package com.pa.gui.main;

import java.awt.EventQueue;
import java.awt.event.WindowEvent;

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
					
					//gc.getMessage();
					
						
					//String json = "{\"username\":\"" + gc.getUsername() + "\",\"password\":\"" + gc.getPassword() + "\"}";
//					String json = "{\"username\":\"" + gc.getUsername() + "\",\"password\":\"abc\"}";
//					JOptionPane.showMessageDialog(null, "Sending to server :" + json);
//					client.sendMessage(json);
					//gc.getMessage();
					
					
					
					CashierInteface cs = new CashierInteface("Cashier");
					gc.getDesktopPane().add(cs);
					cs.setMaximum(true);
					cs.setSelected(true);
					gc.revalidate();
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
