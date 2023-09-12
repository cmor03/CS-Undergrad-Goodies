package edu.du.cs.cmorris.lab3;

import edu.du.cs.cmorris.linkedlist.DLList;
import edu.du.cs.cmorris.linkedlist.ListIf;

public class LinkedListQueue<T> implements QueueIf<T> {
	
	private ListIf<T> queue = null;
	private int capacity;
	
	public LinkedListQueue(int capacity) {
		this.capacity = capacity;
		queue = new DLList<T>();
	}

	@Override
	public boolean isEmpty() {
		return (queue.size() == 0);
	}

	@Override
	public boolean isFull() {
		return (queue.size() == capacity);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return queue.size();
	}

	@Override
	public T peek() {
		return queue.get(0);
	}

	@Override
	public T dequeue() {
		return queue.remove(0);
	}

	@Override
	public void enqueue(T o) {
		if (queue.size() < capacity)
			queue.add(queue.size(), o);
		else {
			System.out.println("Doubly Linked list is full!");
		}
		// TODO Auto-generated method stub
		
	}
	
	public String toString() {
		return queue.toString();
	}

}
