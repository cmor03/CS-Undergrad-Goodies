package MorrisLab17;

public class PriorityQueue<T extends Comparable<T>> extends Queue<T>{
	

	public PriorityQueue() {
		super();
	}
	
	public T dequeue() {
		int p = 0;
		
		if (list.size() == 0) {
			return null;
		}
		for (int i = 0; i < list.size(); i++) {
			int j = i+1;
			if (i == list.size() -1) {
				j = 0;
			}
			if (list.get(i).compareTo(list.get(j)) < 0){
				p = i+1;
			}
			
		}
		
		
		T temp = list.get(p);
		System.out.println("removed: " + temp);
		list.remove(p);
		return temp;
		
	}
}
