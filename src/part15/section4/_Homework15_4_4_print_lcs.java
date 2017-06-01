package part15.section4;

/**
 * 这里也可以求得最长公共序列
 * 每一次的计算c[i][j]只与c[i-1][j]、c[i][j-1]、c[i-1][j-1]有关，所以只保留第i行和第i-1行
 */
public class _Homework15_4_4_print_lcs {
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
		int[][] c = new int[2][n + 1];
		int[][] b = new int[m][n];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (x[i - 1] == y[j - 1]) {
					c[i%2][j] = c[(i - 1)%2][j - 1] + 1;
					// 用2表示左上
					b[i - 1][j - 1] = 2;
				} else if (c[(i - 1)%2][j] < c[i%2][j - 1]) {
					c[i%2][j] = c[i%2][j - 1];
					// 用1表示左
					b[i - 1][j - 1] = 1;
				} else {
					c[i%2][j] = c[(i - 1)%2][j];
					// 用0表示上
					b[i - 1][j - 1] = 0;
				}

			}
		}
		System.out.println("最长公共子序列的长度为：" + c[m%2][n]);
		return b;
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
