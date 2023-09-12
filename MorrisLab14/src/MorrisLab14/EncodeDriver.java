package MorrisLab14;

//worked with Yulia, Saroja, and Nora
public class EncodeDriver {

	public static void main(String[] args) {
		
		ShiftCipher test1 = new ShiftCipher(3);
		
		System.out.println(test1.encode("facetiously"));
		
		ShuffleCipher test2 = new ShuffleCipher(3);
		
		System.out.println(test2.encode("facetiously"));
		
	}

}
