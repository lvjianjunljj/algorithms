package part06;

public class HEAPSORT {
	public static void main(String[] args) {
		int[] a ={16,4,10,14,7,9,3,2,8,1,1,4,6,78,0,8};
		heapsort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	protected static void heapsort(int[] a){
		build_max_heap(a);
		int size = a.length;
		for (int i = a.length; i > 1; i--) {
			int tran = a[0];
			a[0] = a[i-1];
			a[i-1] = tran;
			size--;
			max_heapify(a, 1,size);
		}
	}
	
	protected static void build_max_heap(int[] a) {
		for (int i = a.length/2; i > 0; i--) {
			max_heapify(a, i,a.length);
		}
	}
	
	protected static void max_heapify(int[] a,int i,int size){
		int largest = 0;
		int l = left(i);
		int r = right(i);
		if(l <= size && a[l-1]>a[i-1]){
			largest = l;
		}else{ 
			largest = i;
		}
		if(r <= size && a[r-1]>a[largest-1]){
			largest = r;
		}
		if(largest != i){
			int tran = a[i-1];
			a[i-1] = a[largest-1];
			a[largest-1] = tran;
			max_heapify(a, largest,size);
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
