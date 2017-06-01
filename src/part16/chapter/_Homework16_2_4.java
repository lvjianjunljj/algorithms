package part16.chapter;

import java.util.ArrayList;

public class _Homework16_2_4 {
	public static void main(String[] args) {
		int[] p = { 1, 2, 3, 4, 5, 6, 7 };
		ArrayList<Integer> result = gekko(p, 2);
		System.out.println("需要进行补充水的地点编号为：");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i)+"\t");
		}

	}

	protected static ArrayList<Integer> gekko(int[] p, int m) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int n = p.length;
		int d = m;
		if (p[0] > m) {
			System.out.println("第一站没到呢就已经扑街了！！！");
			return null;
		}
		for (int i = 1; i < n; i++) {
			if (p[i] > d) {
				d = m + p[i - 1];
				result.add(i);
			}
		}
		return result;
	}
}
