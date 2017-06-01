package part16.chapter;

import java.util.ArrayList;

//迭代贪心算法
public class GREEDY_ACTIVITY_SECLECTOR {
	public static void main(String[] args) {
		int[] s = { 1, 3, 2, 4, 5, 6, 7, 8, 9 };
		int[] f = { 2, 4, 4, 5, 6, 7, 8, 9, 10 };
		ArrayList<String> result = greedy_activity_seclector(s, f);
		System.out.println(result);
	}

	protected static ArrayList<String> greedy_activity_seclector(int[] s,
			int[] f) {
		ArrayList<String> result = new ArrayList<String>();
		int n = s.length;
		result.add("K1");
		int k = 1;
		for (int i = 2; i < n + 1; i++) {
			if (s[i - 1] >= f[k - 1]) {
				result.add("K"+i);
				k = i;
			}
		}
		return result;
	}

}
