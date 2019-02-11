import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DistinctPairs {

	public static int numberOfPairs(List<Integer> a, long k) {
		// Write your code here
		Set<Integer> set = new HashSet<>();
		for (int i : a)
			set.add(i);
		int counter = 0;
		for (int i = 0; i < a.size(); i++) {
			int temp = (int)k - a.get(i);
			if (set.contains(temp)){
				counter++;
				set.remove(temp);
				set.remove(a.get(i));
			}
				
		}
		return counter;

	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList();

//		String[] str = "1 2 3 6 7 8 9 1".split(" ");
		String[] str = "6 12 3 9 3 5 1".split(" ");//
		for (int i = 0; i < str.length; i++) {
			list.add(Integer.parseInt(str[i]));
		}

		System.out.println(new DistinctPairs().numberOfPairs(list, 12));
	}
}
