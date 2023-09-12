package MorrisLab6;
import java.io.*;
import java.util.*;


public class NumberReader {

	public static void main(String[] args) throws IOException {
		File file = new File("Special2.dat");
		RandomAccessFile fileStream = null;
		
		try {
			
			fileStream = new RandomAccessFile(file, "r");
			fileStream.seek(4);
			int min = fileStream.readInt();
			fileStream.seek(4);
			int max = fileStream.readInt();
			int temp1;
			fileStream.seek(0);
			int start = fileStream.readInt();
			System.out.println("Total integers: " + start);
			fileStream.seek(0);
			for (int i = 0; i <= start; i++) {
				temp1 = fileStream.readInt();
				if (i>1) {
					System.out.print(temp1 + ", ");
					if (min > temp1) {
						min = temp1;
					}
					else if (max < temp1) {
						max = temp1;
					}
					
					if (i % 4 == 0) {
						System.out.println();
					}
				}
			}
			
			System.out.println("The min is: " + min + "\nThe max is: " + max);
			fileStream.close();
			
		} catch (EOFException e){
			System.out.println("IO FAILURE: " + e.getMessage());
		}

	}

}
