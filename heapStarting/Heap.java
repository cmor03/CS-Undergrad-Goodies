package edu.du.cs.cmorris.heapStarting;

// A max heap class
public class Heap<T extends Comparable<T>> {
	
	private int n;
	private int size;
	private T[] values;
	
	// Create an empty heap that can hold N elements
	@SuppressWarnings("unchecked")
	public Heap(int n) {
		this.n = n;  // max size of the heap
		this.size = 0;  // nothing added to the heap
		this.values = (T[])new Comparable[n];  // heap values
	}
	
	// Create a heap from an array
	@SuppressWarnings("unchecked")
	public Heap(int n, T[] values) {
		this.n = n;  // max size of the heap
		this.size = values.length;  // heap has values in it already
		// Make a deep copy of the heap values
		this.values = (T[])new Comparable[n];
		for (int i=0; i<size; i++) {
			this.values[i] = values[i];
		}
	}

	public void insert(T value) {
		
		if (size == n) {
			System.out.println("Heap is full");
		} else {
			// Insert at the last position
			int current = size;
			values[current] = value;
			
			// Filter up
			int parent = (current-1)/2;
			// Parent must be bigger than its  (current), otherwise we keep filtering
			while ((current > 0) &&
				   (values[parent].compareTo(values[current]) < 0)) {
				// Swap values
				T temp = values[parent];
				values[parent] = values[current];
				values[current] = temp;
				
				// Move up
				current = parent;
				parent = (current-1)/2;
			}
			size++;
		}
	}

	public int getLeft(int node) {
		return 2*node+1;
	
	}
	
	public int getRight(int node) {
		return 2*node+2;
	}
	
	
	
	public T removeMax() {
        T temp = null;
        if (0 == size) {
            throw new RuntimeException("Heap Empty");
        } else if (size == 1) {
            temp = values[0];
        } else {
            temp = values[0];
            values[0] = values[size - 1];
            int currentNode = 0;
            while (getLeft(currentNode) < size || getRight(currentNode) < size) {
                if (getLeft(currentNode) < size && getRight(currentNode) < size) {
                    if (values[getLeft(currentNode)].compareTo(values[getRight(currentNode)]) > 0) { //swapper methods
                        T temp2 = values[getLeft(currentNode)];
                        values[getLeft(currentNode)] = values[currentNode];
                        values[currentNode] = temp2;
                        currentNode = getLeft(currentNode);
                    } else {
                        T temp2 = values[getRight(currentNode)];
                        values[getRight(currentNode)] = values[currentNode];
                        values[currentNode] = temp2;
                        currentNode = getRight(currentNode);

                    }

                } else {
                    if (getLeft(currentNode) < size) {
                        T temp2 = values[getLeft(currentNode)];
                        values[getLeft(currentNode)] = values[currentNode];
                        values[currentNode] = temp2;
                        currentNode = getLeft(currentNode);

                    } else {
                        T temp2 = values[getRight(currentNode)];
                        values[getRight(currentNode)] = values[currentNode];
                        values[currentNode] = temp2;
                        currentNode = getRight(currentNode);

                    }
                }

            }
        }
        size--;
        return temp;
    }
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public String toString() {
		String result = "";
		for (int i=0; i<size; i++) {
			result += values[i] + " ";
		}
		return result;
	}
}
