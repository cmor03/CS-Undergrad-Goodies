package edu.du.cs.cmorris.assignment2;

import edu.du.dudraw.DUDraw;
import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpaceShipSimulation implements DrawListener {
	private Draw map;
	private Draw playerView;
	private QuadTree tree;
	private Ship ship;

	public static void main(String[] args) {
		System.out.println("running simulation...");
		SpaceShipSimulation test = new SpaceShipSimulation();

	}

	public SpaceShipSimulation() {

		// setup for the first window, the simulator as a whole
		map = new Draw();
		map.setCanvasSize(500, 500);
		map.enableDoubleBuffering();
		map.setXscale(-20, 1020);
		map.setYscale(980, 2020);
		map.addListener(this);
		tree = new QuadTree(1000, 6);

		// setup for the second simulator
		playerView = new Draw();
		playerView.setCanvasSize(500, 500);
		playerView.enableDoubleBuffering();
		playerView.setXscale(0, 100);
		playerView.setYscale(980, 1080);

		// setup for the ship
		ship = new Ship(50, 1030);

		addCluster(100);
	}

	@Override
	public void keyPressed(int key) {
		if (key == 87) {
			ship.y += 3;
		}
		if (key == 65) {
			ship.x -= 3;

		}
		if (key == 83) {
			ship.y -= 3;

		}
		if (key == 68) {
			ship.x += 3;
		}
		if (key == 81) {
			System.exit(0);
		}

		playerView.setXscale(ship.x - 50, 50 + ship.x);
		playerView.setYscale(ship.y - 50, ship.y + 50);

	}

	@Override
	public void keyReleased(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(char arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(double arg0, double arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(double arg0, double arg1) {
		Planet temp = new Planet(arg0, arg1);
		tree.addPlanet(temp);
		tree.getRoot().addPlanet(temp);
	}

	@Override
	public void mouseReleased(double arg0, double arg1) {

	}

	// adds a cluster of 100 for testing purposes
	public void addCluster(int num) {
		Point[] clusters = new Point[5];

		clusters[0] = new Point(150, 271, 1789);
		clusters[1] = new Point(150, 587, 1789);
		clusters[2] = new Point(150, 252, 1427);
		clusters[3] = new Point(150, 787, 1169);
		clusters[4] = new Point(150, 585, 1437);

		for (Point p : clusters) {
			for (int i = 0; i <= 170; i++) {
				double[] temp = p.randPoint();

				tree.addPlanet(new Planet(temp[0], temp[1]));
				tree.getRoot().addPlanet(new Planet(temp[0], temp[1]));
			}
		}

	}

//	class Point{
//		double x;
//		double y;
//		
//		public Point(double x, double y) {
//			this.x = x;
//			this.y = y;
//		}
//		
//		public double getX() {
//			return x;
//		}
//		
//		public double getY() {
//			return y;
//		}
//		
//	
//	}

	class Point {
		double RAD, XC, YC;

		public Point(double radius, double x_center, double y_center) {
			RAD = radius;
			XC = x_center;
			YC = y_center;
		}

		public double[] randPoint() {
			double ang = Math.random() * 2 * Math.PI, hyp = Math.sqrt(Math.random()) * RAD, adj = Math.cos(ang) * hyp,
					opp = Math.sin(ang) * hyp;
			return new double[] { XC + adj, YC + opp };
		}
	}

	@Override
	public void update() {

		// draws and updates the map frame
		map.setPenColor(DUDraw.BLUE);
		tree.drawPlanets(map);
		tree.draw(map);

		ship.drawRange(map);

		// draws and updates the player view

		playerView.setPenColor(DUDraw.BLUE);
		tree.drawPlanets(playerView, tree.findLocalPlanets(ship.getR()));

		DUDraw.setPenColor(DUDraw.RED);

		// now, we go back and check if any of the localPlanets are actually touching
		// the ship

		List<Planet> temp = tree.findLocalPlanets(ship.getR());
		List<Planet> temp2 = new ArrayList<Planet>();
		for (Planet p : temp) {
			if ((Math.sqrt(Math.pow(p.x - ship.x, 2) + Math.pow((p.y - ship.y), 2)) < 14 + p.radius)) {
				temp2.add(p);

			}
		}

		if (temp2.size() > 0) {
			map.setPenColor(DUDraw.YELLOW);
			playerView.setPenColor(DUDraw.YELLOW);
		} else {
			map.setPenColor(DUDraw.RED);
			playerView.setPenColor(DUDraw.RED);
		}
		ship.draw(map);
		ship.draw(playerView);

		map.setPenColor(DUDraw.YELLOW);
		tree.drawPlanets(map, temp2);
		playerView.setPenColor(DUDraw.YELLOW);
		tree.drawPlanets(playerView, temp2);

		// if they are, we redraw them as yellow

		// the show, pause, and clear for all of them
		map.show();
		map.pause(1);
		map.clear();
		playerView.show();
		playerView.pause(1);
		playerView.clear();

	}

}
