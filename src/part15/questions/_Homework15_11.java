package part15.questions;
//其实还需要考虑每一年一开始的本金，感觉难读自己没有估计好，暂时先放一放吧
public class _Homework15_11 {
	public static void main(String[] args) {
		int[][] r = { { 6, 4, 5, 6 }, { 7, 2, 3, 4 }, { 4, 4, 3, 1 } };
		int f1 = 5;
		int f2 = 10;
		System.out.println(max_invest(r, f1, f2));
	}

	protected static int max_invest(int[][] r, int f1, int f2) {
		int y = r.length;
		int[][] w = new int[y][y];
		return max_invest_aux(r, w, 1, y, f1, f2);
	}

	protected static int max_invest_aux(int[][] r, int[][] w, int i, int j,
			int f1, int f2) {
		if (i > j) {
			return 1;
		}
		if (i == j) {
			int pro = Integer.MIN_VALUE;
			for (int k = 0; k < r[0].length; k++) {
				if (pro < r[i - 1][k]) {
					pro = r[i - 1][k];
				}
			}
			w[i - 1][j - 1] = pro;
			return w[i - 1][j - 1];
		}
		if (i==j-1) {
			int pro = Integer.MIN_VALUE;
			for (int k = 0; k < r[0].length; k++) {
				if (pro < r[j - 1][k]) {
					pro = r[i - 1][k];
				}
			}
			w[i - 1][j - 1] = pro;
			return w[i - 1][j - 1];
		}
		int pro = Integer.MIN_VALUE;
		for (int k = i; k < j + 1; k++) {
			int com = max_invest_aux(r, w, i, k, f1, f2)
					* max_invest_aux(r, w, k + 1, j, f1, f2) - f2 + f1;
			if (pro < com) {
				pro = com;
			}
		}
		w[i - 1][j - 1] = pro;
		return w[i - 1][j - 1];
	}
}
