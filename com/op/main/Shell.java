package com.op.main;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.util.ArrayList;

import com.op.commands.Clear;

public class Shell extends JFrame {
	public static final int WIDTH = 1300;
	public static final int HEIGHT = 1000;

	public Clear clear;

	public JTextArea terminal = new JTextArea(50, 80);
	public JTextField commandInput = new JTextField(80);
	public ExecuteCommand executor;
	
	public Shell() {
		Container commandline = getContentPane();
		commandline.setBackground(new Color(128, 0, 128));
		commandline.setLayout(new FlowLayout(FlowLayout.CENTER));
		commandline.add(terminal);
		commandline.add(new JScrollPane(terminal), "wrap");
		commandline.add(commandInput);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		terminal.setEditable(false);
		DefaultCaret caret = (DefaultCaret)terminal.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		
		executor = (text) -> {
			terminal.append(text + "\n");
		};

		commandInput.addActionListener((e) -> {
			executor.execute(commandInput.getText());
			commandInput.setText("");
		});
	}

	/*public void commandPrompt() {
		terminal.append(clearCommand);	
	}*/

	public void clearCommand() {
		if(commandInput.equals("clear")) {
			executor.execute(commandInput.getText());
			terminal.setText("");
		}
	}

	public TerminalListener getTerminalListener() {
		return(message) -> {
			synchronized(terminal) {
				terminal.append(message+"\n");
			}
		};
	}

	public void setExecutor(ExecuteCommand e) {
		executor = e;
	}

	public static interface ExecuteCommand {
		public void execute(String text);
	}
}