package MorrisLab15;

public class Lab15Driver {

	public static void main(String[] args) {
		Art art1 =  new Art("Scout", "Peyton");
		art1.addTag("Lake");
		Art art2 =  new Art("Watertown", "Colton");
		art2.addTag("Trees");
		Art art3 =  new Art("Bucks", "Jess");
		art3.addTag("Trees");
		
		Gallery gal1 = new Gallery();
		
		gal1.addPiece(art1);
		gal1.addPiece(art3);
		gal1.addPiece(art2);
		
		gal1.printCollection();
		System.out.println(gal1.numberBy("Colton"));
		System.out.println(gal1.numberMatching("Trees"));
		
	}

}
