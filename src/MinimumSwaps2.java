import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSwaps2 {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int swaps = 0;
		for (int i = 0; i < arr.length; i++) {
			int minIndex = findMinIndex(arr, i);
			if (i != minIndex) {
				int temp = arr[i];
				arr[i] = arr[minIndex];
				arr[minIndex] = temp;
				swaps++;
			}
		}
		return swaps;

	}

	static int findMinIndex(int[] arr, int index) {
		int min=Integer.MAX_VALUE;
		int minIndex=-1;
		for(int i=index;i<arr.length;i++){
			if(arr[i]<min){
				minIndex=i;
				min=arr[i];
			}
				
		}
		return minIndex;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		String list = "7 1 3 2 4 5 6";
		list="1 3 5 2 4 6 7";
		int[] arr = Arrays.asList(list.split(" ")).stream().mapToInt(Integer::parseInt).toArray();
		int res = minimumSwaps(arr);
		System.out.println(res);

	}
}
