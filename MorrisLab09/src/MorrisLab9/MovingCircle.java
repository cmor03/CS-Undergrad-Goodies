package MorrisLab9;
import java.awt.Color;
import edu.du.dudraw.*;

public abstract class MovingCircle {
	private double Xpos;
	private double Ypos;
	private double Xvelocity;
	private double Yvelocity;
	
	private double radius;
	private Color color;
	
	public MovingCircle(double r) {
		radius = r;
		Ypos = Math.random() * (1.0 - 0);
		Xpos = Math.random() * (1.0 - 0);
		
		Xvelocity = (Math.random() * (.01 + .01) -.01);
		Yvelocity = Xvelocity;
		
	}
	
	public abstract void move();
	
	public void draw() {
		DUDraw.setPenColor(color);
		DUDraw.filledCircle(Xpos, Ypos, radius);
	}
	
	public void forward() {
		Xpos += Xvelocity;
		Ypos += Yvelocity;
	}
	
	public void bounce() {
		if (Xpos >= 1 || Xpos <=0) {
			Xvelocity *= -1;
		}
		if (Ypos >= 1 || Ypos <=0) {
			Yvelocity *= -1;
		}
		System.out.println("Yeah this ran");
	}
	
	public void setColor(Color c) {
		color = c;
	}
	
	public double getX() {
		return Xpos;
	}
	
	public double getY() {
		return Ypos;
	}
	
	public void setX(double d) {
		Xpos = d;
		
	}
	
	public void setY(double d) {
		Ypos = d;
		
	}
	
	public double getYvel() {
		return Yvelocity;
	}
	
	public double getXvel() {
		return Xvelocity;
	}
	
	public void setYvel(double d) {
		Yvelocity = d;
	}
	
	public void setXvel(double d) {
		Xvelocity = d;
	}
}
