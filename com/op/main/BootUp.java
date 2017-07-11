package com.op.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.op.main.Shell;
import com.op.main.Login;
import com.op.main.MainScreen;

public class BootUp extends JFrame {
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 1000;
	public static final String TITLE = "JavaOS";
	
	public JProgressBar load = new JProgressBar(0, 100);

	public Shell shell;
	public Login login;
	public MainScreen mainScreen;
	
	public Timer loadingTime = new Timer(100, new ActionListener() {
		public int counter = 1;

		@Override
		public void actionPerformed(ActionEvent e) {
		 	load.setValue(++counter);
		 	if(counter > 100) {
		 		loadingTime.stop();
		 		Login login = new Login();
		 		login.setTitle("Login");
		 		login.setSize(WIDTH, HEIGHT);
		 		login.setLocationRelativeTo(null);
		 		login.setUndecorated(true);
				login.setVisible(true);
		 		dispose();
		 	}
		}
	});

	public BootUp() {
		Container con = getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.CENTER));
		con.add(load);
		load.setValue(0);
		loadingTime.start();
	}
	
	public static void main(String args[]) {
		BootUp display = new BootUp();
		display.setTitle(TITLE);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setSize(WIDTH, HEIGHT);
		display.setLocationRelativeTo(null);
		display.setUndecorated(true);
		display.setResizable(false);
		display.setVisible(true);
	}
}