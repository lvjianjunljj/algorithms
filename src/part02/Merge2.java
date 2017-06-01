package part02;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge2 {
	public static void main(String[] args) {
		int[] a = { 1, 8, 10,21 ,4,9,15,22,23,26};
		for(int i = 0;i<10;i++){
			System.out.println(merge(a, 1, 4, 10)[i]);
		}
	}

	protected static int[] merge(int[] a, int p, int q, int r) {
		int[] b = Arrays.copyOfRange(a, p - 1, q);
		int[] c = Arrays.copyOfRange(a, q, r);
		int n = r - p + 1;
		int n1 = q - p + 1;
		int n2 = r - q;
		int j = 0, k = 0;
		for (int i = 0; i < n; i++) {
			if(j==n1){
				a[p + i - 1] = c[k];
				k++;
			}else if(k==n2){
				a[p + i - 1] = b[j];
				j++;
			}else if (b[j] < c[k]) {
				a[p + i - 1] = b[j];
				j++;
			} else {
				a[p + i - 1] = c[k];
				k++;
			}
		}

		return a;
	}
}
