package euler75;

import java.util.Scanner;

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
	
	public long summationOfPrime(int n) {
		long sum = 2;
		int count = 1;
		int it = 0;
		
		while(count < n) {
			System.out.println("it: " + ++it);
			if(isPrime(count)) {
				sum += count;
				System.out.println(sum);
			}
			count += 2;
		}
		return --sum;
	}
	
	public int largestInAGrid() {
		
		Scanner sc = new Scanner("08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08\r\n"
				+ "49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00\r\n"
				+ "81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65\r\n"
				+ "52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91\r\n"
				+ "22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80\r\n"
				+ "24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50\r\n"
				+ "32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70\r\n"
				+ "67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21\r\n"
				+ "24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72\r\n"
				+ "21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95\r\n"
				+ "78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92\r\n"
				+ "16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57\r\n"
				+ "86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58\r\n"
				+ "19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40\r\n"
				+ "04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66\r\n"
				+ "88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69\r\n"
				+ "04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36\r\n"
				+ "20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16\r\n"
				+ "20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54\r\n"
				+ "01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48");
		
		String[][] grid = new String[20][20];
		int MAX = 0;
		int curr = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				grid[i][j] = sc.next();
			}
		}
		
		sc.close();
		
		//horizontal
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j <= grid[i].length - 4; j++) {
				curr = Integer.parseInt(grid[i][j]) * Integer.parseInt(grid[i][j+1]) * Integer.parseInt(grid[i][j+2]) * Integer.parseInt(grid[i][j+3]);
				if(curr > MAX) {
					MAX = curr;
				}
			}
		}
		
		//vertical
		for(int i = 0; i <= grid.length - 4; i++) {
			for(int j = 0; j < grid[i].length; j++) {
				curr = Integer.parseInt(grid[i][j]) * Integer.parseInt(grid[i+1][j]) * Integer.parseInt(grid[i+2][j]) * Integer.parseInt(grid[i+3][j]);
				if(curr > MAX) {
					MAX = curr;
				}
			}
		}
		
		//diagonal left to right
		for(int i = 0; i <= grid.length - 4; i++) {
			for(int j = 0; j <= grid[i].length - 4; j++) {
				curr = Integer.parseInt(grid[i][j]) * Integer.parseInt(grid[i+1][j+1]) * Integer.parseInt(grid[i+2][j+2]) * Integer.parseInt(grid[i+3][j+3]);
				if(curr > MAX) {
					MAX = curr;
				}
			}
		}
		
		//diagonal right to left -- TODO
		for(int i = 0; i <= grid.length - 4; i++) {
			for(int j = 0; j <= grid[i].length - 4; j++) {
				curr = Integer.parseInt(grid[i][grid.length - j - 1]) * 
						Integer.parseInt(grid[i + 1][grid.length - j - 2]) * 
						Integer.parseInt(grid[i + 2][grid.length - 3 - j]) * 
						Integer.parseInt(grid[3 + i][grid.length - 4 - j]);
				if(curr > MAX) {
					MAX = curr;
				}
			}
		}
		
		return MAX;
	}
	
	//why i*i? works but idk
	public int countDivisors(int n) {
		int count = 0;
		
		for(int i = 1; i*i <= n; i++) {
			if(n % i == 0) {
				count += 2;
			} 
			if(i > n / 2) {
				return count++;
			}
		}
		
		return count;
	}
	
	
	public long longestCollatz(int max) { 
		
		long currentNumber = 1;
		long tempValue;
		long currentChain = 0;
		long maxChain = 0;
		long ret = 0;
		boolean[] values = new boolean[max];
		
		while(currentNumber < max) {
			
			tempValue = currentNumber;
			currentChain = 0;
			
			while(tempValue != 1) {
				if(tempValue < max) {
					if(!values[(int) tempValue]) {
						if(tempValue % 2 == 0) {
							tempValue = tempValue / 2;
							values[(int) tempValue] = true;
						} else {
							tempValue = (tempValue * 3) + 1;
							if(tempValue < max) {
								values[(int) tempValue] = true;
							}
						}
						currentChain++;
					} else {
						break;
					}
				} else {
					if(tempValue % 2 == 0) {
						tempValue = tempValue / 2;
					} else {
						tempValue = (tempValue * 3) + 1;
					}
					currentChain++;
				}
			}
			
			if(currentChain > maxChain) {
				maxChain = currentChain;
				ret = currentNumber;
			}
			
			currentNumber++;
		}
		
		return ret;
	}
	
}
