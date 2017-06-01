package part02;

import java.util.ArrayList;

public class InsertionSort {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int[] array = {1,9,11,7,4,1,8,4,11,3,45,6,12,45,555,12,321,5767,24232,12};
		for (int j = 0; j < array.length; j++) {
			arrayList.add(array[j]);
		}
		for (int i = 1; i < arrayList.size(); i++) {
			Integer key = arrayList.get(i);
			while (i > 0 && key < arrayList.get(i-1)) {
				arrayList.set(i, arrayList.get(i-1));
				arrayList.set(i-1,key);
				i--;
			}
		}
		for (int n = 0; n < arrayList.size(); n++) {
			System.out.println(arrayList.get(n));
		}
	}
}
