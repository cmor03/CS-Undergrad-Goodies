package edu.du.cs.cmorris.lab3;

public class CircularArrayQueue<T> implements QueueIf<T> {
	private T[] queue = null;
	private int front = 0;
	private int rear = 0;
	private int size;
	private int capacity;

	CircularArrayQueue(int capacity) {
		this.capacity = capacity;
		queue = (T[]) (new Object[capacity]);
	}

	@Override
	public boolean isEmpty() {
		return (size == 0);
	}

	@Override
	public boolean isFull() {
		return (size == capacity);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return queue[front];
	}

	@Override
	public T dequeue() {
		T item = null;

		if (!isEmpty()) {
			item = queue[front];
			queue[front] = null;

			size--;

			if (!isEmpty()) {
				front = (front + 1) % capacity;
			}

		}

		return item;

	}

	@Override
	public void enqueue(T o) {

		if (isEmpty()) {
			queue[front] = o;

		} else if (!isFull()) {
			int i = (rear + 1) % capacity;
			queue[i] = o;

			rear = i;
		}

		size++;
	}

	public String toString() {
		String result = "[";

			for (int i = 0; i < size-1; i++)	{
				result += queue[(i+front)%capacity] + ", ";
			}
			
			if (isEmpty()) {
				return result += "]";
			}
		return result + queue[rear] + "]";
	}
	
	
	
	
	
	
}