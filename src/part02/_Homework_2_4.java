package part02;

import java.util.ArrayList;
import java.util.Arrays;
//归并排序实现
public class _Homework_2_4 {
	public static void main(String[] args) {
		int[] a = {2,8,10,29,1,3,4,49};
		System.out.println(method(a,1,8));
	}
	
	protected static int method(int[] a,int p,int q){
		int s= 0;
		int l = q-p+1;
		if(l > 2){
			method(a,p,(p+q)/2);
			method(a,(p+q)/2+1,q);
			s += merge(a, p, (p+q)/2, q);
		}
		return s;
	}
	
	
	protected static int merge(int[] a, int p, int q, int r) {
		int s = 0;
		int[] b = Arrays.copyOfRange(a, p - 1, q+1);
		int[] c = Arrays.copyOfRange(a, q, r+1);
		int n = r - p + 1;
		int n1 = q - p + 1;
		int n2 = r - q;
		b[n1] = Integer.MAX_VALUE;
		c[n2] = Integer.MAX_VALUE;
		int j = 0, k = 0;
		for (int i = 0; i < n; i++) {
			if (b[j] <= c[k]) {
				a[p + i - 1] = b[j];
				j++;
			} else {
				a[p + i - 1] = c[k];
				k++;
				if (b[j] != Integer.MAX_VALUE) {
					s += (n1-j);
				}
			}
		}

		return s;
	}
}
