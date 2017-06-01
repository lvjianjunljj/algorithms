package part07;

//老子并不理解这样的优化可以保持nlgn的期望时间复杂度
public class _Homework7_4_c {
	public static void main(String[] args) {
		int[] a = { 16, 9, 10, 1, 1, 9, 9, 9, 8, 8, 1, 4, 6, 78, 8, 79 };
		tail_recursive_quicksort(a, 1, 16);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	protected static void tail_recursive_quicksort(int[] a, int p, int r) {
		// 注意这里是while循环而不仅仅是if判断
		while (p < r) {
			int q = partition(a, p, r);
			if (r - q > q - p) {
				tail_recursive_quicksort(a, p, q - 1);
				p = q + 1;
			} else {
				tail_recursive_quicksort(a, q + 1, r);
				r = q - 1;
			}
		}
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
