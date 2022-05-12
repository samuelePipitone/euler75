package euler75;

public class Solutions {
	
	public int mul3and5(int n) {
		int ret = 0;
		
		for(int i = 0; i < n; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				ret += i;
			}
		}
		
		return ret;
	}
	
	public int evenFibonacci() {
		int sum = 0;
		int fibPrev = 0;
		int fibSucc = 1;
		int fib = 0;
		final int max = 4000000;

		while(fib < max) {
			fib = fibPrev + fibSucc;
			fibPrev = fibSucc;
			fibSucc = fib;
			if(fib % 2 == 0 && fib < max) {
				sum += fib;
			}
		}
		
		return sum;
	}
	
	public int largestPalindrome() {
		int intSupp = 0;
		int ret = 0;
		final int MAXITER = 999;
		String support = "";
	
		for(int i = 99; i < MAXITER; i++) {
			for(int j = 99; j < MAXITER; j++) {
				intSupp = i*j;
				support = Integer.toString(intSupp);
				if(isPalindrome(support) && intSupp > ret) {
					ret = intSupp;
				}
			}
		}
		
		return ret;
	}
	
	public boolean isPalindrome(String s) {
		
		if(s.length() == 1 || s.length() == 0) {
			return true;
		}
		
		if(s.charAt(0) == s.charAt(s.length() - 1)) {
			return isPalindrome(s.substring(1, s.length() - 1));
		} else return false;
	}

	public int smallestMultiple(int n) {
		int ret = 10;
		boolean b = false;
	
		while(!b) {
			if(isDivisibleNTimes(ret, n)) {
				b = true;
			} else {
				ret += 10; //reduce time
			}
		}
		
		return ret;
	}
	
	public boolean isDivisibleNTimes(int i, int n) {	//bad, i know

		int count = 0;
		
		for(int j = 2; j < n; j++) {
			if(i % j == 0) {
				count++;
			}
		}
		if(count == (n - 2)) return true; 
		else return false;
		
	}
	
	public int sumSquareDiff(int n) {
		int ret = 0;
		
		int sumSquare = sumSquare(n);
		int squareSum = squareSum(n);
		
		if(sumSquare > squareSum) {
			ret = sumSquare - squareSum;
		} else {
			ret = squareSum - sumSquare;
		}
		
		return ret;
	}
	
	public int sumSquare(int n) {
		int ret = 0;
		
		for(int i = 1; i <= n; i++) {
			ret += (i*i);
		}
		
		return ret;
	}
	
	public int squareSum(int n) {
		int ret = 0;
		
		for(int i = 1; i <= n; i++) {
			ret += i;
		}
		
		return ret*ret;
	}

	public int nthPrime(int n) {
		int count = 0;
		int i = 2;
		
		while(count < n) {
			if(isPrime(i)) {
				count++;
			}
			i++;
		}
		return --i;
	}
	
	public boolean isPrime(int n) {
		
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	//USED LONG CAUSE INT MADE OVERFLOW F%%%%%
	public long largestProductSeries(int n) {
		String BIGNUM = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		long max = 0;
		long prod = 0;
		
		for(int i = 0; i < BIGNUM.length(); i++) {
			if(i+n <= BIGNUM.length()) {
				prod = productString(BIGNUM.substring(i, i+n));
			}
			
			if(prod > max) {
				max = prod;
			}
		}
		return max;
	}
	
	public long productString(String s) {
		long sum = 1;
		char at;
		
		for(int i = 0; i < s.length(); i++) {
			at = s.charAt(i);
			sum *= (at - '0');
		}
		return sum;
	}
	
	
	
	
}
