package MorrisProject1;
import java.awt.Color;

import edu.du.dudraw.DUDraw;

@SuppressWarnings("unused")
public class Driver {

	public static void main(String[] args) {
		
		DUDraw.clear(DUDraw.PINK);
		DUDraw.setPenRadius(1.1);
		
		DUDraw.setPenColor(FancyDrawingMethods.FALL_BROWN);
		
		FancyDrawingMethods.starWithFourPoints(.2,.7,.1);
		
		FancyDrawingMethods.filledRegularNgon(.2, .2, .1, 90);
		
		DUDraw.setPenColor(FancyDrawingMethods.HALLOWEEN_PURPLE);
		FancyDrawingMethods.starWithNPoints(.35,.8,.15,100);
		FancyDrawingMethods.spiral(.6, .6, .3, 20, 900);

		DUDraw.setPenColor(FancyDrawingMethods.SPOOKY_ORANGE);
		FancyDrawingMethods.spiral(.6,.6,.1,20,90);
		FancyDrawingMethods.starWithNPoints(.5,.2,.3,100);
		FancyDrawingMethods.starWithFourPoints(.8,.2,.2);
		FancyDrawingMethods.filledRegularNgon(.2, .45, .1, 90);
		
		
		
		FancyDrawingMethods.getfilledRegularNgon();
		FancyDrawingMethods.getSpiral();
		FancyDrawingMethods.getStarWithFourPoints();
		FancyDrawingMethods.getStarWithNPoints();
		DUDraw.setPenColor(FancyDrawingMethods.HALLOWEEN_PURPLE);
		FancyDrawingMethods.spiral(.5,.2,.1,20,90);
		
	
	}
}
