import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BinarySearchTreeInsertion {
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

	public static Node insert(Node root, int data) {
		if (root == null) {
			root = new Node();
			root.data = data;
			return root;
		}
		Node temp = root;
		Node parent = null;
		while (temp != null) {
			parent = temp;
			if (data < temp.data) {
				temp = temp.left;
			} else if (data > temp.data) {
				temp = temp.right;
			}
		}
		if (data > parent.data)
			parent.right = new Node(data);
		else
			parent.left = new Node(data);

		return root;
	}

	public static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.data + "->");
		preOrder(root.left);
		preOrder(root.right);
	}

	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + "->");
		inOrder(root.right);
	}

	public static void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + "->");

	}

	public static void main(String[] args) throws IOException {

		Scanner scan = new Scanner(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
			System.out.println("\nPostOrder");
			postOrder(root);
		}
		scan.close();
//		System.out.println("PreOrder");
//		preOrder(root);
//		System.out.println("\nInOrder");
//		inOrder(root);
//		System.out.println("\nPostOrder");
//		postOrder(root);
	}
}
