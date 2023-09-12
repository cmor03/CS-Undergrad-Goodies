package MorrisLab14;


public class ShuffleCipher implements MessageEncoder{

	int shuffle;
	
	public ShuffleCipher(int n) {
		shuffle = n;
	}
	
	public String shuffle(String plaintext) {
		int length = plaintext.length();
		int half = length/2;
		
		if (length %2 != 0) {
			half++;
		}
		
		String one = plaintext.substring(0, half);
		String two = plaintext.substring(half);
		
		char[] out = new char[length];
		
		for (int i = 0; i < two.length(); i ++) {
			out[i*2] = one.charAt(i);
			out[i*2 +1] = two.charAt(i);
			
		}
		
		if (length % 2 != 0) {
			out[length -1] = one.charAt(one.length()-1);
			
		}

		return new String(out);
	}
	
	public String encode(String plaintext) {
		for (int i = 0; i < shuffle; i++) {
			plaintext = shuffle(plaintext);
		}
		
		return plaintext;
	}

}
