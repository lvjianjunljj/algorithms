package part02;

import java.util.ArrayList;

public class _Homework2_3_5 {
	public static void main(String[] args) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		int[] array = {1,9,11,15,21,24,31,35,39,44,47};
		System.out.println(index(array, 0, 10, 0));
	}
	
	protected static Object index(int[] array,int p,int q,int x) {
		while(p < q){
			if(x == array[(int)((p+q)/2)]){
				return (int)((p+q)/2);
			}else if(x == array[(int)((p+q)/2)+1]){
				return (int)(Math.ceil((p+q)/2)+1);
			} 
			if(x < array[(int)((p+q)/2)+1]){
				q = (int) ((p+q)/2);
			}
			if (x > array[(int)((p+q)/2)]) {
				p = (int) (Math.ceil((p+q)/2)+1);
			}
		}
		return null;
	}
}
