package package2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class test {
	public static LinkedList<Integer> list = new LinkedList<>(Arrays.asList(0, 0, 0, 0));

	public static void main(String[] args) {
		List<Integer> inputList = new ArrayList<>();
		inputList.add(1);
		inputList.add(2);
		inputList.add(3);
		inputList.add(4);
		inputList.add(3);
		inputList.add(1);
		inputList.add(4);

		for (int input : inputList) {
			addElementsToList(input);
			System.out.print("List content after adding " + input	+ " is:");
			for (int a : list) {
				System.out.print(a);
			}
			System.out.println("\n");
		}
	}

	private static void addElementsToList(int input) {
		if (checkElementExists(input)) {
			int index = list.indexOf(input);
			list.remove(index);
			list.addFirst(input);
		} else {
			list.addFirst(input);
			list.removeLast();
		}
	}

	private static boolean checkElementExists(int input) {
		for (int i : list) {
			if (i == input) {
				return true;
			}
		}
		return false;
	}

}
