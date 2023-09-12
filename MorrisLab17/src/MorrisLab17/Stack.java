package MorrisLab17;
//worked with Yulia, Saroja, Sunjoi, Nora, Paulina
import java.util.ArrayList;

public class Stack<T>{
	private ArrayList<T> list;

	public Stack() {
		list = new ArrayList<T>();
	}
	
	public void push(T t) {
		System.out.println("added: " + t);
		list.add(t);
	}
	
	public T pop() {
		if (!(list.size() == 0)) {
			T temp = list.get(list.size()-1);
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
