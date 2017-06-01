package part09;

import java.util.Random;

public class RANDOMIZED_SELECT {
	public static void main(String[] args) {
		int[] a = { 16, 4, 10, 14, 7, 9, 3, 2, 8, 1, 1, 4, 6, 78, 0, 8, 11 };
		System.out.println(randomized_select(a, 3, 17, 1));
	}

	protected static int randomized_select(int[] a, int p, int r, int i) {
		if (p == r) {
			return a[p-1];
		}
		int q = partition_randomized(a, p, r);
		int k = q - p + 1;
		if (i == k) {
			return a[q-1];
		} else if (i < k) {
			return randomized_select(a, p, q - 1, i);
		} else {
			return randomized_select(a, q + 1, r, i-k);
		}

	}

	protected static int partition_randomized(int[] a, int p, int r) {
		Random ra = new Random();
		// 获得p到r的一个随机整数
		int i = p + ra.nextInt(r - p + 1);
		int tran = a[i - 1];
		a[i - 1] = a[r - 1];
		a[r - 1] = tran;
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
