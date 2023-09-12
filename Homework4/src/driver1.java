import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import edu.du.dudraw.DUDraw;

// this driver should prove that it works

public class driver1 {

	// takes in 3 points and returns if they are on the same side of the line
	// created
	// by points p, and q
	static int orientation(Point p, Point q, Point r) {

		// equation from class that returns what side of the line its on
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
		if (val == 0)
			return 0;
		return (val > 0) ? 1 : 2;
	}

	public static ArrayList<Point> bruteForce(ArrayList<Point> points) {
		ArrayList<Point> convexHullPoints = new ArrayList<>();
		int n = points.size();
		int o = 0;
		boolean temp = false;
		for (Point pointp : points) {
			for (Point pointq : points) {
				temp = true;
				o = orientation(pointp, pointq, points.get(0));
				if (pointp.x == pointq.x && pointp.y == pointq.y) {
					temp = false;
				}
				for (int i = 1; i < n; i++) {
					int currOrientation = orientation(pointp, pointq, points.get(i));
					if (currOrientation != o && currOrientation != 0) {
						temp = false;
					}
				}
				if (temp == true) {
					convexHullPoints.add(pointp);
					convexHullPoints.add(pointq);
				}

			}
		}
		return convexHullPoints;
	}
	public static ArrayList<Point> divideAndConquer(ArrayList<Point> points) {
	    
	    Point lowestX = points.get(0);
	    Point highestX = points.get(0);
	    ArrayList<Point> convexHull = new ArrayList<Point>();
	    
	    
	    for (Point point : points) {
	      if (point.x < lowestX.x) {
	        lowestX = point;
	      }
	      if (point.x > highestX.x) {
	        highestX = point;
	      }
	    }
	    
	    convexHull.add(lowestX);
	    convexHull.add(highestX);
	    
	    ArrayList<Point> aboveLine = new ArrayList<Point>();
	    ArrayList<Point> belowLine = new ArrayList<Point>();
	    
	    double slope = (highestX.y - lowestX.y) / (highestX.x - lowestX.x);
	    double yIntercept = lowestX.y - slope * lowestX.x;
	    
	    for (Point point : points) {
	      double y = slope * point.x + yIntercept;
	      if (point.y > y) {
	        aboveLine.add(point);
	      } else if (point.y < y) {
	        belowLine.add(point);
	      }
	    }
	    
	    // now there should be two recursive method calls 
	    // compute the distance from the line
	    
		
		// return statement needs to be changed to the actual thing
		return points;
	}

	public static void main(String[] args) {

		// randomly generates 50 points
		Random rand = new Random();
		ArrayList<Point> points = new ArrayList<>();
		
		for (int i = 0; i < 5000; i++) {
			int x = rand.nextInt(100);
			int y = rand.nextInt(100);
			points.add(new Point(x, y));
		}

		ArrayList<Point> convexHullPoints = qhull.quickHull(points);

		
		// DUDraw makes points
		DUDraw.setCanvasSize(500, 500);
		DUDraw.setXscale(0, 100);
		DUDraw.setYscale(0, 100);
		DUDraw.setPenColor(DUDraw.BLACK);
		DUDraw.setPenRadius(5);

		// Draws them
		for (Point point : points) {

			DUDraw.point(point.x, point.y);
		}

		DUDraw.setPenColor(DUDraw.BLUE);
		for (Point point : convexHullPoints) {
			DUDraw.point(point.x, point.y);

		}

		DUDraw.show();
	}
}
