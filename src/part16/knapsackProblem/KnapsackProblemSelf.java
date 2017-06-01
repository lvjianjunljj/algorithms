package part16.knapsackProblem;

import java.util.ArrayList;

/**
 * 网上方法的复现： 它并不是在中间进行拆分，而是一直在判断最后一个物品是否在最优解内
 * 日了狗了，这样就简单多了啊
 */
public class KnapsackProblemSelf {
	public static void main(String[] args) {
		int[] v = { 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 9 };
		int[] w = { 1, 2, 3, 4, 5, 6, 9, 11, 12, 13, 14, 15, 16, 19 };
		int c = 19;
		ArrayList<Integer> v1 = new ArrayList<Integer>();
		ArrayList<Integer> w1 = new ArrayList<Integer>();
		for (int i = 0; i < w.length; i++) {
			v1.add(v[i]);
			w1.add(w[i]);
		}
		System.out.println(knapsack(v1, w1, v1.size(), c));
	}

	protected static int knapsack(ArrayList<Integer> v, ArrayList<Integer> w,
			int n, int c) {
		if (n <= 0) {
			return 0;
		}
		if (c <= 0) {
			return 0;
		}
		if (c < w.get(n - 1)) {
			return knapsack(v, w, n - 1, c);
		}
		int value = Math.max(knapsack(v, w, n - 1, c), v.get(n - 1)
				+ knapsack(v, w, n - 1, c - w.get(n - 1)));
		return value;
	}
}
