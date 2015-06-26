package raditya.lab.algorithm;

import java.util.Scanner;

public class Codility {
	public static void main(String[] args){
		solution3();
	}
	
	public static int solution1(int N) {
		int result = 0;
		int tempI = 0;
		int tempResult = 0;
		for(int i = 1; i <= N; i++){
			result += i;
			if(result >= N){
				break;
			}
			tempI++;
			tempResult += i;
		}
		return tempI;
	}

	
	public static int solution2(int[] A) {
        // write your code in Java SE 8
        int result = 0;
		int index = 0;
		for (int i = 0; i < A.length; i++){
			result += A[i];
		}
		result = result / A.length;

		for (int j = 0; j < A.length; j++){
			if(A[j] <= result){
				return Math.abs(A[j]);
			}
		}
		return -1;
    }
	
	public static void solution3(){
		
	}
	
	
}