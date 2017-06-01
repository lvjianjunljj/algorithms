package part15.section4;

import java.util.Arrays;
/**
 * 自己写的求最长递增子序列
 *先将子序列复制出来以后进行排序，然后再求两个序列的最长公共子序列
 */
public class _Homework15_4_5_self {
	public static void main(String[] args) {
		int[] x = { 2, 3, 5, 4, 5, 6, 7, 8, 9, 0, 11 };
		int[][] b = lcs_length(x);
		System.out.print("最长单调递增子序列为：\t");
		print_lcs(b, x, x.length, x.length);

	}

	protected static int[][] lcs_length(int[] x) {
		// 这里不能用int[] y = x;这样y其实指向的还是x，对y进行排序实际上就是对x进行了排序
		int[] y = Arrays.copyOf(x, x.length);
		Arrays.sort(y);
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
			}
		}
		System.out.println("最长单调递增子序列的长度为：" + c[m][n]);
		return b;
	}

	protected static void print_lcs(int[][] b, int[] x, int i, int j) {
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
