import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SubArraySum {

	public static long subarraySum(List<Integer> arr) {
		// Write your code here

		int sum = 0;
		for(int i=0;i<arr.size();i++){
			sum+=arr.get(i)*(i+1)*(arr.size()-i);
		}

		return sum;
	}
	public static void print(int i){
		System.out.println(i);
	}

	public static void main(String... args) throws IOException {
		
		byte b=0;
		print(b);
		// BufferedReader buffer = new BufferedReader(new
		// InputStreamReader(System.in));
		BufferedReader buffer = new BufferedReader(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));

		int n = Integer.parseInt(buffer.readLine());
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++)
			list.add(Integer.parseInt(buffer.readLine()));
		System.out.println(new SubArraySum().subarraySum(list));

	}

}
