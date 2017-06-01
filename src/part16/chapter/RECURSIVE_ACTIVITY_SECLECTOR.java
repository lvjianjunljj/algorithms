package part16.chapter;

import java.util.ArrayList;
import arrayOperate.Array;

//递归贪心算法
public class RECURSIVE_ACTIVITY_SECLECTOR {
	public static void main(String[] args) {
		int[] s = { 1, 3, 2, 4, 5, 6, 7, 8, 1 };
		int[] f = { 4, 4, 4, 5, 6, 7, 8, 9, 3 };
		ArrayList<String> result = recursive_activity_seclector(s, f);
		System.out.println(result);
	}

	protected static ArrayList<String> recursive_activity_seclector(int[] s,
			int[] f) {
		ArrayList<String> result = new ArrayList<String>();
		int[] number = new int[f.length];
		// 这里是对s、f和新建的活动序号三行以f为准进行排序
		int[][] tran = new int[f.length][3];
		for (int i = 0; i < f.length; i++) {
			tran[i][0] = s[i];
			tran[i][1] = f[i];
			tran[i][2] = i + 1;
		}
		Array.sortArrs(tran, 1);
		for (int i = 0; i < f.length; i++) {
			s[i] = tran[i][0];
			f[i] = tran[i][1];
			number[i] = tran[i][2];
		}
		int[] f2 = new int[f.length + 1];
		f2[0] = 0;
		for (int i = 0; i < f.length; i++) {
			f2[i + 1] = f[i];
		}
		recursive_activity_seclector_aux(s, f2, 0, f.length, number, result);
		return result;
	}

	protected static void recursive_activity_seclector_aux(int[] s, int[] f,
			int k, int n, int[] number, ArrayList<String> result) {
		int m = k + 1;
		while (m <= n && s[m - 1] < f[k]) {
			m++;
		}
		if (m <= n) {
			result.add("K" + number[m - 1]);
			recursive_activity_seclector_aux(s, f, m, n, number, result);
		}

	}
}
