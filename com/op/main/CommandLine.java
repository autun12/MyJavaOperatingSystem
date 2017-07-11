package com.op.main;

import java.io.OutputStream;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

//Inner class declaration
//Uses the runnable interface to allow for multi-threading
//Multi-threading = running multiple things simultaneously
public class CommandLine implements Runnable {

	private HashMap<String, Commands> commands;
	private OutputStream out;
	private Term term;
	private TerminalListener terminalListener;
	private boolean running;
	private Pattern commandPattern = Pattern.compile("\\s+");

    //Constructor
	public CommandLine(OutputStream out) {
		commands = new HashMap<>();
		this.out = out;
		this.terminalListener = (message) -> {
			System.out.println(message);
		};
		initCommands();
	}

	public void addCommand(Commands command) {
		this.commands.put(command.getName(), command);
	}

	public void setTerminalListener(TerminalListener listener) {
		this.terminalListener = listener;
	}

	public void run() {
		Scanner comInput = new Scanner(System.in);
		running = true;
		while(running) {
			executeCommand(comInput.nextLine());
		}
	}

	public void executeCommand(String text) {
		String[] args = commandPattern.split(text, 2);
		String commandString = args[0];
		String arg = "";
		if (args.length >= 2) {
			arg = args[1].trim();
		}
		
		if(commands.containsKey(commandString)) {
			Commands command = commands.get(commandString);
			if(!command.execute(arg)) {
				terminalListener.update("Correct usage: " + command.getName() + "\t" + command.getParameters());
			} else {
				terminalListener.update("Unkown command. Type 'help' for help.");
			}
		}
	}

	private void initCommands() {
		addCommand(new Commands(
			"help",
			"[string]",
			"Get help.",
			(arg) -> {
				if (arg==null || arg.equals("")) {
					for (Commands command: commands.values()) {
						terminalListener.update(command.getName() + "\n" + command.getDescription());
					}
				} else if(commands.containsKey(arg)) {
					Commands command = commands.get(arg);
					terminalListener.update(command.getName()+"\t"+command.getParameters());
					terminalListener.update(command.getDescription());
				} else {
					// TODO: Do regex on name and description...
				}
				return true;
			}
		));

		addCommand(new Commands(
			"clear",
			"",
			"clears the terminal.",
			(arg) -> {
				if (arg.equals("clear")) {
					Commands command = commands.get(arg);
					terminalListener.update(command.getName() + command.getParameters());
					return true;
				}
				return false;
			}
		));
	}
}