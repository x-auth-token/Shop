package com.pa.gui.main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.UIManager;

public class MainWindow {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setForeground(new Color(128, 128, 128));
		frame.getContentPane().setForeground(new Color(128, 128, 128));
		frame.getContentPane().setBackground(new Color(128, 128, 128));
		frame.setBackground(new Color(128, 128, 128));
		//frame.setBounds(100, 100, 450, 300);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmConnectToServer = new JMenuItem("Connect to Server");
		mntmConnectToServer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent connectToServerButtonClicked) {
				Object event  = connectToServerButtonClicked.getSource();
				if (event == mntmConnectToServer) {
					LoginDialog ld = new LoginDialog();
					ld.setLocationRelativeTo(null);
					ld.setVisible(true);
				}
			}
		});
		mnFile.add(mntmConnectToServer);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
	}

}
