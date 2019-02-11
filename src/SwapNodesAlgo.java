import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SwapNodesAlgo {
	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public Node() {

		}

	}

	static int[][] swapNodes(int[][] indexes, int[] queries) {
		/*
		 * Write your code here.
		 */

	}

	private static final Scanner scanner2 = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));

		int n = scanner.nextInt();
		Node root = null;
		int[][] indexes = new int[n + 1][2];

		for (int i = 1; i <= n; i++) {
			indexes[i][0] = scanner.nextInt();
			indexes[i][1] = scanner.nextInt();
		}

	}
}
