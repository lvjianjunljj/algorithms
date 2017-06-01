package part07;

public class QUICKSORT {
	public static void main(String[] args) {
		int[] a = { 16, 9, 10, 1, 1, 9, 9, 9, 8, 8, 1, 4, 6, 78, 8, 79 };
		quicksort(a, 1, 16);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	protected static void quicksort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			quicksort(a, p, q - 1);
			quicksort(a, q + 1, r);
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
		a[r - 1] = a[i];
		a[i] = x;
		return i + 1;
	}
}
