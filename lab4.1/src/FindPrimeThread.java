
public class FindPrimeThread implements Runnable{
	private int threadNum;
	private int[] results;
	private int start;
	private int stop;
	
	public FindPrimeThread(int threadNum, int[] results, int start, int stop) {
		this.threadNum = threadNum;
		this.results = results;
		this.start = start;
		this.stop = stop;
		
	}
	
	@Override
	public void run() {
		System.out.println("Thread "+ threadNum + ": " + start + " to " + stop);
		
		int temp = primeRange(start, stop);
		
		this.results[threadNum] = temp;
		
	}
	
	public static boolean isPrime(int val) {
		if (val >= 1 && val <=3) {
			return true;
		}
		
		for (int i = 2; i< val; i++) {
			if (val%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int primeRange(int x, int y) {
		int primeCounter = 0;
		for (int i = x; i < y; i++) {
			if (isPrime(i)) {
				primeCounter++;
			}
		}
		
		return primeCounter;
	}

}
