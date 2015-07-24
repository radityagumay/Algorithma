package raditya.labs.igorsample;

import java.util.Scanner;

import radittya.labs.classess.SecondStack;

public class sample {
	public static void main(String[] args) {
		longestPath();
	}

	/*
	 * 4 4 
	 * 4 8 7 3 
	 * 2 5 9 3 
	 * 6 3 2 5 
	 * 4 4 1 6
	 */
	static int[][] arrayIgor;
	static int longestPath = 0;
	static int pathCount = 0;
	static int[][] visitedPosition;
	private static void longestPath() {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();
		arrayIgor = new int[r][c];
		visitedPosition = new int[(int)(Math.pow(arrayIgor.length, 2))][2];
		
		int[] test = new int[10];
		
		for(int i = 10; i > 0; i--){
			test[i--] = 1;;
		}
		
		
		for (int row = 0; row < arrayIgor.length; row++) {
			for (int col = 0; col < arrayIgor.length; col++) {
				arrayIgor[row][col] = sc.nextInt();
			}
		}
		toRight(0, 0);
	}

	private static void toRight(int rowPosition, int colPosition) {
		for (int row = rowPosition; row < arrayIgor.length; row++) {
			for (int col = colPosition; col < (arrayIgor.length - 1); col++) {
				// Save the position
				stack.push(row + "," + col);

				// If right value is less than left value always to right
				boolean flag = false;
				if (arrayIgor[row][col] > arrayIgor[row][col + 1]) {
					toRight(row, col);
				} else {
					// it's means the right value is not greater than current
					// value
					flag = true;
				}

				// check if they have side value, either up, left or down
				if (flag) {
					toLeft(row, col);
				}
			}
		}
	}

	private static void toLeft(int rowPosition, int colPosition) {
		for (int row = arrayIgor.length - 1; row > 0; row--) {
			for (int col = arrayIgor.length - 2; col > 0; col--) {
				// Save the position
				stack.push(row + "," + col);
			}
		}
	}

	private static void toDown(int rowPosition, int colPosition) {

	}

	private static void toUp(int rowPosition, int colPosition) {

	}
}
