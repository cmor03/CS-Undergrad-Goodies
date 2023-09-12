package MorrisProject1;
import java.awt.Color;

import edu.du.dudraw.DUDraw;

public class FancyDrawingMethods {
	
	//vars update method usage
	private static int starWithFourPoints;
	private static int filledRegularNgon;
	private static int spiral;
	private static int starWithNPoints;
	
	// custom colors (fall themed)
	public static final Color FALL_BROWN = new Color(112, 49, 22);
	public static final Color SPOOKY_ORANGE = new Color(207, 79, 25);
	public static final Color HALLOWEEN_PURPLE = new Color(53, 27, 77);
	//private static Color FALL_BROWN = new Color(112, 49, 22);
	

	//prints the starWithFourPoints usages 
	public static void getStarWithFourPoints() {
		System.out.println("Number of Calls to starWithFourPoints: " +starWithFourPoints);
	}

	//prints the filledRegularNgon usages
	public static void getfilledRegularNgon() {
		System.out.println("Number of Calls to filledRegularNgon: " +filledRegularNgon);
	}


	//prints the spiral usages
	public static void getSpiral() {
		System.out.println("Number of Calls to spiral: " +spiral);
	}

	
	//prints the starWithNPoints usages
	public static void getStarWithNPoints() {
		System.out.println("Number of Calls to starWithNPoints: " +starWithNPoints);
	}



	public static void starWithFourPoints(double centerX, double centerY, double radius) {
		starWithFourPoints++;
		double[] x = {(centerX - radius), (centerX - .25*radius), centerX, (centerX+.25*radius), centerX +radius, centerX+.25*radius, centerX, centerX-.25*radius};
		double[] y = {centerY, (centerY+.25*radius), (centerY+radius), centerY+.25*radius, centerY, centerY-.25*radius, centerY-radius, centerY-.25*radius};
		DUDraw.filledPolygon(x, y);
		
		}
	
	public static void filledRegularNgon(double centerX, double centerY, double radius, int n) {
		filledRegularNgon++;
		double[] x = new double[n];
		double[] y = new double[n];
		
		double turn = ((360.0/n)*Math.PI)/180;
		
		for (int i = 0; i < n; i++) {
			x[i] = radius*Math.sin(turn*i)+centerX;
			y[i] = radius*Math.cos(turn*i)+centerY;
		}
		
		DUDraw.filledPolygon(x, y);
	}
	
	public static void spiral(double centerX, double centerY, double maxRadius, int numTurns, int numSegments) {
		spiral++;
			double x1 = centerX;
			double y1 = centerY;
			double x2;
			double y2;
			
			double turn = 2.0 * Math.PI * numTurns / numSegments;
		
			for (int i = 0; i < numSegments; i++) {
				x2 = ((0.0+i)/numSegments)*maxRadius*Math.sin(turn*i) + centerX;
				y2 = ((0.0+i)/numSegments)*maxRadius*Math.cos(turn*i) + centerY;
				DUDraw.line(x1, y1, x2, y2);
				x1 = x2;
				y1 = y2;
			}
			
	}
	
	public static void starWithNPoints(double centerX, double centerY, double radius, int n) {
		starWithNPoints++;
		double[] x = new double[n*2];
		double[] y = new double[n*2];
		double radians;
		double tempR;
		
		for (int i = 0; i < n*2; i++) {
			radians = i*2.0 * Math.PI/n*2;
			tempR = radius;
			if (i%2 == 1) {
				tempR = radius*.25;
			}
			
			x[i]= centerX + Math.cos(radians)*tempR;
			y[i]= centerY + Math.sin(radians)*tempR;
			
		}
		
		DUDraw.filledPolygon(x, y);
	}

		
		
}
