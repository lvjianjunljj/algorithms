package part14;

import java.util.ArrayList;
import java.util.Arrays;

/*设有n个区间，将所有2n个点从小到大排序，对于排序后的第i个点，若它是某个区间的左端点，则p[i]=1，若它是某个区间的右端点，则p[i]=-1。
 * 由第一问可知，所求的点一定是某条线段的端点，所以从端点集合中找出被最多区间覆盖的那个
 * 然后将p数列进行累加（可以得出是剔除当前端点数中对应的-1的累加）
 */
public class _Homework_14_1 {
	public static void main(String[] args) {
		int[][] a = { { 0, 2, 3, 4, 1, 1, 1, 1 }, { 2, 3, 5, 6, 2, 2, 2, 2 } };
		int result = method(a);
		System.out.println(result);

	}

	protected static int method(int[][] a) {
		int[] b = new int[2 * a[0].length];
		int[] c = new int[2 * a[0].length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < 2; j++) {
				b[j * a[0].length + i] = a[j][i];
			}
		}
		for (int j = 0; j < a[0].length; j++) {
			c[j] = 1;
			c[j + a[0].length] = -1;
		}

		int[][] x = counting_sort(b, c, max(b));
		int value = min(b);
		int sum1 = 0;// 对于之前所有端点的统计
		int sum2 = 0;// 对于当前端点的非负统计
		int sum_max = 0;
		int result = min(b);
		for (int i = 0; i < x[0].length; i++) {
			if (value == x[0][i]) {
				sum1 += x[1][i];
				if (x[1][i] == 1) {
					sum2++;
				} else if (sum_max < sum2) {
					sum_max = sum2;
					result = value;
				}
			} else {
				if (sum_max < sum2) {
					sum_max = sum2;
					result = value;
				}
				sum2 = sum1 + x[0][i];
				value = x[0][i];
			}
		}
		return result;
	}

	protected static int[][] counting_sort(int[] a, int[] x, int k) {
		int[] b = new int[a.length];
		int[] d = new int[x.length];
		int[] c = new int[k + 1];
		for (int i = 0; i < k + 1; i++) {
			c[i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			c[a[i]] = c[a[i]] + 1;
		}
		for (int i = 1; i < k + 1; i++) {
			c[i] = c[i] + c[i - 1];
		}
		for (int i = a.length; i > 0; i--) {
			b[c[a[i - 1]] - 1] = a[i - 1];
			d[c[a[i - 1]] - 1] = x[i - 1];
			c[a[i - 1]] = c[a[i - 1]] - 1;
		}
		int[][] y = { b, d };
		return y;
	}

	protected static int max(int[] a) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (max < a[i]) {
				max = a[i];
			}
		}
		return max;
	}

	protected static int min(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}
		}
		return min;
	}

}
