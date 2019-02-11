import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Queue_using_Two_Stacks {

	/*
	 * enQueue--> push it to stack1 O(1) deQueue 1. if(stack2 is empty)--> pop
	 * everything from stack1 and push it to stack2 --> then pop the latest
	 * value from stack2 O(n) 2. if stack2 is not empty--> pop the latest value
	 * from stack2 O(1)
	 * 
	 * Peek 1. if(stack2 is empty)--> pop everything from stack1 and push it to
	 * stack2 --> then peek the latest value from stack2 O(n) 2. if stack2 is
	 * not empty--> peek the latest value from stack2 O(1)
	 * 
	 */
	public static void solution2(BufferedReader buffer) throws IOException {
		int Q = Integer.parseInt(buffer.readLine());

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		for (int i = 0; i < Q; i++) {
			String[] line = buffer.readLine().split(" ");
			int operation = Integer.parseInt(line[0]);
			switch (operation) {
			case 1:
				int value = Integer.parseInt(line[1]);
				stack1.push(value);
				break;
			case 2:
				if (!stack2.isEmpty()) {
					stack2.pop();
				} else {
					while (!stack1.isEmpty()) {
						stack2.push(stack1.pop());
					}
					stack2.pop();
				}
				break;
			case 3:
				if (!stack2.isEmpty()) {
					System.out.println(stack2.peek());
				} else {
					while (!stack1.isEmpty()) {
						stack2.push(stack1.pop());
					}
					System.out.println(stack2.peek());
				}
				break;
			}
		}
		buffer.close();
	}

	/*
	 * enQueue operation is costly here
	 */
	public static void solution1(BufferedReader buffer) throws IOException {
		int Q = Integer.parseInt(buffer.readLine());

		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		for (int i = 0; i < Q; i++) {
			String[] line = buffer.readLine().split(" ");
			int operation = Integer.parseInt(line[0]);
			switch (operation) {
			case 1:
				int value = Integer.parseInt(line[1]);
				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
				stack1.push(value);
				while (!stack2.isEmpty()) {
					stack1.push(stack2.pop());
				}
				break;
			case 2:
				stack1.pop();
				break;
			case 3:
				System.out.println(stack1.peek());
				break;
			}
		}
		buffer.close();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader buffer1 = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader buffer = new BufferedReader(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));

		// solution1(buffer);
		solution2(buffer);

	}
}
