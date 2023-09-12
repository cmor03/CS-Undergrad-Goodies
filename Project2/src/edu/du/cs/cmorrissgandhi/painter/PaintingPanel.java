package edu.du.cs.cmorrissgandhi.painter;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class PaintingPanel extends JPanel {

	//maybe have this be the original arraylist we'll see 
	private Vector<PaintingPrimitive> primitives = new Vector<>();
	private PaintingPrimitive obj = null;
	

	PaintingPanel() {
		setBackground(Color.WHITE);
	}

	
	// race condition if you have one thread calling addPrimitive and another thread calling
	// paintComponent
	public synchronized void addPrimitive(PaintingPrimitive obj) {
		
		primitives.add(obj);
		this.repaint();

	}
	
	// this method is used to create the live object effect, where you can see what you're
	// drawing before you place it
	public void tempPrim(PaintingPrimitive obj) {
		this.obj = obj;
		this.repaint();
	}

	@Override
	protected synchronized void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		// i'm confident that this is not painting to the right graphics
		
		for (PaintingPrimitive shape : primitives) {
			shape.draw(g);
		}
		
		if (obj != null) {
			obj.draw(g);
		}
	}

}
