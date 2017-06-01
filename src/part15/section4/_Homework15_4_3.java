package part15.section4;

public class _Homework15_4_3 {
	public static void main(String[] args) {
		String[] x = { "q", "w", "e", "r", "t", "y", "u", "i", "o", "p" };
		String[] y = { "q", "e", "r", "t", "y", "i", "p", "o" };
		int[][] b = lcs_length(x, y);
		System.out.print("最长公共子序列为：");
		print_lcs(b, x, x.length, y.length);

	}

	protected static int[][] lcs_length(String[] x, String[] y) {
		int m = x.length;
		int n = y.length;
		int[][] b = new int[m][n];
		int[][] c = new int[m + 1][n + 1];
		/*这种初始化是没有必要的，因为new出来的数组的各个初始值就是0
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				c[i][j] = 0;
			}
		}
		*/
		int result = lcs_length_aux(x, y, m, n, c, b);
		System.out.println("最长公共子序列的长度为：" + result);
		return b;
	}

	protected static int lcs_length_aux(String[] x, String[] y, int i, int j,
			int[][] c, int[][] b) {
		if (i == 0 || j == 0) {
			return 0;
		}
		if (c[i][j] > 0) {
			return c[i][j];
		}
		if (x[i - 1] == y[j - 1]) {
			c[i][j] = lcs_length_aux(x, y, i - 1, j - 1, c, b) + 1;
			// 用2表示左上
			b[i - 1][j - 1] = 2;
		} else if (lcs_length_aux(x, y, i, j - 1, c, b) > lcs_length_aux(x, y,
				i - 1, j, c, b)) {
			c[i][j] = lcs_length_aux(x, y, i, j - 1, c, b);
			// 用1表示左
			b[i - 1][j - 1] = 1;
		} else {
			c[i][j] = lcs_length_aux(x, y, i - 1, j, c, b);
			// 用0表示上
			b[i - 1][j - 1] = 0;
		}
		return c[i][j];
	}

	protected static void print_lcs(int[][] b, String[] x, int i, int j) {
		if (i == 0 || j == 0) {
			return;
		}
		if (b[i - 1][j - 1] == 2) {
			print_lcs(b, x, i - 1, j - 1);
			System.out.print(x[i - 1] + "\t");
		} else if (b[i - 1][j - 1] == 1) {
			print_lcs(b, x, i, j - 1);
		} else {
			print_lcs(b, x, i - 1, j);
		}
	}
}
