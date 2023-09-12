package edu.du.cs.cmorris.assignment2;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import edu.du.dudraw.DUDraw;
import edu.du.dudraw.Draw;

public class QuadTree {

	private QTNode root;
	private List<Planet> allPlanets = new ArrayList<Planet>();

	public class QTNode {
		// should contain all the node information

		// should be a linked implementation of either a linked list
		// or BST/AVL trees

		private Rectangle spatialRange;
		private List<Planet> planets;
		private boolean leaf;
		// if true -> leaf node (meaning it has no children)
		// if false -> non-leaf node (meaning it has kids)

		private QTNode parent;

		// this should be in arraylist of qtnode children
		// empty, or has 4 elements
		private QTNode child1;
		private QTNode child2;
		private QTNode child3;
		private QTNode child4;

		private int level;

		public QTNode(QTNode parent, Rectangle sRange) {
			planets = new ArrayList<Planet>();
			this.parent = parent;
			spatialRange = sRange;
			leaf = true;

			if (this.parent == null) {
				// print("parent is null");
				level = 0;
			} else {

				level = this.parent.level + 1;
				// print("level is: " + level);
			}

			// printSRange(this);

			child1 = null;
			child2 = null;
			child3 = null;
			child4 = null;

		}

		public void addPlanet(Planet p) {
			if (this.spatialRange.contains(p.x, p.y)) {
				if (planets.size() >= ppL && leaf == true) {
					// print("creating children");
					leaf = false;
					int newLevel = level + 1;

					child1 = new QTNode(this, rectangleCalculator(spatialRange, 1, newLevel));
					child2 = new QTNode(this, rectangleCalculator(spatialRange, 2, newLevel));
					child3 = new QTNode(this, rectangleCalculator(spatialRange, 3, newLevel));
					child4 = new QTNode(this, rectangleCalculator(spatialRange, 4, newLevel));

					balanceKids(planets);

				} else if (leaf == false) {
					this.findCorrespondingChild(p);

				} else if (leaf == true) {
					planets.add(p);
				}

				// the issue right now is that the children are not being properly given their
				// children
				// addPlanet is being called with node parameter, when it should be called by
				// the node,
				// then handed off to the lowest level, then addPlanet can be called
			}

		}

		public void balanceKids(List<Planet> p) {
			for (int i = 0; i < planets.size(); i++) {
				if (child2.spatialRange.contains(p.get(i).x, p.get(i).y)) {
					child1.addPlanet(p.get(i));
					p.remove(i);
				}
			}
			for (int i = 0; i < planets.size(); i++) {
				if (child2.spatialRange.contains(p.get(i).x, p.get(i).y)) {
					child2.addPlanet(p.get(i));
					p.remove(i);
				}
			}
			for (int i = 0; i < planets.size(); i++) {
				if (child3.spatialRange.contains(p.get(i).x, p.get(i).y)) {
					child3.addPlanet(p.get(i));
					p.remove(i);
				}
			}
			for (int i = 0; i < planets.size(); i++) {
				if (child4.spatialRange.contains(p.get(i).x, p.get(i).y)) {
					child4.addPlanet(p.get(i));
					p.remove(i);
				}

			}
			if (p.size() > 0) {

			}

		}

		public void findCorrespondingChild(Planet p) {
			int s = (int) child1.spatialRange.getHeight();
			if (child1.spatialRange.contains(p.x, p.y)) {
				child1.addPlanet(p);
			} else if (child2.spatialRange.contains(p.x, p.y)) {
				child2.addPlanet(p);
			} else if (child3.spatialRange.contains(p.x, p.y)) {
				child3.addPlanet(p);
			} else if (child4.spatialRange.contains(p.x, p.y)) {
				child4.addPlanet(p);
			} else {
			}
		}

	}

	private int ppL;
	private int size;

	public QuadTree(int size, int planetsPerLeaf) {
		this.size = size;
		ppL = planetsPerLeaf;
		// should control starting canvas size
		root = new QTNode(null, new Rectangle(0, size, size, size));

	}

	public void draw(Draw panel) {

		panel.setPenRadius(.5);
		panel.setPenColor(DUDraw.BLACK);
		drawGrids(root, panel);
	}

	// draws the planets
	public void drawPlanets(Draw panel) {

		for (Planet p : allPlanets) {
			p.draw(panel);
		}
		// the same comments from the draw method in planet apply here

	}
	
	public void drawPlanets(Draw panel, List<Planet> p) {
		for (Planet plan : p) {
			plan.draw(panel);
		}
	}
	

	// recursively draws the kids of every single node it sees
	private void drawGrids(QTNode node, Draw panel) {

		if (node != null) {

			panel.square(node.spatialRange.getCenterX(), node.spatialRange.getCenterY(),
					.5 * node.spatialRange.getWidth());
			// panel.circle(node.spatialRange.getX(), node.spatialRange.getY(), 20);
			if (node.leaf == false) {
				// print("children exist. attempting to draw, they belong to level:" +
				// node.level);

				// this would be better as an array
				drawGrids(node.child1, panel);
				drawGrids(node.child2, panel);
				drawGrids(node.child3, panel);
				drawGrids(node.child4, panel);
			}

		} else {
		}
	}

	public QTNode getRoot() {
		return root;
	}

	public void addPlanet(Planet p) {

		allPlanets.add(p);

		// first figure out where in the tree the planet belongs
		// then --> add planet to that leaf node's list of planets

		// then, check if that node is over the ppL, and split the node
		// if there are too many

		// NOTE: this process may be recursive, as planets could end
		// up in only 1 of the 4 sub quads

		// QTNode class should have methods to help splitting
	}

	public List<Planet> findLocalPlanets(Rectangle r) {
		List<Planet> temp = new ArrayList<Planet>();
		
		for (Planet p : allPlanets) {
			if (r.contains(p.x,p.y)) {
				temp.add(p);
			}
		}
		
		return temp;

	}

	public static Rectangle rectangleCalculator(Rectangle r, int quadrant, int level) {

		// rectangle calculator theoretically works, all we need to do now is create
		// quadrants

		// probably don't need level, just half width and half height

		int x = (int) (r.getX());
		int y = (int) r.getY();
		int width = (int) (1000 / (Math.pow(2, level)));

		// algorithm for solving quadrant I
		if (quadrant == 1 || quadrant == 4) {
			x += width;
		}
		if (quadrant == 2 || quadrant == 3) {
			x = (int) (r.getX());
		}
		if (quadrant == 1 || quadrant == 2) {
			y += width;

		}
		if (quadrant == 3 || quadrant == 4) {

		}

		Rectangle temp = new Rectangle(x, y, width, width);
		return temp;

	}

}
