package MorrisLab19;

import edu.du.dudraw.DUDraw;

public class Recursion {

	public static void drawCircles(double x, double y, double radius, int n) {
		if (n <= 0) {
			return;
		}
		DUDraw.circle(x, y, radius);

		drawCircles(x + radius, y, radius / 2, n - 1);
		drawCircles(x - radius, y, radius / 2, n - 1);
		drawCircles(x, y + radius, radius / 2, n - 1);
		drawCircles(x, y - radius, radius / 2, n - 1);
	}

	public static void drawTreeRecursive(int n, double x, double y, double length, double angle) {
		if (n <= 0) {
			return;
		}

		DUDraw.line(x, y, (x+length * Math.cos(angle)), (y+length *Math.sin(angle)));
		drawTreeRecursive(n-1, (x + length * Math.cos(angle)), (y + length * Math.sin(angle)), length/2, angle - Math.PI/4);
		drawTreeRecursive(n-1, (x + length * Math.cos(angle)), (y + length * Math.sin(angle)), length/2, angle + Math.PI/4);

	}

}
