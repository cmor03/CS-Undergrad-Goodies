package edu.du.cs.cmorris.assignment2;

import edu.du.dudraw.DUDraw;
import edu.du.dudraw.Draw;
import edu.du.dudraw.DrawListener;
import java.util.Random;

// the two views in the space ship tester and the planets, change the view of the quadtree
// ask your quadtree to give all planets withing a certain rectangle, map window is just quadtree draw
// itself 

// just set the window to the same pixels but different square

public class QuadTreeTester implements DrawListener {
	private Draw canvas;
	private QuadTree tree;

	public static void main(String[] args) {
		System.out.println("running quadtree tester...");
		QuadTreeTester test = new QuadTreeTester();

	}

	public QuadTreeTester() {

		canvas = new Draw();
		canvas.setCanvasSize(500, 500);
		canvas.enableDoubleBuffering();
		canvas.setXscale(-20, 1020);
		canvas.setYscale(980, 2020);
		canvas.addListener(this);
		tree = new QuadTree(1000, 6);

	}

	@Override
	public void keyPressed(int arg0) {
		// TODO Auto-generated method stub

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
		System.out.println("click detected at: " + arg0 + ", " + arg1);
		Planet temp = new Planet(arg0, arg1);
		tree.addPlanet(temp);
		tree.getRoot().addPlanet(temp);
	}

	@Override
	public void mouseReleased(double arg0, double arg1) {

	}

	@Override
	public void update() {
		canvas.setPenColor(DUDraw.BLUE);
		tree.drawPlanets(canvas);
		tree.draw(canvas);
		// tree.gridTest(canvas);
		canvas.show();
		canvas.pause(1);
		canvas.clear();

	}

}
