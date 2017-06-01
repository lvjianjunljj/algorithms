package part15.section4;

public class LCS_LENGTH {
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
		for (int i = 0; i < m + 1; i++) {
			c[i][0] = 0;
		}
		for (int i = 1; i < n + 1; i++) {
			c[0][i] = 0;
		}
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (x[i - 1] == y[j - 1]) {
					c[i][j] = c[i - 1][j - 1] + 1;
					// 用2表示左上
					b[i - 1][j - 1] = 2;
				} else if (c[i - 1][j] < c[i][j - 1]) {
					c[i][j] = c[i][j - 1];
					// 用1表示左
					b[i - 1][j - 1] = 1;
				} else {
					c[i][j] = c[i - 1][j];
					// 用0表示上
					b[i - 1][j - 1] = 0;
				}
				/**注意：这里对c[i - 1][j] 和 c[i][j - 1]的比较中，
				 * 将相等的情况划给上面或者下面处理有可能会得出不一样的结果（个人亲测确实如此）
				 * 因为公共最长子序列不一定只有一个解
				 * 个人还想不到有什么办法可以得到所有的公共最长子序列
				 * 因为每一步相等情况的划分都可能导致最长公共子序列的不同*/
			}
		}
		System.out.println("最长公共子序列的长度为：" + c[m][n]);
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
