import java.util.List;

import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

public class ForestGame implements DrawListener {

	// fix the colors. - canvas - jack - tree
	// fix the designs. - same as above

	// need to figure out how to interface the point algorithm and the actual
	// movement of jack

	private double size;
	private int[][] grid;
	private Draw canvas;
	private Tree[][] fGrid;
	Jack j;
	PathFinding.Point gridLoc;
	List<PathFinding.Point> path;

	// tree inner class
	public class Tree {

		private int x;
		private int y;
		private int health;

		public Tree(int x, int y) {
			this.x = x;
			this.y = y;
			health = 10;
		}

		public void draw() {

			canvas.setPenColor(Draw.GREEN);

			canvas.filledCircle(x * size + (size / 2), y * size + (size / 2), size / 2.2);
		}
	}

	// lumberjack inner class
	public class Jack {

		private double x;
		private double y;
		private double speed;
		private String name;
		private boolean mission;

		public Jack(int x, int y, String name) {
			this.name = name;
			gridLoc = new PathFinding.Point(x, y, null);

			this.x = gridLoc.x;
			this.y = gridLoc.y;
			mission = false;
			speed = size / (size * 3);

		}

		public void draw() {
			canvas.filledCircle(x * size + (size / 2), y * size + (size / 2), size / 3.4);
			canvas.text(x, y - size / 2.4, name);
		}

		public void move() {
			if (mission == true) {

				int tarX = path.get(0).y;
				int tarY = path.get(0).x;

				// System.out.println("target x and y" + tarX + ", " + tarY);

				//handles if the direction we're moving is on the x axis
				if (tarX != j.x) {
					
					//handles if we're moving right on the x axis
					if (j.x < tarX) {
						if ((j.x + speed) > tarX) {
							j.x += tarX - j.x;
						} else {
							j.x += speed;
						}
					}
					
					//handles if we're moving left on the x axis
					else if (j.x > tarX) {
						
						//checks to see if speed will overshoot the location we need to get to
						if ((j.x - speed) < tarX) {
							
							if (path.get(1).x < j.x) {
								j.x -= speed;
								path.remove(0);
							}
							j.x += tarX - j.x;
						} else { // if we aren't going to overshoot our location, then 
							j.x -= speed;
						}

					}

				} else if (tarY != j.y) {
					if (j.y < tarY) {
						if ((j.y + speed) > tarY) {
							j.y += tarY - j.y;
						} else {
							j.y += speed;
						}
					}

					else if (j.y > tarY) {
						if ((j.y - speed) < tarY) {
							j.y += tarY - j.y;
						} else {
							j.y -= speed;
						}

					}

				} else if (j.y == tarY && j.x == tarX) {

					if ((path.size() - 1) == 0) {
						mission = false;

						gridLoc.x = tarX;
						gridLoc.y = tarY;
					}

					path.remove(0);
				}

				// from here do the y dimension
				// System.out.println("new x is: " + x + "\nnew y is: " + y);
			}

		}

	}

	public ForestGame(int height, int width, int size, double chance) {
		grid = new int[height][width];
		fGrid = new Tree[height][width];
		canvas = new Draw();
		this.size = size;
		j = new Jack(0, 0, "Carl");

		// sets up the canvas
		canvas.setCanvasSize(height * size, width * size);
		canvas.setXscale(0, height * size);
		canvas.setYscale(0, width * size);
		canvas.clear(Draw.YELLOW);
		canvas.enableDoubleBuffering();
		canvas.addListener(this);

		// this loops sets which of the tiles are going to be trees
		for (int i = 0; i < fGrid.length; i++) {
			for (int q = 0; q < fGrid[0].length; q++) {
				if (Math.random() < chance) {
					fGrid[i][q] = new Tree(i, q);
				}
			}
		}

		// this line of code makes sure that there are no trees
		// spawned on top of the player

		fGrid[0][0] = null;

	}

	public void draw() {
		j.draw();
		for (int i = 0; i < grid.length; i++) {
			for (int q = 0; q < grid[0].length; q++) {
				if (fGrid[i][q] != null) {
					fGrid[i][q].draw();
				}

				double x = i * size + (size / 2);
				double y = q * size + (size / 2);
				canvas.setPenColor(Draw.BLACK);
				canvas.square(x, y, size * .5);

			}
		}
	}

	@Override
	public void keyPressed(int arg0) {
		if (arg0 == 32) {
			j.speed = 3 * size / (size * 3);
		}

	}

	@Override
	public void keyReleased(int arg0) {
		if (arg0 == 32) {
			j.speed = (size / (size * 3));
		}

	}

	@Override
	public void keyTyped(char arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(double x, double y) {

		int[][] pGrid = new int[fGrid.length][fGrid[0].length];

		for (int i = 0; i < grid.length; i++) {
			for (int q = 0; q < grid[0].length; q++) {
				if (fGrid[i][q] == null) {
					pGrid[i][q] = 0;
				} else {
					pGrid[i][q] = 1;
				}
			}
		}

		PathFinding.Point start = new PathFinding.Point(gridLoc.y, gridLoc.x, null);
		PathFinding.Point end = new PathFinding.Point((int) (y / size), (int) (x / size), null);
		path = PathFinding.FindPath(pGrid, start, end);

		if (path != null) {
			for (PathFinding.Point point : path) {
				// System.out.println(point);
				System.out.println(point.y + ", " + point.x);
				j.mission = true;
			}
		} else if (path == null) {
			System.out.println("No path found");
		}
		System.out.println("Job done\n");

	}

	@Override
	public void mouseDragged(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		draw();
		j.move();

		canvas.show();
		canvas.pause(1);
		canvas.clear(Draw.YELLOW);

	}

}
