package MorrisProject3;

public abstract class Emoji {
	
	//instance variables
	int x;
	int y;
	int size;
	
	//constructor
	public Emoji(int a, int b, int c){
		x = a;
		y = b;
		size = c;
	}
	
	//abstract class that all inherited classes will be modeled after
	abstract void draw();

}
