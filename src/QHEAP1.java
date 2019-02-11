import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 
 * 
 * 
5  
1 4  
1 9  
3  
2 4  
3  

 */
public class QHEAP1 {

	public static void add(List<Integer> list, int value) {

	}

	public static void remove(List<Integer> list, int index) {
		int temp = list.get(list.size() - 1);
		list.set(index, temp);
		list.remove(list.size() - 1);
		bubbleDown(list, index);

	}

	public static void bubbleDown(List<Integer> list, int index) {
		while ((getLeftChildIndex(list, index) > 0 && list.get(index) > list.get(getLeftChildIndex(list, index)))
				|| getRightChildIndex(list, index) > 0 && list.get(index) > list.get(getRightChildIndex(list, index))) {
			int leftChildValue = 0;
			if (getLeftChildIndex(list, index) > 0)
				leftChildValue = list.get(getLeftChildIndex(list, index));
			int rightChildValue = 0;
			if (getRightChildIndex(list, index) > 0)
				rightChildValue = list.get(getRightChildIndex(list, index));
			if (getLeftChildIndex(list, index) > 0 && getRightChildIndex(list, index) > 0
					&& leftChildValue < rightChildValue) {
				swap(list, getLeftChildIndex(list, index), index);
				index = getLeftChildIndex(list, index);
			} else if (getRightChildIndex(list, index) > 0) {
				swap(list, getRightChildIndex(list, index), index);
				index = getRightChildIndex(list, index);
			} else {
				swap(list, getLeftChildIndex(list, index), index);
				index = getLeftChildIndex(list, index);
			}
		}

	}

	public static void bubbleUp(List<Integer> list, int index) {
		// Single Element
		if (list.size() - 1 == 1)
			return;
		while (true) {
			if (index == 1)
				break;
			if (list.get(index) > list.get(getParentIndex(index)))
				break;
			if (list.get(index) < list.get(getParentIndex(index))) {
				swap(list, getParentIndex(index), index);
				index = getParentIndex(index);
			}
		}

	}

	public static void swap(List<Integer> list, int parentIndex, int index) {
		int temp = list.get(index);
		list.set(index, list.get(parentIndex));
		list.set(parentIndex, temp);
	}

	public static int find(List<Integer> list, int value) {
		for (int i = 1; i < list.size(); i++) {
			if (value == list.get(i))
				return i;
		}
		return 0;
	}

	public static int getParentIndex(int index) {
		return index / 2;
	}

	public static int getLeftChildIndex(List<Integer> list, int index) {
		if (2 * index < list.size())
			return 2 * index;
		return -1;
	}

	public static int getRightChildIndex(List<Integer> list, int index) {
		if (2 * index + 1 < list.size())
			return 2 * index + 1;
		return -1;
	}

	public static void print(List<Integer> list) {
		System.out.println();
		for (int i = 1; i < list.size(); i++)
			System.out.print(list.get(i) + "->");
		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader buffer = new BufferedReader(new FileReader("D:\\tryout-workspace\\HackerRank\\input.txt"));
		int Q = Integer.parseInt(buffer.readLine());
		ArrayList<Integer> minHeap = new ArrayList<>();
		minHeap.add(0);
		for (int i = 0; i < Q; i++) {
			String input = buffer.readLine();
			int operation = Integer.parseInt(input.split(" ")[0]);
			int value = 0;
			if (operation == 1 || operation == 2)
				value = Integer.parseInt(input.split(" ")[1]);
			if (operation == 3) {
				System.out.println(minHeap.get(1));
			}

			else if (operation == 1) {
				minHeap.add(value);
				bubbleUp(minHeap, minHeap.size() - 1);
			}

			else if (operation == 2) {
				int index = find(minHeap, value);
				remove(minHeap, index);
			}
			// print(minHeap);
		}
	}

}
