package edu.du.cs.cmorris.assignment2;

import edu.du.dudraw.DUDraw;
import edu.du.dudraw.Draw;

public class Planet {
	
	double x;
	double y;
	
	double radius;
	
	public Planet(double x, double y) {
		this.x = x;
		this.y = y;
		this.radius = getRandomNumber(1,6);
	}
	
	public void draw(Draw panel) {
		DUDraw.setPenColor(DUDraw.BLUE);
		panel.filledCircle(x, y, radius);
	}
	
	public String toString() {
		return "("+ x + ", " + y + ")";
	}
	
	public double getRandomNumber(int min, int max) {
	    return (double) ((Math.random() * (max - min)) + min);
	}
	

}
