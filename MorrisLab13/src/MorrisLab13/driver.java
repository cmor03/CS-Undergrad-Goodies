package MorrisLab13;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;


public class driver {

	public static void main(String[] args) {
		int n = 0;
		
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the name of a DAT file to be sorted: (include .dat) ");
		String file = input.next();
		RandomAccessFile file1 = null;
		int factor = 0;

		
		try {
			file1 = new RandomAccessFile(file, "r");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			n = file1.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int[] arr1 = new int[n];
				
		for (int i = 0; i < n; i++) {
			try {
				arr1[i] = file1.readInt();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(arr1[i]);
			
		}
		
		System.out.println("________________________");
		factor = Sorting.selectionSort(arr1);
		
		for (int i = 0; i < n; i++) {
			System.out.println(arr1[i]);
		}
		
		System.out.println("The sorted factor for this array was: "
				+ factor);

	}

}
