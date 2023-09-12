package MorrisProject3;

import edu.du.dudraw.DUDraw;

public abstract class FaceEmoji extends Emoji{

	//constructor
	public FaceEmoji(int a, int b, int c) {
		super(a, b, c);
	}
	
	//draw method
	public void draw() {
		DUDraw.circle(x, y, 50);
		DUDraw.filledCircle(x-20,y+10,5);
		DUDraw.filledCircle(x+20, y+10, 5);
		
	}
	
	

}
