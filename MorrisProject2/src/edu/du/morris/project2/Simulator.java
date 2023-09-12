package edu.du.morris.project2;

import java.awt.Color;
import edu.du.dudraw.*;
/* Author: Colton Morris
 * Date: v.1 October 17th 2021
 * Purpose: The purpose of this program is to create a sand
 * simulation where you can draw sand and it will fall like gravity
 * For: COMP 1672 PROF: Andrew Hannum
 */

public class Simulator {

	// instance variables

	// enumerable
	private enum Mode {
		SAND, FLOOR, ERASE
	};

	// Element used to represent what each array cell is set to
	private enum Element {
		SAND, FLOOR, EMPTY
	};

	// width and height of canvas
	private int width;
	private int height;

	// declares a grid of Elements
	private Element[][] grid;

	// sets the starting mode to floor drawing
	private Mode mode = Mode.FLOOR;

	// constructor used to setup game
	public Simulator(int w, int h) {
		DUDraw.setCanvasSize(w, h);

		// creates a canvas with the desired width and height
		grid = new Element[w][h];

		// sets each item in the 2d array to empty
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				grid[i][j] = Element.EMPTY;
			}
		}

		// sets the X and y scale
		DUDraw.setXscale(0, w);
		DUDraw.setYscale(0, h);

		// initializes width and height for use in later methods
		width = w;
		height = h;

		// creates a floor layer so that sand wont fall off map
		for (int j = 0; j < h; j++) {
			grid[j][0] = Element.FLOOR;
		}
	}

	// switches between sand and floor mode
	public void switchMode(String inputString) {

		// sand = s
		if (inputString.equals("s")) {
			mode = Mode.SAND;

		}
		// floor = f
		if (inputString.equals("f")) {
			mode = Mode.FLOOR;
		}

		if (inputString.equals("e")) {
			mode = Mode.ERASE;
		}
	}

	// returns the mode that the game is in
	// not used, but criteria says to make it
	public Mode getMode() {
		return mode;
	}

	// changes the empty cells in the 2d array to either floor or sand
	public void placeElement(int row, int col) {

		// i used try and catch because if the pointer was held
		// down after it left the canvas, it would cause an error

		if (mode == Mode.FLOOR) {
			try {

				// this makes the floor thick like a line
				for (int i = row - 3; i < row + 3; i++) {
					for (int j = col - 3; j < col + 3; j++) {
						grid[i][j] = Element.FLOOR;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// does nothing except for make the program not crash
			}
		} else if (mode == Mode.SAND) {
			try {

				// makes the sand look more like a splash zone
				// rather than a marker
				for (int i = row - 9; i < row + 9; i++) {
					for (int j = col - 9; j < col + 9; j++) {

						// line 105 decides what cells in the splash zone
						// actually get turned to sand
						if (Math.random() < 0.001) {
							grid[i][j] = Element.SAND;
						}
					}
				}

			} catch (ArrayIndexOutOfBoundsException e) {
				// does nothing except for make the program not crash
			}

		}

		else if (mode == Mode.ERASE) {
			try {

				// this makes the floor thick like a line
				for (int i = row - 5; i < row + 5; i++) {
					for (int j = col - 5; j < col + 5; j++) {
						grid[i][j] = Element.EMPTY;
					}
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				// does nothing except for make the program not crash
			}

		}
	}

	// update simulates the gravity
	public void update() {

		// loops through all cells starting at the top and going down
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

				// if the cell is sand,
				if (grid[i][j] == Element.SAND) {

					// and there is nothing below it
					if (grid[i][j - 1] == Element.EMPTY) {

						// drop
						grid[i][j] = Element.EMPTY;
						grid[i][j - 1] = Element.SAND;
					}

					// delete from here
					else {
						try {
							if (grid[i + 2][j - 1] == Element.EMPTY) {
								grid[i][j] = Element.EMPTY;
								grid[i + 2][j - 1] = Element.SAND;

							}
							if (grid[i - 2][j - 1] == Element.EMPTY) {
								grid[i][j] = Element.EMPTY;
								grid[i - 2][j - 1] = Element.SAND;
							}

						} catch (ArrayIndexOutOfBoundsException e) {

						}

					}

					// to here

				}
			}
		}
	}

	// simply clears the game board so that the user
	// doesn't have to end the program to draw again
	public void newGame() {
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				grid[i][j] = Element.EMPTY;
			}
		}

		for (int j = 0; j < height; j++) {
			grid[j][0] = Element.FLOOR;
		}
	}

	// this is what actually makes the game "look" like a game
	public void draw() {

		String str;

		// loops through all cells in 2d array
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {

				// draws a red sand piece at index location
				if (grid[i][j].equals(Element.SAND)) {
					DUDraw.setPenColor(Color.RED);
					DUDraw.filledSquare(i, j, 1);
				}

				// draws a black floor square at index location
				else if (grid[i][j] == Element.FLOOR) {
					DUDraw.setPenColor(Color.BLACK);
					DUDraw.filledSquare(i, j, 1);
				}
			}
		}

		// just tells the user what mode they're in
		DUDraw.setPenColor(Color.BLUE);
		if (mode == Mode.SAND) {
			str = "SAND";
		} else if (mode == Mode.FLOOR) {
			str = "FLOOR";
		} else
			str = "ERASE";
		// calculates where to place the mode based on the width and height
		DUDraw.text(width * .15, height * .95, str);

		// standard DUDraw methods that make animation look good
		DUDraw.show();
		DUDraw.pause(1);
		DUDraw.clear();

	}

}
