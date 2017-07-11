package com.op.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import com.op.main.Shell;

public class Window extends JFrame {
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 1000;
	public static final String TITLE = "JavaOS";
	
	public JProgressBar load = new JProgressBar(0, 100);

	public Shell shell;
	
	public Timer loadingTime = new Timer(100, new ActionListener() {
		public int counter = 1;

		@Override
		public void actionPerformed(ActionEvent e) {
		 	load.setValue(++counter);
		 	if(counter > 100) {
		 		loadingTime.stop();
		 		Shell shell = new Shell();
		 		shell.setVisible(true);
		 		shell.setSize(WIDTH, HEIGHT);
		 		shell.setTitle("Shell");
		 	}
		}
	});

	public Window() {
		Container con = getContentPane();
		con.setLayout(new FlowLayout(FlowLayout.CENTER));
		con.add(load);
		load.setValue(0);
		loadingTime.start();
	}
	
	public static void main(String args[]) {
		Window display = new Window();
		display.setTitle(TITLE);
		display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		display.setSize(WIDTH, HEIGHT);
		display.setLocationRelativeTo(null);
		display.setResizable(false);
		display.setVisible(true);
	}
}