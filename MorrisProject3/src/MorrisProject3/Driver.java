/* Author: Colton Morris
 * Date: v.1 October 28th 2021
 * Purpose: The purpose of this program is to create different faces
 * and clocks that.
 */

package MorrisProject3;
import edu.du.dudraw.DUDraw;
import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		
		//not necessary, but makes them appear all at once instead of as they load
		DUDraw.enableDoubleBuffering();

		//instance variables
		//I decided to use the Scanner class to read the file
		Scanner input = null;
		int length = 0;
		int width = 0;
		Emoji[][] arr1 = null;
		
		//try catch method used to handle a FNFError
		try {
			input = new Scanner(new File("Emoji.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//initializes the array, and puts interprets the objects into the 2D array
		if (input != null) {
			
			//variables
			width = input.nextInt();
			length = input.nextInt();
			//initialization of the array
			arr1 = new Emoji[width][length];
			
			//for loop runs through the file, creating the necessary objects
			for (int i = 0; i < width; i++) {
				for (int q = 0; q < length; q++) {
					
					//put into a try loop in case of any errors 
					try {
						
						//had to use a String, that way my file 'cursor' wasn't advancing
						//when it wasn't supposed to
						String tempString = input.next();
						if (tempString.equals("smile")){
							arr1[i][q] = new SmileyFaceEmoji(100*q+50,i*100+50,1);
						}
						else if (tempString.equals("surprise")) {
							arr1[i][q] = new SuprisedFaceEmoji(100*q+50,i*100+50,1);
						}
						
						else if (tempString.equals("clock")) {
							arr1[i][q] = new ClockEmoji(100*q+50,i*100+50,1, input.nextInt());
						}

					} catch (NoSuchElementException e) {
						System.out.println(e + " " + i + ", " + q);
					}
				}
			}
		}
		
		//now that we have the necessary information, we can finally setup our canvas
		DUDraw.setCanvasSize(length*100,width*100);
		DUDraw.setXscale(0,length*100);
		DUDraw.setYscale(0,width*100);
		
		//for loops runs through all of the objects and displays them
		//if an index location is null, our program will handle that graceful and continue
		//to display faces regardless
		for (int i = 0; i < width; i++) {
			for (int q = 0; q < length; q++) {
				try {
					//prints class
					System.out.println("index: " + i + ", " + q +"\n"+arr1[i][q].getClass());

					//calls the draw method of the indexed object
					arr1[i][q].draw();
					
				} catch (NullPointerException e) {
					System.out.println(e);
					
				}
			}
		}
		DUDraw.show();

	}
}
