package part16.chapter;

import arrayOperate.Array;

public class FractionalKnapsackProblem {
	public static void main(String[] args) {
		int[] v = { 1, 1, 1, 1, 1, 1, 7 };
		int[] w = { 1, 2, 3, 4, 5, 6, 7 };
		int c = 10;
		System.out.println(knapsack(v, w, c));
	}

	protected static float knapsack(int[] v, int[] w, int c) {
		float value = 0;
		float w_sum = 0;
		float v_sum = 0;
		for (int i = 0; i < w.length; i++) {
			w_sum += w[i];
		}
		if (w_sum <= c) {
			for (int i = 0; i < v.length; i++) {
				v_sum += v[i];
			}
			return v_sum;
		}
		int weight = 0;
		int n = v.length;
		float[] unit_price = new float[n];
		float[][] tran = new float[n][3];
		for (int i = 0; i < n; i++) {
			tran[i][0] = (float) v[i];
			tran[i][1] = (float) w[i];
			unit_price[i] = tran[i][0] / tran[i][1];
			tran[i][2] = tran[i][0] / tran[i][1];
		}
		Array.sortArrs(tran, 2);
		for (int i = 0; i < tran.length; i++) {
			v[i] = (int) tran[i][0];
			w[i] = (int) tran[i][1];
			unit_price[i] = tran[i][2];
		}
		int mark = 0;
		//之前的排序是从小到大，所以这里要进行反向的贪心选择
		for (int i = n-1; weight <= c; i--) {
			value += v[i];
			weight += w[i];
			mark = i;
		}
		value = value - (weight - c) * ((float) v[mark] / (float) w[mark]);
		return value;
	}
}
