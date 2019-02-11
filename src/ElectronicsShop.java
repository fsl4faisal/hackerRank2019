import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ElectronicsShop {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));
		String[] vars = bufferedReader.readLine().split(" ");
		int b = Integer.parseInt(vars[0]);
		int n = Integer.parseInt(vars[1]);
		int m = Integer.parseInt(vars[2]);

		int[] keyboards = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] drives = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// Integer[] keyboards = Arrays
		// .stream(Arrays.stream(bufferedReader.readLine().split("
		// ")).mapToInt(Integer::parseInt).toArray())
		// .boxed().toArray(Integer[]::new);
		// Integer[] drives = Arrays
		// .stream(Arrays.stream(bufferedReader.readLine().split("
		// ")).mapToInt(Integer::parseInt).toArray())
		// .boxed().toArray(Integer[]::new);

		int maxSum = -1;
		for (int i = 0; i < keyboards.length; i++) {
			for (int j = 0; j < drives.length; j++) {
				int sum = keyboards[i] + drives[j];
				if (sum <= b && sum > maxSum)
					maxSum = sum;
			}
		}

		System.out.println(maxSum);

	}
}
