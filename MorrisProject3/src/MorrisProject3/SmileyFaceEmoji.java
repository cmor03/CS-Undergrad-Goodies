package MorrisProject3;
import edu.du.dudraw.DUDraw;

public class SmileyFaceEmoji extends FaceEmoji{

	
	//constructor
	public SmileyFaceEmoji(int a, int b, int c) {
		super(a, b, c);
	}
	
	public void draw() {
		super.draw();
		
		//this arc draws the smiley face
		DUDraw.arc(x, y-5, 10, 180, 0);
	}

}
