package MorrisLab9;

import java.awt.Color;

public class NormalCircle extends MovingCircle {


	public NormalCircle(double r) {
		super(r);
		super.setColor(Color.BLUE);
		// TODO Auto-generated constructor stub
	}

	public void move() {
		super.forward();
		super.bounce();
	}

}
