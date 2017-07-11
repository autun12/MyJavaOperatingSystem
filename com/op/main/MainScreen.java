package com.op.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;

import com.op.main.Shell;
import com.op.main.Notepad;
import com.op.main.Paint;
import com.op.main.Calculator;
import com.op.games.Game;

public class MainScreen extends JFrame implements ActionListener {
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 1000;

	public Shell shell;
	public Notepad notepad;
	public Game games;
	public Paint paints;
	public Calculator calculator;

	ImageIcon backgroundImage = new ImageIcon("res\\Images\\MainScreenBackground1.jpg");

	public JMenuBar mainMenu = new JMenuBar();
	public JMenu menu = new JMenu("Main Menu");
	public JMenu accesoryMenu = new JMenu("Accesories");
	public JMenuItem terminal = new JMenuItem("Terminal");
	public JMenuItem shutdown = new JMenuItem("Shut Down");
	public JMenuItem raycasting = new JMenuItem("Game");
	public JMenuItem notepads = new JMenuItem("Notepad");
	public JMenuItem paint = new JMenuItem("Paint");
	public JMenuItem calculates = new JMenuItem("Calculator");
	public JLabel background = new JLabel(backgroundImage);

	public MainScreen() {
		Container main = getContentPane();
		background.setLayout(new BorderLayout());
		setJMenuBar(mainMenu);
		main.add(background);
		background.setOpaque(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void addMenus() {
		mainMenu.setBackground(new Color(128, 128, 128));
		mainMenu.setLayout(new BorderLayout());
		mainMenu.add(menu);
		menu.add(accesoryMenu);
		accesoryMenu.add(notepads);
		accesoryMenu.add(paint);
		accesoryMenu.add(calculates);
		menu.add(terminal);
		menu.add(raycasting);
		menu.add(shutdown);
		terminal.addActionListener(this);
		notepads.addActionListener(this);
		paint.addActionListener(this);
		calculates.addActionListener(this);
		raycasting.addActionListener(this);
		shutdown.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(terminal)) {
			Shell shell = new Shell();
			shell.setTitle("Terminal");
			shell.setSize(WIDTH, HEIGHT);
			shell.setLocationRelativeTo(null);
			shell.setVisible(true);
			//shell.commandPrompt();
		}

		if(e.getSource().equals(notepads)) {
			Notepad notes = new Notepad();
			notes.setTitle("Notepad");
			notes.setSize(WIDTH, HEIGHT);
			notes.setLocationRelativeTo(null);
			notes.setVisible(true);
		}

		if(e.getSource().equals(paint)) {
			Paint painter = new Paint();
			painter.setTitle("Paint");
			painter.setSize(WIDTH, HEIGHT);
			painter.setLocationRelativeTo(null);
			painter.setVisible(true);
		}

		if(e.getSource().equals(calculates)) {
			Calculator calculate = new Calculator();
			calculate.setTitle("Calculator");
			calculate.setSize(WIDTH, HEIGHT);
			calculate.setLocationRelativeTo(null);
			calculate.setVisible(true);
		}

		if(e.getSource().equals(raycasting)) {
			Game game = new Game();
			game.setTitle("raycasting");
			game.setLocationRelativeTo(null);
			game.setVisible(true);
		}

		if(e.getSource().equals(shutdown)) {
			System.exit(0);
		}
	}
}