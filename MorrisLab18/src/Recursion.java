//colton morris lab 18
public class Recursion {
	
	public static int sumOfSquares(int k) {
		if (k <= 0) {
			return 0;
		}
		else {
			return ((k*k) + sumOfSquares(k-1));
		}
		
	}
	
	public static int fib(int n) {
		
		if (n<=1) {
			return 1;
		}
		else {
			return fib(n-1)+fib(n-2);
		}
		
		
	}

}
