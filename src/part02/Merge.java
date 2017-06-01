package part02;

import java.util.ArrayList;
import java.util.Arrays;

public class Merge {
	public static void main(String[] args) {
		int[] a = { 1, 8, 10, 29, 4, 9, 15, 22, 23, 26 };
		for (int i = 0; i < 10; i++) {
			System.out.println(merge(a, 1, 4, 10)[i]);
		}
	}

	protected static int[] merge(int[] a, int p, int q, int r) {
		int[] b = Arrays.copyOfRange(a, p - 1, q + 1);
		int[] c = Arrays.copyOfRange(a, q, r + 1);
		int n = r - p + 1;
		int n1 = q - p + 1;
		int n2 = r - q;
		b[n1] = Integer.MAX_VALUE;
		c[n2] = Integer.MAX_VALUE;
		int j = 0, k = 0;
		for (int i = 0; i < n; i++) {
			if (b[j] < c[k]) {
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
