package edu.du.cs.cmorris.linkedlist;

public class DLList<T> implements ListIf<T> {

	private class Node {
		// These are private, but LList can see them since Node is a nested class
		private T element;
		private Node previous;
		private Node next;

		public Node(T o) {
			element = o;
			next = null;
			previous = null;
		}
	}

	// LList's instance variables
	private Node first;
	private Node last;
	private int size;

	// Default constructor
	public DLList() {
		first = null; // empty list
		last = null;
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
		
		if (first == null) {		
			first = nn;
			last = nn;
		}
		else if (index == 0) {	
			nn.next = first;
			first.previous = nn;
			first = nn;
		}
		else if (index == size) { 	
			nn.previous = last;
			last.next = nn;
			last = nn;
		}
		else {					
			Node temp = first;
			for (int i = 1; i < index; i++) {
				temp = temp.next;
			}
			nn.next = temp.next;
			temp.next = nn;
			nn.previous = temp;
			nn.next.previous = nn;
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

	// Remove ( not yet fixed for doubly)

	@Override
	public void set(int index, T o) {

		Node nn = new Node(o);

		Node n = first;
		for (int i = 0; i < index ; i++) {
			n = n.next;
		}
		n.element = nn.element;
	}

	@Override
	public boolean remove(T o) {
		if (contains(o) == true) {
			remove(indexOf(o));
		}
		// excessive searching in this implementation
		return false;

	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean contains(T o) {

		for (int i = 0; i < size ; i++) {
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
			for (int i = 0; i < size -1; i++) {
				str += get(i) + ", ";
			}

			str += get(size -1) + "]";

			return str;
		}

		return "[]";

	}
	
	public T remove(int index) {
        T result = null;

       
        if(size == 1) {
            last = null;
            first = null;
        }
        else if (index == 0) { 
            result = first.element;
            first = first.next;
            first.previous = null;

        } else if(index == size - 1){ 
        	result = last.element;
            last = last.previous;
            last.next = null;
            
        } else {
            Node n = first;
            for (int i = 0; i < index-1; i++) {
                n = n.next;
            }
            result = n.next.element;
            n.next = n.next.next;
            n.next.previous = n;
            
        }

        size--;

        return result;
    }
	

}
