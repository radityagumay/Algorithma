package raditya.lab.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sotong {

	static Scanner sc;
	static int V, E, T;
	static int testCases;
	static boolean[][] map;
	static int[] color;
	static boolean[] visited;
	static boolean isBipartite;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		T = sc.nextInt();
		for (testCases = 1; testCases <= T; testCases++) {
			// prepare the map
			V = sc.nextInt();
			E = sc.nextInt();
			map = new boolean[V + 1][V + 1];
			color = new int[V + 1];
			visited = new boolean[V + 1];
			// read the map
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				map[a][b] = true;
				map[b][a] = true;
			}
			// visit and color the map (BFS)
			isBipartite = true;
			for (int i = 1; i <= V; i++)
				if (isBipartite && !visited[i])
					checkBipartite(i, 1);
			// write the answers
			System.out.print("#" + testCases);
			if (isBipartite) {
				int color1Count = 0;
				for (int i = 1; i <= V; i++)
					if (color[i] == 1)
						color1Count++;
				System.out.print(" " + color1Count);
				for (int i = 1; i <= V; i++)
					if (color[i] == 1)
						System.out.print(" " + i);
				System.out.println();
			} else {
				System.out.println(" -1");
			}
		}
		sc.close();
	}

	private static void checkBipartite(int thisCity, int currentColor) {
		// initial check
		visited[thisCity] = true;
		if (color[thisCity] == 0)
			color[thisCity] = currentColor;
		else if (color[thisCity] != currentColor)
			isBipartite = false;
		// neighbors coloring + check (BFS)
		if (isBipartite)
			for (int nextCity = 1; nextCity <= V; nextCity++)
				if (map[thisCity][nextCity])
					if (color[nextCity] == 0)
						color[nextCity] = currentColor * -1;
					else if (color[nextCity] != currentColor * -1)
						isBipartite = false;
		// visit those neighbors (BFS)
		if (isBipartite)
			for (int nextCity = 1; nextCity <= V; nextCity++)
				if (map[thisCity][nextCity] && !visited[nextCity])
					checkBipartite(nextCity, currentColor * -1);
	}

	private static void bidirectionalEdge() {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int i = 0; i < T; i++) {
			int vertex = scanner.nextInt();
			int edge = scanner.nextInt();

			int[][] edges = new int[edge][2];
			for (int row = 0; row < edge; row++) {
				for (int column = 0; column < 2; column++) {
					edges[row][column] = scanner.nextInt();
				}
			}

			String result = makeSameGroup(edges, vertex);
			System.out.print("hello");
		}
	}

	private static String makeSameGroup(int[][] edges, int vertex) {
		// [4, 1], [1, 2], [2, 3], [7, 2], [1, 5], [8, 4], [5, 8], [8, 9]
		// 1
		// 9 8
		// 4 1 1 2 2 3 7 2 1 5 8 4 5 8 8 9

		boolean[][] vertexs = new boolean[vertex + 1][vertex + 1];
		for (int row = 0; row < edges.length; row++) {
			int E1 = edges[row][0];
			int E2 = edges[row][1];

			// insert to each vertexs
			vertexs[E1][E2] = true;
			vertexs[E2][E1] = true;
		}

		return "";
	}

	private static void partitionGroup() {
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		int vertexSum = 0;
		int edge = 0;
		int[][] edges = null;
		for (int i = 0; i < T; i++) {
			vertexSum = scanner.nextInt();
			edge = scanner.nextInt();
			edges = new int[edge][2];
			for (int row = 0; row < edge; row++) {
				for (int column = 0; column < 2; column++) {
					edges[row][column] = scanner.nextInt();
				}
			}
		}

		// int[][] edges = { { 1, 3 }, { 1, 2 }, { 1, 7 }, { 2, 6 }, { 2, 8 }, {
		// 3, 4 }, { 3, 5 } };
		// int vertexSum = 8;
		SetArrayList[] vertexSet = new SetArrayList[vertexSum + 1];
		for (int i = 1; i < vertexSet.length; i++) {
			vertexSet[i] = new SetArrayList(vertexSum / 2);
		}
		SetArrayList vertexSubsetTop = new SetArrayList(vertexSum / 2);
		SetArrayList vertexSubsetBottom = new SetArrayList(vertexSum / 2);
		for (int i = 0; i < edges.length; i++) {
			int vStart = edges[i][0];
			int vEnd = edges[i][1];
			vertexSet[vStart].add(vEnd);
			vertexSet[vEnd].add(vStart);
		}
		vertexSubsetTop.add(1);
		for (int i = 2; i <= vertexSum; i++) {
			if (vertexSet[1].isContaining(i)) {
				continue;
			}
			SetArrayList vertex = vertexSet[i];
			if (vertex.isContaining(vertexSubsetTop)) {
				continue;
			}
			vertexSubsetTop.add(i);
		}
		for (int i = 2; i <= vertexSum; i++) {
			if (!vertexSubsetTop.isContaining(i)) {
				if (vertexSubsetBottom.currentSize == 0) {
					vertexSubsetBottom.add(i);
				} else {
					SetArrayList vertex = vertexSet[i];
					if (vertex.isContaining(vertexSubsetBottom)) {
						continue;
					}
					vertexSubsetBottom.add(i);
				}
			}
		}
		if (vertexSubsetTop.currentSize + vertexSubsetBottom.currentSize == vertexSum) {
			for (int i = 0; i < vertexSubsetTop.currentSize; i++) {
				if (i == vertexSubsetTop.currentSize - 1) {
					System.out.print(vertexSubsetTop.get(i));
				} else {
					System.out.print(vertexSubsetTop.get(i) + " ");
				}
			}
		} else {
			System.out.println("-1");
		}
	}

	static class SetArrayList {
		int[] model;
		public int currentSize;

		SetArrayList(int capacity) {
			model = new int[capacity + 1];
		}

		void add(int i) {
			currentSize = model[0] + 1;
			if (currentSize >= model.length) {
				int[] temp = model;
				model = new int[currentSize * 2];
				model[0] = temp[0];

				for (int j = 1; j < temp.length; j++) {
					model[j] = temp[j];
				}
			}

			model[currentSize] = i;
			model[0] = currentSize;
		}

		int get(int index) {
			return model[index + 1];
		}

		boolean isContaining(int entry) {
			for (int i = 1; i <= currentSize; i++) {
				if (model[i] == entry) {
					return true;
				}
			}
			return false;
		}

		boolean isContaining(SetArrayList array) {
			for (int i = 1; i <= currentSize; i++) {
				for (int j = 0; j < array.currentSize; j++) {
					if (model[i] == array.get(j)) {
						return true;
					}
				}
			}
			return false;
		}
	}

	private void array() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] array;
		for (int i = 0; i < T; i++) {
			int C = sc.nextInt();
			array = new int[C][C];

			for (int row = 0; row < C; row++) {
				for (int column = 0; column < C; column++) {
					array[row][column] = sc.nextInt();
				}
			}
		}
	}

}
