package part15.questions;

import java.util.ArrayList;

public class _Homework_15_2_lcs {
	public static void main(String[] args) {
		String value = "asdfghfda";
		ArrayList output = get_palindrome(value);
		System.out.print("最长回文子序列：");
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i));
		}
	}
	
	/**
	 * 这里我就不把arraylist再转成string，没有太大必要
	 * 可以调用arraylist的toString的方法，但是输出的是类似于[a,v,s,c,s,a,s]的形式，不是我想要的
	 */
	protected static ArrayList get_palindrome(String value) {
		char[] list = value.toCharArray();
		int len = list.length;
		char[] list_copy = new char[len];
		for (int i = 0; i < len; i++) {
			list_copy[i] = list[len - i - 1];
		}
		int[][] b = lcs_length(list, list_copy);
		ArrayList output = new ArrayList();
		print_lcs(b, list, list.length, list.length,output);
		return output;
	}

	protected static int[][] lcs_length(char[] x, char[] y) {
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
		System.out.println("最长回文子序列的长度为：" + c[m][n]);
		return b;
	}

	protected static void print_lcs(int[][] b, char[] x, int i, int j,
			ArrayList output) {
		if (i == 0 || j == 0) {
			return;
		}
		if (b[i - 1][j - 1] == 2) {
			print_lcs(b, x, i - 1, j - 1, output);
			output.add(x[i - 1]);
		} else if (b[i - 1][j - 1] == 1) {
			print_lcs(b, x, i, j - 1, output);
		} else {
			print_lcs(b, x, i - 1, j, output);
		}
	}
}
