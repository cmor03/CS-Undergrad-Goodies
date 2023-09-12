import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import edu.du.dudraw.DUDraw;

public class qhull {

	public static ArrayList<Point> quickHull(ArrayList<Point> pointSet) {
		ArrayList<Point> convexHull = new ArrayList<Point>();
		if (pointSet.size() < 3) {
			return pointSet;
		}

		Point minPoint = pointSet.get(0), maxPoint = pointSet.get(0);
		for (int i = 0; i < pointSet.size(); i++) {
			if (pointSet.get(i).x < minPoint.x) {
				minPoint = pointSet.get(i);
			}
			if (pointSet.get(i).x > maxPoint.x) {
				maxPoint = pointSet.get(i);
			}
		}

		// now we add them to the hull, and remove them from the pointset

		convexHull.add(maxPoint);
		convexHull.add(minPoint);

		pointSet.remove(maxPoint);
		pointSet.remove(minPoint);

		// now we need to create our hulls

		ArrayList<Point> upperHull = new ArrayList<Point>();
		ArrayList<Point> lowerHull = new ArrayList<Point>();

		// first step is to calculate all the points that are above and below the line
		// created
		// by our max and min x points

		for (int i = 0; i < pointSet.size(); i++) {
			Point p = pointSet.get(i);
			int loc = huller(maxPoint, minPoint, p);
			if (loc == -1) {
				upperHull.add(p);
			} else if (loc == 1) {
				lowerHull.add(p);
			}
			// now we need to use the dot product as discussed in class to figure out if it
			// is above, or below the line.
		}

		// now we need to recursively call divide
		computeHull(minPoint, maxPoint, upperHull, convexHull);
		computeHull(maxPoint, minPoint, lowerHull, convexHull);

		return convexHull;

	}

	private static void computeHull(Point minPoint, Point maxPoint, ArrayList<Point> halfHull,
			ArrayList<Point> convexHull) {

		// cases where we need to exit the div and conq
		if (halfHull.size() == 0) {
			return;
		}
		if (halfHull.size() == 1) {
			convexHull.add(halfHull.get(0));
			halfHull.remove(0);
			return;
		}

		int distance = 0;
		int farPoint = 0;
		for (int i = 0; i < halfHull.size(); i++) {

			if (distance(minPoint, maxPoint, halfHull.get(i)) > distance) {
				farPoint = i;
				distance = distance(minPoint, maxPoint, halfHull.get(i));
			}
		}

		Point Q = halfHull.get(farPoint);
		halfHull.remove(farPoint);
		convexHull.add(Q);

		ArrayList<Point> AQ = new ArrayList<Point>();
		ArrayList<Point> QB = new ArrayList<Point>();
		for (int i = 0; i < halfHull.size(); i++) {
			Point p = halfHull.get(i);
			int loc = huller(minPoint, Q, p);
			if (loc >= 1) {
				AQ.add(p);
			}

			// now we need to use the dot product as discussed in class to figure out if it
			// is above, or below the line.
		}
		for (int i = 0; i < halfHull.size(); i++) {
			Point p = halfHull.get(i);
			int loc = huller(Q, maxPoint, p);
			if (loc >= 0) {
				QB.add(p);
			}
			// now we need to use the dot product as discussed in class to figure out if it
			// is above, or below the line.
		}
		computeHull(minPoint, Q, AQ, convexHull);
		computeHull(Q, maxPoint, QB, convexHull);

	}

	// we're going to need one more method that computes
	// the distance from the line, not just above or below
    public static int distance(Point A, Point B, Point C)
    {
        int ABx = B.x - A.x;
        int ABy = B.y - A.y;
        int num = ABx * (A.y - C.y) - ABy * (A.x - C.x);
        if (num < 0)
            num = -num;
        return num;
    }
	
	//this one computes dot product
    public static int huller(Point A, Point B, Point P)
    {
        int cp1 = (B.x - A.x) * (P.y - A.y) - (B.y - A.y) * (P.x - A.x);
        if (cp1 > 0) {
            return 1;
        } else if (cp1 == 0) {
            return 0;
        } else {
            return -1;
        }
    }

	public static void main(String[] args) {

		// randomly generates 50 points
		Random rand = new Random();
		ArrayList<Point> points = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			int x = rand.nextInt(100);
			int y = rand.nextInt(100);
			points.add(new Point(x, y));
		}

		ArrayList<Point> convexHullPoints = quickHull(points);

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

		int tag = 0;

		for (Point point : convexHullPoints) {
			if (tag <= 2) {
				DUDraw.setPenColor(DUDraw.ORANGE);
				tag++;
			}

			if (tag > 2) {
				DUDraw.setPenColor(DUDraw.BLUE);
			}

			DUDraw.point(point.x, point.y);

		}

		DUDraw.show();

	}

}
