package com.op.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.*;

import com.op.main.MainScreen;

public class Login extends JFrame implements ActionListener {
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 1000;

	public MainScreen mainScreen;

	public JTextField userName = new JTextField(20);
	public JPasswordField userPassword = new JPasswordField(20);
	public JButton login = new JButton("Login");

	ImageIcon backgroundImage = new ImageIcon("C:\\Users\\Austin\\Documents\\GitHub\\JavaOptest\\res\\Images\\LoginScreen.jpg");
	public JLabel background = new JLabel(backgroundImage);

	// public BufferedReader loginReader = new BufferedReader(new InputStreamReader(System.in));
	public File userInfo = new File("C:\\Users\\Austin\\Documents\\GitHub\\JavaOptest\\OSUserInfo\\UserInfo.txt");

	public Login() {
		Container loginField = getContentPane();
		loginField.setLayout(new FlowLayout(FlowLayout.CENTER));
		loginField.add(userName);
		loginField.add(userPassword);
		loginField.add(login);
		loginField.add(background);
		background.setOpaque(true);
		login.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String name;
		String pass;

		if(userName.getText().equals(name) && userPassword.getText().equals(pass)) {
			MainScreen mainScreen = new MainScreen();
			mainScreen.setTitle("Main Screen");
			mainScreen.setSize(WIDTH, HEIGHT);
			mainScreen.setLocationRelativeTo(null);
			mainScreen.setUndecorated(true);
			mainScreen.setVisible(true);
			mainScreen.addMenus();
			dispose();
		} else {
			System.out.println("Wrong User Name or Password.");
		}
	}
}