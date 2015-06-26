package raditya.lab.algorithm;

import java.util.Scanner;

public class Sotong {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] array;
		for(int i = 0; i < T; i++){
			int C = sc.nextInt();
			array = new int[C][C];
			
			for (int row = 0; row < C; row++){
				for(int column = 0; column < C; column++){
					array[row][column] = sc.nextInt();
				}
			}
			
			//CODE HERE
			int result = array(array);
		}
	}
	
	private static int array(int[][] arrays){
		return 1;
	}
}
