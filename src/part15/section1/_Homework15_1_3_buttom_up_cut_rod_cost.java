package part15.section1;

import java.util.ArrayList;

import javax.swing.text.html.FormSubmitEvent.MethodType;

public class _Homework15_1_3_buttom_up_cut_rod_cost {
	public static void main(String[] args) {
		int[] p = { 500, 1000, 10, 10, 10, 10, 10, 10, 1000, 10, 100, 1000, 10,
				10, 10, 10, 10, 10, 1000, 10, 100, 1000, 10, 10, 10, 10, 10,
				10, 1000, 10 };
		int q = buttom_up_cut_rod_cost(p, 30, 10);
		System.out.println(q);
	}

	protected static int buttom_up_cut_rod_cost(int[] p, int n, int cost) {
		int[] r = new int[n + 1];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		r[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			int q = Integer.MIN_VALUE;
			for (int j = 1; j < i + 1; j++) {
				if (i == j) {
					q = Math.max(q, p[j - 1] + r[i - j]);
				} else {
					q = Math.max(q, p[j - 1] + r[i - j] - cost);
				}
			}
			r[i] = q;
		}
		return r[n];
	}
}
