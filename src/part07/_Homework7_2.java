package part07;

public class _Homework7_2 {
	public static void main(String[] args) {
		int[] a ={16,9,10,1,1,7,9,9,8,8,1,4,78,78,7,7};
		quicksort_s(a, 1, 16);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	protected static void quicksort_s(int[] a,int p,int r){
		if(p<r){
			int[] q = partition_s(a, p, r);
			quicksort_s(a, p, q[0]-1);
			quicksort_s(a, q[1]+1, r);
		}
	}
	
	protected static int[] partition_s(int[] a,int p,int r){
		int x = a[r-1];
		int i = p-1;
		int k = 0;
		for (int j = p; j < r; j++) {
			if (a[j-1]<x) {
				i++;
				int tran = a[j-1];
				a[j-1] = a[i+k-1];
				a[i+k-1] = a[i-1];
				a[i-1] = tran;
			}else if(a[j-1]==x){
				k++;
				int tran = a[j-1];
				a[j-1] = a[i+k-1];
				a[i+k-1] = tran;
			}
		}
		int tran = a[i+k];
		a[i+k] = a[r-1];
		a[r-1] = tran;
		
		int[] result = {i+1,i+k+1};
		return result;
	}
	
	
}

