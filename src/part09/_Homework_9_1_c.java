package part09;

import java.util.Random;
public class _Homework_9_1_c {
	public static void main(String[] args) {
		int[] a = new int[20];
		Random ra = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = ra.nextInt(100);
		}
		print(a, a.length);
		method(a, 10);
		System.out.println();
		print(a, a.length);
	}
	protected static void method(int[] a,int i){
		int x = select(a, 1, a.length, i);
		partition_median(a, 1, a.length, x);
		quicksort(a, 1, i);
	}

	protected static void quicksort(int[] a, int p, int r) {
		if (p < r) {
			int i = (r - p + 1) / 2;
			int f = select(a, p, r, i);
			int q = partition_median(a, p, r, f);
			quicksort(a, p, q - 1);
			quicksort(a, q + 1, r);
		}
	}
	
	//通过随机数实现选择
	protected static int select(int[] a, int p, int r, int i) {
		if (p == r) {
			return a[p - 1];
		}
		int q = partition(a, p, r);
		int k = q - p + 1;
		if (i == k) {
			return a[q - 1];
		} else if (i < k) {
			return select(a, p, q - 1, i);
		} else {
			return select(a, q + 1, r, i - k);
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
	
	protected static void print(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}