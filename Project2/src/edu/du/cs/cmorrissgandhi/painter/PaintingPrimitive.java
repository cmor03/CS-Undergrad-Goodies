package edu.du.cs.cmorrissgandhi.painter;
import java.awt.Graphics;
import java.io.Serializable;
import java.awt.Color;

public abstract class PaintingPrimitive implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Color color;
	
	PaintingPrimitive(Color color) {
		this.color = color;
	}

	// This is an example of the Template Design Pattern

	// this is all invariant code
	public final void draw(Graphics g) {
		g.setColor(color);
		drawGeometry(g);
	}

	public void setColor(Color color) {
		this.color = color;
	}

	protected abstract void drawGeometry(Graphics g);

}
