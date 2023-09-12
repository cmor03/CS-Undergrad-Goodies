package MorrisProject3;

import edu.du.dudraw.DUDraw;

public class SuprisedFaceEmoji extends FaceEmoji{
	
	//constructor
	public SuprisedFaceEmoji(int a, int b, int c) {
		super(a, b, c);
	}
	
	//draw method 
	public void draw() {
		super.draw();
		DUDraw.filledCircle(x, y-15, 10);
	}
	

}
