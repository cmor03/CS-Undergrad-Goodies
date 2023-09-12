package MorrisLab6;
import java.util.Scanner;
import java.io.*;

public class ProgrammingAdvice {

	public static void main(String[] args) {
		PrintWriter output = null;
		File adviceDoc = new File("Advice.txt");
		Scanner sc;
		
		try {
			sc = new Scanner(adviceDoc);
			System.out.println("My advice is: " + sc.nextLine());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
		try {
			output = new PrintWriter(new File("Advice.txt"));
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner advice = new Scanner(System.in);
		System.out.print("Enter your advice: ");
		
		if (output != null) {
			output.println(advice.nextLine());
			output.flush();
		}
		
		advice.close();

		

		
		
		
		


	}

}
