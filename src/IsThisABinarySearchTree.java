
public class IsThisABinarySearchTree {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

	}

	// This one is wrong
	boolean checkBSTv1(Node root) {

		if (root == null || (root.left == null && root.right == null))
			return true;
		if (root.left != null && root.left.data < root.data)
			return checkBSTv1(root.left);
		if (root.right != null && root.right.data > root.data)
			return checkBSTv1(root.right);
		return false;

	}

	// Working --passed all the test cases
	boolean checkBSTv2(Node root) {
		if (root == null)
			return true;
		if (root.left != null && getMax(root.left) >= root.data)
			return false;
		if (root.right != null && getMin(root.right) <= root.data)
			return false;
		if (!checkBSTv2(root.left) || !checkBSTv2(root.right))
			return false;
		return true;
	}

	int getMin(Node node) {
		int min = Integer.MAX_VALUE;
		Node temp = node;
		while (temp != null) {
			if (min > temp.data)
				min = temp.data;
			temp = temp.left;
		}
		return min;
	}

	int getMax(Node node) {
		int max = Integer.MIN_VALUE;
		Node temp = node;
		while (temp != null) {
			if (max < temp.data) {
				max = temp.data;
			}
			temp = temp.right;
		}
		return max;
	}

	/*
	 * 
	 * 
	 */
	boolean checkBSTv3(Node root) {
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;
		return checkBSTUtil(root.left, min, root.data) && checkBSTUtil(root.right, root.data, max);
	}

	boolean checkBSTUtil(Node node, int min, int max) {
		if (node == null)
			return true;
		if (node.data <= min || node.data >= max)
			return false;
		return checkBSTUtil(node.left, min, node.data) && checkBSTUtil(node.right, node.data, max);
	}

	public static void main(String[] args) {

		// Node root = new Node(3);
		//
		// Node node1 = new Node(5);
		// Node node2 = new Node(2);
		// root.left = node1;
		// root.right = node2;
		// Node node3 = new Node(1);
		// Node node4 = new Node(4);
		// node1.left = node3;
		// node1.right = node4;
		// Node node5 = new Node(6);
		// node2.right = node5;

		Node root = new Node(3);

		Node node1 = new Node(2);
		Node node2 = new Node(5);
		root.left = node1;
		root.right = node2;
		Node node3 = new Node(1);
		Node node4 = new Node(4);
		node1.left = node3;
		node1.right = node4;
		Node node5 = new Node(6);
		node2.right = node5;
		System.out.println(new IsThisABinarySearchTree().checkBSTv2(root));
//		System.out.println(new IsThisABinarySearchTree().checkBSTv3(root));
	}
}
