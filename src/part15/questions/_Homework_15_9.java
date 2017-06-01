package part15.questions;

import java.util.ArrayList;

//切割点i表示在第i段之后切割，所以所有的切割点在1到n-1之间
public class _Homework_15_9 {
	public static void main(String[] args) {
		int[] p = { 1, 2, 8 };
		cutting_print(p, 10);
	}

	protected static void cutting_print(int[] p, int n) {
		int[][] w = new int[10][10];
		System.out.println("字符串拆分的最小代价为：" + cutting(p, w, 1, n));
	}

	// 我果然还是更熟悉这种带备忘录的自顶向下法
	protected static int cutting(int[] p, int[][] w, int i, int j) {
		if (i >= j) {
			return 0;
		}
		ArrayList<Integer> list = cutting_point_number(p, i, j);
		if (list.get(0) < 1) {
			w[i - 1][j - 1] = 0;
		} else if (list.get(0) == 1) {
			w[i - 1][j - 1] = j - i + 1;
		} else {
			int min = Integer.MAX_VALUE;
			for (int k = 1; k < list.size(); k++) {
				int compare = cutting(p, w, i, list.get(k) - 1)
						+ cutting(p, w, list.get(k) + 1, j) + j - i + 1;
				if (min > compare) {
					min = compare;
				}
			}
			w[i - 1][j - 1] = min;
		}
		return w[i - 1][j - 1];
	}

	/**
	 * 之前的错误是把带备忘录的自顶向下和自底向上混杂了（要注意）
	 * *protected static int cutting(int[] p, int n) {
		int[][] w = new int[n][n];
		for (int j = 2; j < n + 1; j++) {
			for (int i = 1; i < j; i++) {
				ArrayList<Integer> list = cutting_point_number(p, i, j);
				if (list.get(0) < 1) {
					w[i - 1][j - 1] = 0;
				} else if (list.get(0) == 1) {
					w[i - 1][j - 1] = j - i + 1;
				} else {
					int min = Integer.MAX_VALUE;
					for (int k = 1; k < list.size(); k++) {
						int compare = w[i - 1][list.get(k) - 2]
								+ w[list.get(k)][j - 1] + j - i + 1;
						if (min > compare) {
							min = compare;
						}
					}
					w[i - 1][j - 1] = min;
				}
			}
		}
		return w[0][n - 1];
	}
	 */
	protected static ArrayList<Integer> cutting_point_number(int[] p, int i,
			int j) {
		int number = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for (int k = 0; k < p.length; k++) {
			// 切割点i表示在第i段之后切割，所以切割点j不在i和j之间
			if (i <= p[k] && p[k] < j) {
				number++;
				list.set(0, number);
				list.add(p[k]);
			}
		}
		return list;
	}
}
