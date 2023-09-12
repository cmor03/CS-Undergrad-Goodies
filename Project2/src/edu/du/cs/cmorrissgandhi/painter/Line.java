package edu.du.cs.cmorrissgandhi.painter;
import java.awt.Graphics;
import java.awt.Point;
import java.io.Serializable;
import java.awt.Color;

public class Line extends PaintingPrimitive implements Serializable{
	Point startPoint = new Point();
	Point endPoint = new Point();

	public Line(Point start, Point end, Color c) {
		super(c);
		this.startPoint = start;
		this.endPoint = end;
	}


	public void drawGeometry(Graphics g) {
		g.drawLine(startPoint.x, startPoint.y, endPoint.x, endPoint.y);
		
	}
	
	@Override
	public String toString() {
		return "Line";
		
	}

}

