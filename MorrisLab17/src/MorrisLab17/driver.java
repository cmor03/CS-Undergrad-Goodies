package MorrisLab17;

public class driver {

	public driver() {
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		
		//queue test 1 with Integer
		Queue<Integer> gen1 = new Queue<Integer>();
		
		gen1.enqueue(10);
		gen1.enqueue(12);
		gen1.enqueue(19);
		gen1.enqueue(21);
		gen1.enqueue(23);
		gen1.enqueue(17);
		
		gen1.dequeue();
		
		//queue test 2 with String
		Queue<String> gen2 = new Queue();
		
		gen2.enqueue("Hello");
		gen2.enqueue("GoodBye");
		gen2.enqueue("Whats up");
		gen2.enqueue("Nicki Minaj");
		gen2.enqueue("Taylor Swift");
		gen2.enqueue("Computer Science");
		
		gen2.dequeue();
		
		
		
		//stack test 1 with Integer
		Stack<Integer> gen3 = new Stack<Integer>();
		
		gen3.push(10);
		gen3.push(12);
		gen3.push(19);
		gen3.push(21);
		gen3.push(23);
		gen3.push(17);
		
		gen3.pop();
		
		//stack test 2 with char
		
		Stack<Character> gen4 = new Stack();
		
		gen4.push('a');
		gen4.push('b');
		gen4.push('c');
		gen4.push('d');
		gen4.push('e');
		gen4.push('f');
		
		gen4.pop();
		
		//PriorityQueue test 1 with Integers 
		 
		PriorityQueue<Integer> gen5 = new PriorityQueue();
		gen5.enqueue(10);
		gen5.enqueue(12);
		gen5.enqueue(19);
		gen5.enqueue(21);
		gen5.enqueue(23);
		gen5.enqueue(17);
		
		gen5.dequeue();
		
		//

	}

}
