package part15.section1;

public class MEMOIZED_CUT_ROD {
	public static void main(String[] args) {
		int[] p = { 100, 1000, 10, 10, 10, 10, 10, 10, 1000, 10, 100, 1000, 10,
				10, 10, 10, 10, 10, 1000, 10,100, 1000, 10, 10, 10, 10, 10, 10, 1000, 10 };
		int q = memoized_cut_rod(p, 30);
		System.out.println(q);
	}
	
	protected static int memoized_cut_rod(int[] p, int n) {
		int[] r = new int[n + 1];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		return memoized_cut_rod_aux(p, n, r);
	}

	protected static int memoized_cut_rod_aux(int[] p, int n, int[] r) {
		if (r[n] >= 0) {
			return r[n];
		}
		if (n == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			q = Math.max(q, p[i - 1] + memoized_cut_rod_aux(p, n - i, r));
		}
		r[n] = q;
		return r[n];
	}
	
	//个人做的微小的改动，应该可以稍微降低一下计算步骤，但是时间复杂度不会降低，前面的系数可能会降低
//	protected static int memoized_cut_rod(int[] p, int n) {
//		int[] r = new int[n];
//		for (int i = 0; i < r.length; i++) {
//			r[i] = Integer.MIN_VALUE;
//		}
//		return memoized_cut_rod_aux(p, n, r);
//	}
//
//	protected static int memoized_cut_rod_aux(int[] p, int n, int[] r) {
//		if (n == 0) {
//			return 0;
//		}
//		if (r[n - 1] > 0) {
//			return r[n - 1];
//		}
//		int q = Integer.MIN_VALUE;
//		for (int i = 1; i < n + 1; i++) {
//			q = Math.max(q, p[i - 1] + memoized_cut_rod_aux(p, n - i, r));
//		}
//		r[n-1] = q;
//		return r[n-1];
//	}
}
