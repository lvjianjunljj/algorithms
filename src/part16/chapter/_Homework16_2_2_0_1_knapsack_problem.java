package part16.chapter;

import java.util.ArrayList;
/**
 * 这种思路是不对的，不能对w和v的数据值进行前后的拆分，只能是剃掉第k个以后再群居考虑
 *
 */
public class _Homework16_2_2_0_1_knapsack_problem {
	public static void main(String[] args) {
		int[] v = { 1, 1, 1, 1, 1, 1, 7 };
		int[] w = { 1, 2, 3, 4, 5, 6, 9 };
		int c = 10;
		System.out.println(knapsack(v, w, c));

	}

	protected static int knapsack(int[] v, int[] w, int c) {
		int n = v.length;
		int[][] result = new int[n][n];
		return knapsack_aux(result, v, w, 1, n, c);
	}

	// 我还是更习惯用带备忘录的自顶向下的动态规划方法，这种方法一定是有i和j两个界限的
	protected static int knapsack_aux(int[][] result, int[] v, int[] w, int i,
			int j, int c) {
		if (i > j) {
			return 0;
		}
		if (!contain(w, i, j, c)) {
			result[i - 1][j - 1] = 0;
			return 0;
		}
		if (result[i - 1][j - 1] > 0) {
			return result[i - 1][j - 1];
		}
		int value = Integer.MIN_VALUE;
		//代码逻辑的错误就在这里，不能对前后所沉受的重量都设置成c - w[k - 1]
		for (int k = i; k < j+1 ; k++) {
			int tran = knapsack_aux(result, v, w, i, k - 1, c - w[k - 1])
					+ knapsack_aux(result, v, w, k + 1, j, c - w[k - 1])
					+ v[k - 1];
			if (value < tran) {
				value = tran;
			}
		}
		result[i - 1][j - 1] = value;
		return result[i - 1][j - 1];
	}

	// 判断对于各个物品的重量和背包能承受的重量。背包是否还能装下任何物品
	protected static boolean contain(int[] w, int i, int j, int c) {
		for (int k = i - 1; k < j; k++) {
			if (c >= w[k]) {
				return true;
			}
		}
		return false;
	}
}
