package MorrisLab15;

import java.util.ArrayList;

public class Gallery {
	
	ArrayList<Art> gal1;
	
	public Gallery() {
		gal1 = new ArrayList<Art>();
	}
	
	public void addPiece(Art a) {
		gal1.add(a);
		
	}
	
	public void printCollection() {
		for (Art a : gal1) {
			System.out.println(a.getArtist() + ", By: " + a.getName());
		}

	}
	
	public int numberBy(String a) {
		int count = 0;
		
		for (Art pieces : gal1) {
			if (pieces.getArtist().equals(a)) {
				count++;
			}
		}
		
		return count;
	}
	
	
	public int numberMatching(String s) {
		int count = 0;
		for (Art piece : gal1) {
			if (piece.matches(s)) {
				count++;
			}
		}
		
		return count;
		
	}

}
