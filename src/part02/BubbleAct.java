package part02;

import java.util.ArrayList;
import java.util.Scanner;
//冒泡法排序
public class BubbleAct {
	public static void main(String[] args) {
		/*这里的问题一直没有解决，用了next方法以后会一直输入而不是在enter以后就会停止输入
		Scanner content = new Scanner(System.in);
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int i = 0;
		while(content.hasNext()) {
			arrayList.add(Integer.parseInt(content.next()));
			i += 1;
		}		
	*/
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int[] array = {1,2,3,45,6,12,45,555,12,321,5767,24232,12};
		for (int j = 0; j < array.length; j++) {
			arrayList.add(array[j]);
		}
		for (int j = 1; j < arrayList.size(); j++) {
			for (int k = j-1; k > -1; k--) {
				if(arrayList.get(k) > arrayList.get(k+1)){
					Integer value = arrayList.get(k);
					arrayList.set(k, arrayList.get(k+1));
					arrayList.set(k+1, value);
				}
			}
		}
		for (int n = 0; n < arrayList.size(); n++) {
			System.out.println(arrayList.get(n));
		}
	}
}
