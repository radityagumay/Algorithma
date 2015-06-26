package raditya.lab.algorithm;

import java.math.BigInteger;
import java.util.concurrent.TimeUnit;

public class ProjectEuler {
	
	public static void main(String[] args){
		System.out.print(new ProjectEuler().solution05());
	}
	
	public static int solution09(){
		int number = 1000;
		int result = 0;
		for(int i = 1; i <= number; i++){
			for (int j = 1; j <= number; j++){
				for (int k = 1; k <= number; k++){
					if(i*i + j*j == k*k && i+j+k == 1000){
						result = i * j * k;
					}
				}	
			}
		}
		return result;
	}
	
	//2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
	//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
	public static String solution05(){
		BigInteger allLcm = BigInteger.ONE;
		for (int i = 1; i <= 20; i++)
			allLcm = lcm(BigInteger.valueOf(i), allLcm);
		return allLcm.toString();
	}
	
	private static BigInteger lcm(BigInteger x, BigInteger y) {
		return x.divide(x.gcd(y)).multiply(y);
	}
	
	public static int solution04(){
		int maxPalindrome = 1;
		for(int i = 100; i < 1000; i++){
			for(int j = 100; j < 1000; j++){
				if(isPalindrome(String.valueOf(i*j))){
					maxPalindrome = maxPalindrome > i*j ? maxPalindrome : i*j;
				}
			}	
		}
		return maxPalindrome;
	}
	
	public static boolean isPalindrome(String str){
		String palindrome = "";
		StringBuilder builder = new StringBuilder(str);
		palindrome = builder.reverse().toString();
		if(str.equals(palindrome)){
			return true;
		}
		return false;
	}
	
	
	public static long solution03(){
		long number = 600851475143l;
		long result = 2;
		
		long startTime = System.nanoTime();
		long endTime = 0L;
		long elapsedTime = 0L;
		
		for (long i = 2; i < Math.sqrt(number); i++) {
		    if (number % i == 0) { // It is a divisor
		        boolean isPrime = true;
		        for (long j = 2; j < i; j++) {
		            if (i % j == 0) {
		                isPrime = false;
		                break;
		            }
		        }
		        if (isPrime) {
		        	result = i;
		        }
		    }
		}
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println(elapsedTime / 1000000 + " ms");
		return result;
	}
	
	public static int solution02(){
		int sum = 0;
		for (int i = 0; ;i++) {
			int fib = fibonacci(i);
			if (fib > 4000000)
				break;
			if (fib % 2 == 0)
				sum += fib;
		}
		return sum;
	}
	
	private static int fibonacci(int val){
		int a = 0;
		int b = 1;
		for(int i = 0; i < val; i++){
			int c = a + b;
			a = b;
			b = c;
		}
		return a;
	}
	
	public static int solution01(){
		int number = 1000;
		int result = 0;
		for(int i = 0; i < number; i++){
			if(i % 3 == 0 || i % 5 == 0){
				result += i;
			}
		}
		return result;
	}
}
