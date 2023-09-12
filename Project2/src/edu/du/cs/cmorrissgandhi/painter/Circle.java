package edu.du.cs.cmorrissgandhi.painter;
import java.awt.*;

public class Circle extends PaintingPrimitive {
	Point center;
	Point radiusPoint;

	public Circle(Point center, Point radiusPoint, Color c) {
		super(c);
		this.center = center;
		this.radiusPoint = radiusPoint;
	}

	
	public void drawGeometry(Graphics g) {
		
		int radius = (int) Math.abs(center.distance(radiusPoint));
		g.drawOval(center.x - radius, center.y - radius, radius * 2, radius * 2);
	}
	
	public String toString() {
		return "Circle";
	}

}
