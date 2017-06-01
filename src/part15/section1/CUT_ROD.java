package part15.section1;

public class CUT_ROD {
	public static void main(String[] args) {
		int[] p = { 100, 1000, 10, 10, 10, 10, 10, 10, 1000, 10, 100, 1000, 10,
				10, 10, 10, 10, 10, 1000, 10,100, 1000, 10, 10, 10, 10, 10, 10, 1000, 10 };
		int q = cut_rod(p, 30);
		System.out.println(q);
	}

	protected static int cut_rod(int[] p, int n) {
		if (n == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			q = Math.max(q, p[i - 1] + cut_rod(p, n - i));
		}
		return q;
	}
}
