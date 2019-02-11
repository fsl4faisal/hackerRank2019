import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

/*
 * 
 * 
 * 
 * 
https://www.hackerrank.com/challenges/picking-numbers/problem

6
4 6 5 3 3 1

 */

public class PickingNumbers {

	public static void main(String[] args) throws IOException {

		BufferedReader buffer = new BufferedReader(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));
		// BufferedReader buffer = new BufferedReader(new
		// InputStreamReader(System.in));

		int N = Integer.parseInt(buffer.readLine());
		int[] arr = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		int[] numbers = new int[100];

		for (int i = 0; i < arr.length; i++) {
			numbers[arr[i]]++;
		}
		int globalMax = 0;
		for (int i = 0; i < 99; i++) {
			if (numbers[i] + numbers[i + 1] > globalMax)
				globalMax = numbers[i] + numbers[i + 1];
		}
		System.out.println(globalMax);

	}
}
