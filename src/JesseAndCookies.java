import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

/*
 * 
 * https://www.hackerrank.com/challenges/jesse-and-cookies/problem
 * 

6(N) 7(K)
1 2 3 9 10 12


 */
public class JesseAndCookies {

	public static void main(String[] args) throws IOException {
		BufferedReader buffer = new BufferedReader(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));

		String[] line = buffer.readLine().split(" ");
		int N = Integer.parseInt(line[0]);
		int K = Integer.parseInt(line[1]);
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		line = buffer.readLine().split(" ");
		for (int i = 0; i < N; i++)
			queue.add(Integer.parseInt(line[i]));

		int operation = 0;
		while (queue.peek() < K && queue.size() >= 2) {
			int i = queue.poll();
			int j = queue.poll();
			int mix = i + (2 * j);
			queue.add(mix);
			operation++;
		}
		if (queue.peek() >= K)
			System.out.println(operation);
		else
			System.out.println("-1");
	}
}
