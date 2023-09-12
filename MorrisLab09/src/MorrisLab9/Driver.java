package MorrisLab9;
import edu.du.dudraw.*;

public class Driver {

	public static void main(String[] args) {
		DUDraw.setCanvasSize();
		DUDraw.setXscale(0, 1);
		DUDraw.setYscale(0, 1);
		
		MovingCircle[] arr1 = new MovingCircle[6];
		arr1[0]	= new NormalCircle(.02);
		arr1[1] = new NormalCircle(.03);
		arr1[2] = new SpeedyCircle(.03);
		arr1[3] = new SpeedyCircle(.02);
		arr1[4] = new WobblyCircle(.03);
		arr1[5] = new WobblyCircle(0.03);
		int x = 0;
		DUDraw.enableDoubleBuffering();
		
		//animation loop
		for (;;) {
			
			for (MovingCircle n : arr1) {
				n.draw();
				n.move();
				System.out.println(n);
			}
			
			
			DUDraw.show();
			DUDraw.pause(20);
			DUDraw.clear();
			
			System.out.println(x);
			x +=1;
		}
		
		
		

	}

}
