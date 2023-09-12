package MorrisLab9;

import java.awt.Color;

public class SpeedyCircle extends NormalCircle {

	public SpeedyCircle(double r) {
		super(r);
		super.setColor(Color.GREEN);

	}
	

	public void bounce() {
		super.bounce();
		super.setYvel(super.getYvel()*1.005);
		super.setXvel(super.getXvel()*1.005);
		System.out.println("did this run?");
	}
	
	

}
