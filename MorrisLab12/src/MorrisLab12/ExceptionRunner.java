package MorrisLab12;
import java.util.Scanner;

public class ExceptionRunner {
	
	public static String convert(int d, int m) throws Exception {
		
		m-=1;
		
		String[] month = {"January", "February", "March", "April",
				"May", "June", "July", "August",
				"September", "October","November", "December"};
		
		
		if (m > 12 || m <= 0) {
			throw new MonthException("Your month is not in the range.\n"
					+ "Make sure your month is between 1-12.");
		}
		
		if (d > 31 || m < 0) {
			throw new DayException("Your day is not in the range.\n"
					+ "Make sure your day is between 1-31");
		}
		
		if (m == 3 || m == 5 || m == 8 || m == 10) {
			if (d > 30) {
				throw new MonthException("Day is out of range for " + month[m]);
			}
			
			else {
				return month[m] + " " + d;

			}
		}
		
		if (m == 1) {
			if (d > 28) {
				throw new DayException("Day is out of range for February");

			}
			else {
				return month[m] + " " + d;

			}
		}
		
		return month[m] + " " + d;

		
	}

	public static void main(String[] args) {
		boolean finished = false;

		int inMonth;
		int inDay;
		String decision = "";
		
		
		while (!finished) {
			System.out.println("Enter an integer representing the month: ");
			Scanner input = new Scanner(System.in);
			inMonth = input.nextInt();
			System.out.println("Enter an integer representing the day: ");
			inDay = input.nextInt();
			
			try {
				System.out.println(convert(inDay, inMonth));
			} catch (MonthException e) {
				System.out.println(e.getMessage());
				System.out.println("Date cannot be converted.");
			} catch (DayException e) {
				System.out.println(e.getMessage());
				System.out.println("Date cannot be converted.");
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("Do you want to convert another date? Enter Y or N: Y");
			decision = input.next();
			
			if (!(decision.equals("Y"))) {
				finished = true;
			}
		}
	}
}
