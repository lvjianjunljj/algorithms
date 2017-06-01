package part02;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;

public class _Homework2_1_3 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int[] array = {1,9,11,7,4,1,8,4,11,3,45,6,12,45,555,12,321,5767,24232,12};
		for (int j = 0; j < array.length; j++) {
			arrayList.add(array[j]);
		}
		int v = 11;
		System.out.println(method(arrayList,v));
	}
	
	private static Object method(ArrayList<Integer> arrayList ,int v){
		Object key = null ;
		for (int i = 0; i < arrayList.size(); i++) {
			if(arrayList.get(i).equals(v))
			{
				key = i+1;
				break;
			}else{
				key = null;
			}
		}
		return key;
	}
}
