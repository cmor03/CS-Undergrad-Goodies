package edu.du.cs.cmorris.linkedlist;

public class Tester {

	public static void main(String[] args) {

		// ListIf<String> l = new LList<String>();

		ListIf<String> l = new LList<String>();

		System.out.println(l);

		l.add("a"); // add end
		l.add("b");
		l.add("c");
		l.add("d");
		System.out.println(l);

		l.add(2, "e"); // add middle
		System.out.println(l);

		l.add(0, "f"); // add begin
		System.out.println(l);

		//////////////////////////////////// ADD WORKS

		l.set(3, "g"); // set
		System.out.println(l);

		System.out.println(l.size()); // size

		System.out.println(l.contains("b")); // contains
		System.out.println(l.contains("e"));

		System.out.println(l.indexOf("b")); // indexOf
		System.out.println(l.indexOf("e"));

		//////////////////////////////////// THESE ALL WORK

		l.remove(2); // index remove from middle
		System.out.println(l);

		l.remove(0); // index remove from beginning
		System.out.println(l);

		l.remove(3); // index remove from end
		System.out.println(l);

		// add 3 more to make list longer again
		l.add("x");
		l.add("y");
		l.add("z");

		System.out.println(l);

		l.remove("x"); // remove middle
		System.out.println(l);

		l.remove("a"); // remove first
		System.out.println(l);

		l.remove("z"); // remove last
		System.out.println(l);
	}

}
