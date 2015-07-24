package raditya.lab.algorithm;

import java.util.Scanner;

public class Sorting {
	public static void main(String[] args) {
		rheno();
	}

	private static void bubbleSort() {
		int[] array = new int[]{50,12,5,10,879,621,1,245,7747,5481};
		int n = array.length;
		int temp = 0;
		for(int i = 0; i < n; i++){
			for(int j = 1; j < (n - i); j++){
				if(array[j - 1] > array[j]){
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
				}
			}	
		}
		
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}	
	}	
	
	
	private static void rheno(){
		Scanner sc = new Scanner(System.in);
		
		int r = sc.nextInt();
		int c = sc.nextInt();
		int[][] array = new int[r][c];
		
		for(int row = 0; row < array.length; row++){
			for(int col = 0; col < array.length; col++){
				array[row][col] = sc.nextInt();
			}
		}
		
		int length = 0;
		int drop = 0;
		
		for(int i = 0; i < array.length; i++){
			
		}		
	}
}
