
package MorrisLab01;
import java.time.LocalTime;
import edu.du.dudraw.DUDraw;

public class Clock {
	  public static void main(String[] args) {

		  //creates the canvas
		  DUDraw.setCanvasSize(300,300);
		  while(true) {
			  
			  DUDraw.setPenRadius(.75);
			  
			  //System.out.print(now.getSecond());
			  //clears the canvas each frame (allows for animation
			  DUDraw.clear(DUDraw.WHITE);
			  DUDraw.enableDoubleBuffering();
			  
		      DUDraw.setXscale(0, 300);
		      DUDraw.setYscale(0, 300);
		      
		      //Draws dots that indicate hour marks
		      //all of these were calculated by hand and inputted manually
		      //as oppose to including the math and having it be calculated each time the program opens
		      DUDraw.circle(150, 290, 3);
		      DUDraw.circle(10, 150, 3);
		      DUDraw.circle(150,10, 3);
		      DUDraw.circle(290, 150, 3);
		      
		      DUDraw.circle(219, 271, 3);
		      DUDraw.circle(270, 220, 3);
		      
		      DUDraw.circle(81, 271, 3);
		      DUDraw.circle(31, 219, 3);
		     
		      DUDraw.circle(81,29,3);
		      DUDraw.circle(31, 75, 3);
		      
		      DUDraw.circle(270, 80, 3);
		      DUDraw.circle(219, 29, 3);
		      
		      
		      //creates object time stamp that will be used for calculating hands
		      LocalTime now = LocalTime.now();
		      
		      //calculates second hand
		      //converts seconds to a ratio, then uses that ratio to turn it into degrees
		      double temp = (now.getSecond()/60.0)*360;
		      //converts degrees to radians
		      temp = (temp-90)*Math.PI/180;
		      //radians gets inputted into function as theta
		      double x = 120 * Math.cos(-temp) + 150;
		      double y = 120 * Math.sin(-temp) + 150;
		      	      
		      //draws second hand
		      DUDraw.setPenColor(DUDraw.RED);
		      DUDraw.line(150, 150, x, y);
		      
		      //calculates minute hand
		      temp = (now.getMinute()/60.0)*360;
		      temp = (temp-90)*Math.PI/180;
		      x = 140 * Math.cos(-temp) + 150;
		      y = 140 * Math.sin(-temp) + 150;
		      	      
		      //draws minute hand
		      DUDraw.setPenColor(DUDraw.BLACK);
		      DUDraw.line(150, 150, x, y);
		      
		      //calculates hour hand
		      temp = (now.getHour()/12.0)*360;
		      temp = (temp-90)*Math.PI/180;
		      x = 100 * Math.cos(-temp) + 150;
		      y = 100 * Math.sin(-temp) + 150;
		      	      
		      //draws hour hand
		      DUDraw.setPenColor(DUDraw.BLACK);
		      DUDraw.line(150, 150, x, y);

		      //resets clock and gets ready for next frame
		      DUDraw.show();
		      DUDraw.pause(1);

		      
		  }

	   }
}
