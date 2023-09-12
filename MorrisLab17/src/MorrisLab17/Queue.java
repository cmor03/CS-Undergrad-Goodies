package MorrisLab17;
import java.util.ArrayList;

public class Queue<T>{
	protected ArrayList<T> list;

	public Queue() {
		list = new ArrayList<T>();
	}
	
	public void enqueue(T t) {
		System.out.println("added: " + t);
		list.add(t);
	}
	
	public T dequeue() {
		if (!(list.size() == 0)) {
			T temp = list.get(0);
			System.out.println("removed: " + temp);
			list.remove(0);
			return temp;
		}
		
		return null;
		
	}
	
	public boolean isEmpty() {
		if (list.size() > 0) {
			return false;
		}
		return true;
	}

}
