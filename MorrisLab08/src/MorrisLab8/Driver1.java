package MorrisLab8;

public class Driver1 {

	public static void main(String[] args) {
		 //fruit of type Fruit and instance variable Golden Delcious
		 //worked
		 Fruit fruit = new GoldenDelicious();
		 
		 //orange of type orange and instance variable Orange
		 //worked
		 Orange orange = new Orange();
		 
		 //apple of type Apple and instance variable Macintosh
		 //worked
		 Apple apple = new Macintosh();

		 //the code below does not run
		 //Orange p = new Apple();
		 
		 //the code below does not run
		 //Macintosh p = new Apple();
		 
		 //this works 
		 Apple p = new Macintosh();
		 
		 //this works
		 Fruit j = new Macintosh();

		 //the code below does not run
		 //GoldenDelicious g = new Fruit();
	}

}
