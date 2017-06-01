package part16.chapter;
/**
 * 0-1背包问题的解决办法在part16_knapsackProblem中有网上详尽的代码实现和本人自己进行的low一点的代码复现
 */
import java.util.ArrayList;

public class _Homework16_1_2 {
	public static void main(String[] args) {
		int[] s = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int[] f = { 2, 3, 4, 5, 7, 7, 8, 9, 10 };
		ArrayList<String> result = greedy_activity_seclector(s, f);
		System.out.println(result);
	}

	protected static ArrayList<String> greedy_activity_seclector(int[] s,
			int[] f) {
		ArrayList<String> result = new ArrayList<String>();
		int n = s.length;
		result.add("K"+n);
		int k = n;
		for (int i = n-1; i > 0; i--) {
			if (f[i - 1] <= s[k - 1]) {
				result.add("K"+i);
				k = i;
			}
		}
		return result;
	}

}