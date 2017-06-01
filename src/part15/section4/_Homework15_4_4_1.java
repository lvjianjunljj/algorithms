package part15.section4;

/**
 * 因为这里只需要求长度，而不需要求序列，可以只存储需要的内容。
 * 每一次的计算c[i][j]只与c[i-1][j]、c[i][j-1]、c[i-1][j-1]有关，所以只保留第i行和第i-1行
 */
public class _Homework15_4_4_1 {
	public static void main(String[] args) {
		String[] x = { "q", "w", "b", "r", "t", "y", "u", "i", "o", "p" };
		String[] y = { "a", "e", "r", "t", "y", "i", "p", "o", "o", "o", "o" };
		int result = lcs_length(x, y);
		System.out.print("最长公共子序列为：" + result);

	}

	protected static int lcs_length(String[] x, String[] y) {
		int m = x.length;
		int n = y.length;
		int[][] c = new int[2][n + 1];
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				if (x[i - 1] == y[j - 1]) {
					c[i % 2][j] = c[(i - 1) % 2][j - 1] + 1;
				} else if (c[(i - 1) % 2][j] < c[i % 2][j - 1]) {
					c[i % 2][j] = c[i % 2][j - 1];
				} else {
					c[i % 2][j] = c[(i - 1) % 2][j];
				}

			}
		}
		return c[m % 2][n];
	}

}
