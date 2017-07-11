package com.op.main;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Calculator extends JFrame implements ActionListener {
	
	public JButton plus = new JButton("+");
	public JButton minus = new JButton("-");
	public JButton mult = new JButton("X");
	public JButton div = new JButton("/");

	public JTextField num1 = new JTextField();
	public JTextField num2 = new JTextField();
	public JTextField result = new JTextField();

	public Calculator() {
		setBounds(0, 0, 300, 150);
		setLayout(new GridLayout(5, 2));
		add(new JLabel("Num1"));
		add(num1);
		add(new JLabel("Num2"));
		add(num2);
		add(new JLabel("Result"));
		add(result);
		add(plus);
		add(minus);
		add(mult);
		add(div);

		plus.addActionListener(this);
		minus.addActionListener(this);
		mult.addActionListener(this);
		div.addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String s1 = num1.getText();
		String s2 = num2.getText();

		double nums1 = 0;
		double nums2 = 0;

		try {
			nums1 = Double.parseDouble(s1);
			nums2 = Double.parseDouble(s2);
		} catch(Exception er) {
			result.setText("Invalid Value");
			return;
		}

		double results = 0;

		if(e.getSource().equals(plus)) {
			results = nums1 + nums2;
		} else if(e.getSource().equals(minus)) {
			results = nums1 - nums2;
		} else if(e.getSource().equals(mult)) {
			results = nums1 * nums2;
		} else if(e.getSource().equals(div)) {
			results = nums1 / nums2;
		}
		result.setText(" " + results);
	}
}