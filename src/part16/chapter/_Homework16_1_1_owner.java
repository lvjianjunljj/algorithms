package part16.chapter;

import java.util.ArrayList;

public class _Homework16_1_1_owner {
	public static void main(String[] args) {
		int[] s = { 1, 3, 1, 4, 5, 6, 7, 8, 1 };
		int[] f = { 2, 4, 4, 5, 6, 7, 8, 9, 10 };
		int result = activity_select(s, f);
		System.out.println(result);
		System.out.println(exist_activity(s, f, 8, 9));
	}

	protected static int activity_select(int[] s, int[] f) {
		int n = f.length;
		int[][] c = new int[n][n];
		activity_select_aux(c, s, f, 1, n);
		return c[0][n - 1];
	}

	protected static int activity_select_aux(int[][] c, int[] s, int[] f,
			int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (c[i - 1][j - 1] > 0) {
			return c[i - 1][j - 1];
		}
		// 这里对Sij为不为空的判断很难进行，个人以为需要重新写一个方法了
		if (!exist_activity(s, f, i, j)) {
			return 0;
		}
		int tran = Integer.MIN_VALUE;
		for (int k = i; k <= j; k++) {
			int com = activity_select_aux(c, s, f, i, k - 1)
					+ activity_select_aux(c, s, f, k + 1, j) + 1;
			if (tran < com) {
				tran = com;
			}
		}
		c[i - 1][j - 1] = tran;
		return c[i - 1][j - 1];
	}

	protected static boolean exist_activity(int[] s, int[] f, int i, int j) {
		for (int k = i; k < j + 1; k++) {
			if (f[i - 1] <= s[k - 1]) {
				return true;
			}
		}
		return false;
	}
}
