package MorrisLAB02;
/*
 * Colton Morris
 * 15 September 2021
 * The purpose of this class is to test
 * the hotdog stand class
 */

public class HotDogStandDriver {

	public static void main(String[] args) {
		System.out.println("Stand Name\tStand ID\tNumber Sold");
		HotDogStand stand1 = new HotDogStand("Race_St");
		HotDogStand stand2 = new HotDogStand("University_Blvd");
		HotDogStand stand3 = new HotDogStand("Illif_Ave");
		
		for (int i = 0; i <3; i++) {
			stand1.justSold((int)(Math.random()*25)+1);
		}
		for (int i = 0; i <3; i++) {
			stand2.justSold((int)(Math.random()*25)+1);
		}
		for (int i = 0; i <3; i++) {
			stand3.justSold((int)(Math.random()*25)+1);
		}
		
		System.out.println("*******************************************");
		
		System.out.println(stand1.getName() +"\t\t   " + stand1.getID() + "\t\t"+stand1.getSold());
		System.out.println(stand2.getName() +"\t   " + stand2.getID() + "\t\t"+stand2.getSold());
		System.out.println(stand3.getName() +"\t   " + stand3.getID() + "\t\t"+stand3.getSold());
		
		System.out.println("\nTotal Sold: "+ HotDogStand.getTotal());
		
		
	}

}
