package part02;

import java.util.ArrayList;

public class _Homework2_2_2 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int[] array = {1,9,11,7,4,1,8,4,11,3,45,6,12,45,555,12,321,5767,24232,12};
		for (int j = 0; j < array.length; j++) {
			arrayList.add(array[j]);
		}
		int min = Integer.MAX_VALUE;
		int min_index = 0;
		int key = 0;
		for (int i = 0; i < arrayList.size()-1; i++) {
			for (int j = arrayList.size(); j > i; j--) {
				if(arrayList.get(j-1) < min){
					min = arrayList.get(j-1);
					min_index = j-1;
				}
			}
			key = arrayList.get(i);
			arrayList.set(i, min);
			arrayList.set(min_index, key);
			min = Integer.MAX_VALUE;
		}
		
		for (int n = 0; n < arrayList.size(); n++) {
			System.out.println(arrayList.get(n));
		}
	}
}
