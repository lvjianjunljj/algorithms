package part06;

public class MAX_HEAPIFY {
	public static void main(String[] args) {
		int[] a ={16,4,10,14,7,9,3,2,8,1};
		max_heapify(a, 2);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	protected static void max_heapify(int[] a,int i){
		int largest = 0;
		int l = left(i);
		int r = right(i);
		if(l <= a.length && a[l-1]>a[i-1]){
			largest = l;
		}else{ 
			largest = i;
		}
		if(r <= a.length && a[r-1]>a[largest-1]){
			largest = r;
		}
		if(largest != i){
			int tran = a[i-1];
			a[i-1] = a[largest-1];
			a[largest-1] = tran;
			max_heapify(a, largest);
		}
	}
	
	protected static int parent(int i){
		return i/2;
	}
	protected static int left(int i){
		return 2*i;
	}
	protected static int right(int i){
		return i*2+1;
	}
}
