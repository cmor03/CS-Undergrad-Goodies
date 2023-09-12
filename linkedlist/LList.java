package edu.du.cs.cmorris.linkedlist;

public class LList<T> implements ListIf<T> {

	// Nested helper class
	private class Node {
		// These are private, but LList can see them since Node is a nested class
		private T element;
		private Node next;

		public Node(T o) {
			element = o;
			next = null;
		}
	}

	// LList's instance variables
	private Node first;
	private int size;

	// Default constructor
	public LList() {
		first = null; // empty list
		size = 0;
	}

	// Added to the end
	public void add(T o) {
		add(size, o);
		// the other add we call will increment the size
	}

	// Added to the middle (or start)
	public void add(int index, T o) {

		Node nn = new Node(o);

		// Special case for adding to start
		if (index == 0) {
			nn.next = first;
			first = nn;

		} else { // works for middle and end cases

			// Find the node before index
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			nn.next = n.next;
			n.next = nn;
		}

		size++;
	}

	// Get
	public T get(int index) {

		Node n = first;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.element;
	}

	// Remove
	public T remove(int index) {
		T result = null;
		
		// Special case for removal from beginning
		if (index == 0) {
			result = first.element;
			first = first.next;

		} else { // works for middle and end cases

			// Find the node before index
			Node n = first;
			for (int i = 0; i < index - 1; i++) {
				n = n.next;
			}
			result = n.next.element;
			n.next = n.next.next;
		}

		size--;
		
		return result;
	}
	
	public void set(int index, T o) {

		Node nn = new Node(o);

		Node n = first;
		for (int i = 0; i < index - 1; i++) {
			n = n.next;
			
		}
		nn.next = n.next;
		n.next = nn;
		
		
	}

	@Override
	public boolean remove(T o) {
		if (contains(o) == true) {
			remove(indexOf(o));
		}
		//excessive searching in this implementation
		return false;	
		
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean contains(T o) {

		for (int i = 0; i < size; i++) {
			if (get(i).equals(o)) {
				return true;

			}
		}

		return false;
	}

	@Override
	public int indexOf(T o) {
		for (int i = 0; i < size ; i++) {
			if (get(i).equals(o)) {
				return i;

			}
		}
		return -1;
	}

	public String toString() {
		String str = "[";

		if (size > 0) {
			for (int i = 0; i < size - 1; i++) {
				str += get(i) + ", ";
			}

			str += get(size - 1) + "]";

			return str;
		}

		return "[]";

	}

}
