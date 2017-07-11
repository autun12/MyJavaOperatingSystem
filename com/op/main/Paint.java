package com.op.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Paint extends JFrame implements MouseMotionListener, MouseListener {
	
	public int x, y;
	public int px;
	public int py;
	public int count = 0;

	public Paint() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		addMouseMotionListener(this);
		addMouseListener(this);
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		if(count == 0) {
			x = e.getX();
			y = e.getY();
			Graphics g = getGraphics();
			g.setColor(Color.BLUE);
			g.drawLine(x,y,x,y);
			px = x;
			py = y;
			count = 2;
		} else {
			x = e.getX();
			y = e.getY();
			Graphics g = getGraphics();
			g.setColor(Color.BLUE);
			g.drawLine(x,y,x,y);
			px = x;
			py = y;
		}
	}

	public void mouseClicked(MouseEvent e) {
		
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {
		count = 0;
	}

	public void mousePressed(MouseEvent e) {
		count = 0;
	}

	public void mouseReleased(MouseEvent e) {

	}
}