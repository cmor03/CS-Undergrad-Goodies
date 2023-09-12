package MorrisLab11;

import java.awt.Color;
import java.io.IOException;

import edu.du.dudraw.DUDraw;

public class Driver {

	public static void main(String[] args) {
		DUDraw.enableDoubleBuffering();
		
		Color[][] color1 = BMPIO.readBMPFile("Alcatraz.bmp");
		
		DUDraw.setCanvasSize(color1.length,color1[0].length);
		DUDraw.setXscale(0, color1.length);
		DUDraw.setYscale(0, color1[0].length);
		
		for (int i = 0; i < color1.length; i++) {					 
			 for (int j = 0; j < color1[0].length; j++) {
				 DUDraw.setPenColor(color1[i][j]);
				 DUDraw.filledSquare(i,j,1);
				 
			 }
		 }
		
		DUDraw.show();
		
		
		
	}

}
