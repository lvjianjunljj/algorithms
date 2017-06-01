package part15.section2;

public class MATRIX_CHAIN_ORDER {
	public static void main(String[] args) {
		int[] p = { 5, 10, 3, 12, 5, 50, 6 };
		matrix_chain_order(p);
	}

	protected static void matrix_chain_order(int[] p) {
		int n = p.length - 1;
		int[][] s = new int[n - 1][n - 1];
		int[][] m = matrix_chain_order_aux(p, s);
		System.out.print("最优括号化方案：");
		print_optimal_parens(s, 1, n);
		System.out.println();
		System.out.println("最优括号化方案的计算量：" + m[0][n - 1]);

	}

	protected static void print_optimal_parens(int[][] s, int i, int j) {
		if (i == j) {
			System.out.print("A" + i);
		} else {
			System.out.print("(");
			print_optimal_parens(s, i, s[i - 1][j - 2]);
			print_optimal_parens(s, s[i - 1][j - 2] + 1, j);
			System.out.print(")");
		}
	}

	// 因为java的方法无法输出两个二维数组，所以稍作改变，将一个输出s变为输入直接进行修改而不返回
	protected static int[][] matrix_chain_order_aux(int[] p, int[][] s) {
		int n = p.length - 1;
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			m[i][i] = 0;
		}
		// l是链的长度
		for (int l = 2; l < n + 1; l++) {
			for (int i = 1; i < n - l + 2; i++) {
				int j = i + l - 1;
				m[i - 1][j - 1] = Integer.MAX_VALUE;
				for (int k = i; k < j; k++) {
					int q = m[i - 1][k - 1] + m[k][j - 1] + p[i - 1] * p[k]
							* p[j];
					if (q < m[i - 1][j - 1]) {
						m[i - 1][j - 1] = q;
						s[i - 1][j - 2] = k;
					}
				}
			}
		}
		return m;
	}
}
