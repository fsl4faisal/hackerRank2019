import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 * 
 * https://www.hackerrank.com/challenges/simple-text-editor/problem

8
1 abc
3 3
2 3
1 xy
3 2
4 
4 
3 1

 */
public class SimpleTextEditor {

	public static void main(String[] args) throws IOException {
		InputStreamReader inr = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));
		String str = "";

		int Q = Integer.parseInt(buffer.readLine());
		Stack<String> stack = new Stack<>();
		stack.push("");
		String[] line;
		for (int i = 0; i < Q; i++) {
			line = buffer.readLine().split(" ");
			switch (line[0]) {
			case "1":
				str = append(str, line[1], stack);
				break;
			case "2":
				str = delete(str, Integer.parseInt(line[1]), stack);
				break;
			case "3":
				print(str, Integer.parseInt(line[1]));
				break;
			case "4":
				str = undo(stack);
				break;

			}
		}

	}

	public static String undo(Stack<String> stack) {
		stack.pop();
		return stack.peek();
	}

	public static void print(String str, int k) {
		System.out.println(str.charAt(k - 1));
	}

	public static String delete(String str, int k, Stack<String> stack) {
		str = str.substring(0, str.length() - k);
		stack.push(str);
		return str;
	}

	public static String append(String str, String w, Stack<String> stack) {
		str = str + w;
		stack.push(str);
		return str;
	}
}
