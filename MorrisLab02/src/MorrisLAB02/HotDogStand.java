package MorrisLAB02;
/*
 * Colton Morris
 * 15 September 2021
 * The purpose of this class is to manage the data for my 
 * hotdog stands that I run
 */

public class HotDogStand {
	//instance variables
	String name;
	int uniqueID;
	int numSold;
	//static variables
	static int totalSold;
	static int storeNum = 0;
	
	public HotDogStand(String x) {
		name = x;
		storeNum++;
		uniqueID = storeNum;
		numSold = 0;
	}
	
	public void justSold() {
		numSold++;
		totalSold++;
	}
	
	public void justSold(int sold) {
		numSold+= sold;
		totalSold+= sold;
	}
	
	public String getName() {
		return name;
	}
	
	public int getID() {
		return uniqueID;
	}
	
	public int getSold() {
		return numSold;
	}
	
	public static int getTotal() {
		return totalSold;
	}
	
	
}
