package part09;

import java.util.Random;
/*要改善最坏情况的下运行时间，就要从划分入手，保证即使是最坏情况，也要尽量均衡地划分。
 * 因此，使用SELECT找到中值，再以这个中值为主元进行划分
 */
public class _Homework9_3_3 {
	public static void main(String[] args) {
		int[] a = { 16, 9, 10, 1, 1, 9, 9, 9, 8, 8, 1, 4, 6, 8, 8, 9, 12, 14,
				19, 12, 16, 0 };
		quicksort(a,1,a.length);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	protected static void quicksort(int[] a, int p, int r) {
		if (p < r) {
			int i = (r - p + 1) / 2;
			int f = randomized_select(a, p, r, i);
			int q = partition_median(a, p, r, f);
			quicksort(a, p, q - 1);
			quicksort(a, q + 1, r);
		}
	}

	protected static int randomized_select(int[] a, int p, int r, int i) {
		if (p == r) {
			return a[p - 1];
		}
		int q = partition(a, p, r);
		int k = q - p + 1;
		if (i == k) {
			return a[q - 1];
		} else if (i < k) {
			return randomized_select(a, p, q - 1, i);
		} else {
			return randomized_select(a, q + 1, r, i - k);
		}

	}

	// 以f为主元的划分
	protected static int partition_median(int[] a, int p, int r, int f) {
		for (int i = p; i < r; i++) {
			if (a[i] == f) {
				int tran = a[i-1];
				a[i-1] = a[r-1];
				a[r-1] = tran;
				break;
			}
		}
		return partition(a, p, r);
	}

	protected static int partition(int[] a, int p, int r) {
		int x = a[r - 1];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j - 1] <= x) {
				i++;
				int tran = a[i - 1];
				a[i - 1] = a[j - 1];
				a[j - 1] = tran;
			}
		}
		int tran = a[i];
		a[i] = a[r - 1];
		a[r - 1] = tran;
		return i + 1;
	}
}