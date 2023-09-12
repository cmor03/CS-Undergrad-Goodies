package edu.du.morris.project2;
import edu.du.dudraw.DUDraw;

public class Driver {

	public static void main(String[] args) {
		DUDraw.enableDoubleBuffering();
		Simulator game1 = new Simulator(400,400);
		
		while (true) {
			
			//if statements that handle all of the different
			//possible commands the player could want
			if (DUDraw.isMousePressed()) {
				game1.placeElement((int)DUDraw.mouseX(), (int)DUDraw.mouseY());
			}
			if (DUDraw.isKeyPressed(83)){
				game1.switchMode("s");
			}
			if (DUDraw.isKeyPressed(70)){
				game1.switchMode("f");	
			}
			if(DUDraw.isKeyPressed(67)) {
				game1.newGame();
			}
			if (DUDraw.isKeyPressed(69)){
				game1.switchMode("e");
			}
			
			//updates the cells, and draws them again
			game1.update();
			game1.draw();			
		} 
	}
}
