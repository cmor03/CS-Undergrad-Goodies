package MorrisLab9;

import java.awt.Color;

public class WobblyCircle extends MovingCircle {

	public WobblyCircle(double r) {
		super(r);
		super.setColor(Color.red);
		
	}

	
	public void move() {
		super.forward();
		super.bounce();
		
		super.setX(super.getX()+(Math.random() * (.01 +.01)) -.01);
		super.setY(super.getY()+(Math.random() * (.01 +.01)) -.01);
	}

}
