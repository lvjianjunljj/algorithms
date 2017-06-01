package part15.section4;

import java.util.ArrayList;

//不使用表b，利用完整的表c来重构LCS直接就在判断语句中加入一行存储数据的代码就行
public class _Homework15_4_2 {
	public static void main(String[] args) {
		String[] x = { "q", "w", "e", "r", "t", "y", "u", "i", "o", "p" };
		String[] y = { "q", "e", "r", "t", "i" };
		ArrayList<String> result = lcs_length(x, y);
		System.out.print("最长公共子序列为：");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "\t");
		}
	}

	protected static ArrayList<String> lcs_length(String[] x, String[] y) {
		ArrayList<String> result = new ArrayList<String>();
		int m = x.length;
		int n = y.length;
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
					result.add(x[i - 1]);
					c[i][j] = c[i - 1][j - 1] + 1;
				} else if (c[i - 1][j] < c[i][j - 1]) {
					c[i][j] = c[i][j - 1];
				} else {
					c[i][j] = c[i - 1][j];
				}

			}
		}
		System.out.println("最长公共子序列的长度为：" + c[m][n]);
		return result;
	}

}
