package part02;

import java.util.ArrayList;
import java.util.Arrays;

//归并排序实现
public class Guibing {
	public static void main(String[] args) {
		int[] a = { 1, 8, 10, 29, 4, 9, 15, 22 };
		method(a, 1, 8);
		for (int i = 0; i < 8; i++) {
			System.out.println(a[i]);
		}
	}

	protected static void method(int[] a, int p, int q) {
		int l = q - p + 1;
		if (l > 2) {
			method(a, p, (p + q) / 2);
			method(a, (p + q) / 2 + 1, q);
			merge(a, p, (p + q) / 2, q);
		}
	}

	/* 自愧不如啊，该方法可以排序个数非2的n次方的序列 */
	protected static void sort(int[] data, int left, int right) {
		// TODO Auto-generated method stub
		if (left < right) {
			// 找出中间索引
			int center = (left + right) / 2;
			// 对左边数组进行递归
			sort(data, left, center);
			// 对右边数组进行递归
			sort(data, center + 1, right);
			// 合并
			merge(data, left, center, right);
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
