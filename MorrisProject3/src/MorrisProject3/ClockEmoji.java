package MorrisProject3;

import edu.du.dudraw.DUDraw;

public class ClockEmoji extends Emoji {
	
	//instance variables
	int hour;
	double temp;
	
	//constructor that calls the super
	public ClockEmoji(int a, int b, int c, int d) {
		super(a, b, c);
		hour = d;
		
	}
	
	//draws a circle, and then calculates the hour hand based on the inputted hour
	void draw() {
		DUDraw.circle(x, y, 50);
	    DUDraw.line(x, y, 42 * Math.cos(-((hour/12.0*360-90)*Math.PI/180)) + x, 42 * Math.sin(-((hour/12.0*360-90)*Math.PI/180)) + y);
	}

}
