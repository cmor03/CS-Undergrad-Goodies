import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;
import edu.du.dudraw.DUDraw;

public class driver2 {

	// this driver will is used to test runtimes of the different methods

	public static void main(String[] args) {
		System.out.println("QUICKHULL:");

		Random rand = new Random();

		ArrayList<Point> points = new ArrayList<>();

		int[] array = new int[]{10, 100, 500, 1000, 2000, 4000, 10000};

		for (int nums : array) {

			for (int i = 0; i < nums; i++) {
				int x = rand.nextInt(100);
				int y = rand.nextInt(100);
				points.add(new Point(x, y));
			}

			long startTime = System.currentTimeMillis();
			
			//driver1.bruteForce(points);
			
			qhull.quickHull(points);
			
			
			long endTime = System.currentTimeMillis();
			double time = (endTime - startTime);
			
			System.out.println(""+ nums + " item test took (ms): " + time );
		}

	}

}
