package part15.section1;

import java.util.ArrayList;

public class EXTENDED_BUTTOM_UP_CUT_ROD {
	public static void main(String[] args) {
		int[] p = { 2, 3, 4, 15, 9, 6, 22, 16, 26, 13, 28, 39, 21, 16, 13,
				6, 28, 22, 4, 28, 16, 20, 300, 37, 28, 14, 2, 40, 10, 33 };
		ArrayList q = extended_buttom_up_cut_rod(p, 30);
		System.out.println("切割结果是：");
		for (int i = 0; i < q.size()-1; i++) {
			System.out.print(q.get(i)+"\t");
		}
		System.out.println();
		System.out.println("切割收益是：");
		System.out.println(q.get(q.size()-1));
	}

	protected static ArrayList extended_buttom_up_cut_rod(int[] p, int n) {
		int[] r = new int[n + 1];
		int[] s = new int[n + 1];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.MIN_VALUE;
			s[i] = 0;
		}
		r[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			int q = Integer.MIN_VALUE;
			for (int j = 1; j < i + 1; j++) {
				if (q < p[j - 1] + r[i - j]) {
					q = p[j - 1] + r[i - j];
					//s[i]保存的是求解规模为i的子问题时将第一段钢条切割的最优长度
					s[i] = j;
				}
			}
			r[i] = q;
		}
		//这里通过操作s将最终切割结果存入result中
		ArrayList result = new ArrayList();
		int m = s.length - 1;
		while (m > 0) {
			result.add(s[m]);
			m = m - s[m];
		}
		//将最大的收益存到切割结果的最后一位（因为java不支持多输出）
		result.add(r[n]);
		return result;
	}
}
