package part15.section1;

import java.util.ArrayList;

public class EXTENDED_MEMOIZED_CUT_ROD_Homework15_1_4 {
	public static void main(String[] args) {
		int[] p = { 10, 1, 10, 10, 10, 10, 10, 10, 100, 10, 100, 100, 10,
				10, 10, 10, 10, 10, 100, 10, 100, 1000, 10, 10, 10, 10, 10, 10,
				1000, 10 };
		ArrayList q = extended_memoized_cut_rod(p, 30);
		System.out.println("切割结果是：");
		for (int i = 0; i < q.size()-1; i++) {
			System.out.print(q.get(i)+"\t");
		}
		System.out.println();
		System.out.println("切割收益是：");
		System.out.println(q.get(q.size()-1));
	}

	protected static ArrayList extended_memoized_cut_rod(int[] p, int n) {
		int[] s = new int[n + 1];
		for (int i = 0; i < s.length; i++) {
			s[i] = 0;
		}
		int[] r = new int[n + 1];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		int q = extended_memoized_cut_rod_aux(p, n, r, s);
		ArrayList result = new ArrayList();
		int m = s.length - 1;
		while (m > 0) {
			result.add(s[m]);
			m = m - s[m];
		}
		result.add(q);
		return result;
	}

	protected static int extended_memoized_cut_rod_aux(int[] p, int n, int[] r,
			int[] s) {
		if (r[n] >= 0) {
			return r[n];
		}
		if (n == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;
		for (int i = 1; i < n + 1; i++) {
			if (q < p[i - 1] + extended_memoized_cut_rod_aux(p, n - i, r, s)) {
				q = p[i - 1] + extended_memoized_cut_rod_aux(p, n - i, r, s);
				s[n] = i;
			}
		}
		r[n] = q;
		return r[n];
	}
}
