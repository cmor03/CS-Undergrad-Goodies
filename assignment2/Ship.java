package edu.du.cs.cmorris.assignment2;

import edu.du.dudraw.DUDraw;
import edu.du.dudraw.Draw;
import java.awt.Rectangle;

public class Ship {

	public double x;
	public double y;
	public Rectangle r;

	double radius;

	public Ship(double x, double y) {
		this.x = x;
		this.y = y;
		radius = 14;
		r = new Rectangle();

	}

	public void draw(Draw panel) {
		panel.filledCircle(x, y, radius);
		
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	// draws the space that the ship can see
	public void drawRange(Draw panel) {
		panel.setPenColor(DUDraw.GREEN);
		panel.square(x, y, 50);
		r = new Rectangle((int)x-50, (int)y-50, 100,100);
		//panel.square(r.getX(), r.getY(), r.getWidth());

	}

	public Rectangle getR() {
		return r;
	}

}
