package part06;

public class BUILD_MAX_HEAP {
	public static void main(String[] args) {
		int[] a ={5,11,7,2,3,17};
		build_max_heap(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	protected static void build_max_heap(int[] a) {
		for (int i = a.length/2; i > 0; i--) {
			max_heapify(a, i);
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
