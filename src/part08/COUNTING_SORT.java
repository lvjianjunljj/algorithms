package part08;

public class COUNTING_SORT {
	public static void main(String[] args) {
		int[] a ={16,9,10,1,1,9,9,9,8,8,1,4,6,8,8,9,12,14,19,12,16};
		int[] b = counting_sort(a,19);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
	
	protected static int[] counting_sort(int[] a,int k){
		int[] b = new int[a.length];
		int[] c = new int[k+1];
		for (int i = 0; i < k+1; i++) {
			c[i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			c[a[i]] = c[a[i]] + 1;
		}
		for (int i = 1; i < k+1; i++) {
			c[i] = c[i]+c[i-1];
		}
		for (int i = a.length; i > 0; i--) {
			b[c[a[i-1]]-1] = a[i-1];
			c[a[i-1]] = c[a[i-1]]-1;
		}
		/*这样写输出的排序结果是完全一样的，但是不稳定的——稳定的是指具有相同值的元素在输出数组中的相对次序与它们在输入数组中的相对次序相同
		for (int i = 0; i < a.length; i++) {
			b[c[a[i]]-1] = a[i];
			c[a[i]] = c[a[i]]-1;
		}
		*/
		return b;
	}
}
