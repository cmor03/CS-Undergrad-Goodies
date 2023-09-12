package MorrisLab14;

public class ShiftCipher implements MessageEncoder{

	int shift;
	
	public ShiftCipher(int a){
		shift = a;
		
	}
	
	public String encode(String plaintext) {
		char[] charr1 = plaintext.toCharArray();
		
		for (int i = 0; i < charr1.length; i++) {
			charr1[i] = (char) ((charr1[i] + shift) % 128);
		}
		
		 return new String(charr1);
	}

}
