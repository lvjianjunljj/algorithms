package part07;

import java.util.Random;

public class QUICKSORT_RANDOMIZED {
	public static void main(String[] args) {
		int[] a ={16,4,10,14,7,9,3,2,8,1,1,4,6,78,0,8,11};
		quicksort_randomized(a, 1, 17);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	protected static void quicksort_randomized(int[] a,int p,int r){
		if(p<r){
			int q = partition_randomized(a, p, r);
			quicksort_randomized(a, p, q-1);
			quicksort_randomized(a, q+1, r);
		}
	}
	
	protected static int partition_randomized(int[] a,int p,int r){
		Random ra = new Random();
		//获得p到r的一个随机整数
		int i = p+ra.nextInt(r-p+1);
		int tran = a[i-1];
		a[i-1] = a[r-1];
		a[r-1] = tran;
		return partition(a, p, r);
	}
	
	protected static int partition(int[] a,int p,int r){
		int x = a[r-1];
		int i = p-1;
		for (int j = p; j < r; j++) {
			if (a[j-1]<=x) {
				i++;
				int tran = a[i-1];
				a[i-1] = a[j-1];
				a[j-1] = tran;
			}
		}
		int tran = a[i];
		a[i] = a[r-1];
		a[r-1] = tran;
		return i+1;
	}
}
