package part06;

import java.util.ArrayList;

public class MAX_HEAPIFY_D {
	final static int d =4;
	public static void main(String[] args) {
		int[] a ={1,14,10,14,7,9,12,11,8,12};
		max_heapify_d(a, 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	protected static void max_heapify_d(int[] a,int i){
		int largest = i;
		ArrayList<Integer> child = child(i);
		if(child.get(0) <= a.length){
			if(child.get(d-1)<=a.length){
				for (int j = 0; j < d; j++) {
					if (a[largest-1]<a[child.get(j)-1]) {
						largest = child.get(j);
					}
				}
			}else{
				for (int j = child.get(0)-1; j < a.length; j++) {
					if (a[largest-1]<a[j]) {
						largest = j+1;
					}
				}
			}
		}
		if(largest != i){
			int tran = a[i-1];
			a[i-1] = a[largest-1];
			a[largest-1] = tran;
			max_heapify_d(a, largest);
		}
	}
	
	protected static int parent(int i){
		return (i+d-2)/d;
	}
	protected static ArrayList<Integer> child(int i){
		ArrayList<Integer> child = new ArrayList();
		for (int j = 0; j < d; j++) {
			child.add(d*i+j+2-d);
		}
		return child;
	}
}
