
public class FindPrime {

	public static void main(String[] args) {
		double startTime = System.currentTimeMillis();
		int n = 100000;
		System.out.println(primeRange(0,n));
		
		double endTime = System.currentTimeMillis();
		double runTime = (endTime-startTime);
		System.out.println(runTime);
		
		startTime = System.currentTimeMillis();
		
		int numThreads = 4;
		int[] results = new int[numThreads];
		Thread[] ths = new Thread[numThreads];
		
		for (int i = 0; i < numThreads; i++) {
			int start = (n/numThreads)* i;
			int stop = (n/numThreads)* (i+1);
			
			FindPrimeThread fpt = new FindPrimeThread(i, results, start, stop);
			
			Thread th = new Thread(fpt);
			ths[i] = th;
			th.start();
		}
		
		for (int i = 0; i < numThreads; i++) {
			try {
				ths[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		int fin = 0;
		for (int i = 0; i < numThreads; i++	) {
			fin += results[i];
		}
		
		endTime = System.currentTimeMillis();
		runTime = (endTime-startTime)/numThreads;
		
		System.out.println(fin + ", " + runTime);
		
		
		
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

