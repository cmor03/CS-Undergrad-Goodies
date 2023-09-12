package MorrisLab7;

import MorrisLab7.HockeyPlayer.Position;

public class Driver {

	public static void main(String[] args) {
		HockeyPlayer colton = new HockeyPlayer("Colton", 10, Position.CENTER);
		
		System.out.println(colton);
		
		HockeyPlayer Elon = new HockeyPlayer();
		System.out.println(Elon);
		
		Elon.deepCopy(colton);
		
		System.out.println(colton.equals(Elon));
		System.out.println(Elon);
		
		colton.setPlayer("Jackson", 2, Position.LEFT_WING);
		
		System.out.println(colton);
		System.out.println(Elon);
		System.out.println(colton.equals(Elon));
		
		colton.setName("George");
		System.out.println(colton);
		
		
		
		

	}

}
