package raditya.lab.algorithm;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MainProject {
	public static void main(String[] args){
		lakesotong();
	}
	
	// Lake Sotong
	private static void lakesotong(){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] array;
		
		for (int i = 0; i < T; i++){
			int C = sc.nextInt();
			array = new int[C][C];
			for (int row = 0; row < C; row++){
				for (int column = 0; column < C; column++){
					array[row][column] = column;
				}	
			}			
		}
		
		System.out.println("hello");
	}
	
	
	// Search Min Value Of Array
	private static void minValueArray(){
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		int[] array = new int[T];
		for(int i = 0; i < T; i++){
			int C = scanner.nextInt();
			array[i] = C;			
		}
		
		// Sort Array
		array = sortArray(array);
		
		System.out.println("Hello World");
	}
	
	private static int[] sortArray(int[] array){
		int val = array[0];
		int[] result = new int[array.length];
		for(int i = 0; i < array.length; i++){
			if(array[i] > val){
				val = array[i];
				result[i] = val;
			}
		}
		return result;
	}
}
