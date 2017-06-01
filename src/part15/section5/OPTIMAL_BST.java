package part15.section5;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class OPTIMAL_BST {
	public static void main(String[] args) {
		double[] p = { 0.2, 0.2, 0.1, 0.1, 0.1 };
		double[] q = { 0.1, 0.05, 0.1, 0.05, 0.05, 0.05 };
		double result = optimal_bst(p, q);
		// 取三两位数
		DecimalFormat df = new DecimalFormat("######0.000");
		System.out.println("T中搜索代价期望为：" + df.format(result));

	}

	protected static double optimal_bst(double[] p, double[] q) {
		int n = p.length;
		int[][] root = new int[n][n];
		double[][] e = optimal_bst_aux(p, q, root, n);
		return e[0][n];
	}

	protected static double[][] optimal_bst_aux(double[] p, double[] q,
			int[][] root, int n) {
		// 其中e和w的下标应该是[1~n+1][0~n]
		double[][] e = new double[n + 1][n + 1];
		double[][] w = new double[n + 1][n + 1];
		for (int i = 0; i < n + 1; i++) {
			e[i][i] = q[i];
			w[i][i] = q[i];
		}
		for (int l = 1; l < n + 1; l++) {
			for (int i = 1; i < n - l + 2; i++) {
				int j = i + l - 1;
				e[i - 1][j] = Integer.MAX_VALUE;
				w[i - 1][j] = w[i - 1][j - 1] + p[i - 1] + q[j];
				for (int r = i; r < j + 1; r++) {
					double t = e[i - 1][r - 1] + e[r][j] + w[i - 1][j];
					if (t < e[i - 1][j]) {
						e[i - 1][j] = t;
						root[i - 1][j - 1] = r;
					}
				}
			}
		}
		return e;
	}
}
