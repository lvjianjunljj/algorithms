package part15.section1;

public class BUTTOM_UP_CUT_ROD {
	public static void main(String[] args) {
		int[] p = { 100, 1000, 10, 10, 10, 10, 10, 10, 1000, 10, 100, 1000, 10,
				10, 10, 10, 10, 10, 1000, 10, 100, 1000, 10, 10, 10, 10, 10,
				10, 1000, 10 };
		int q = buttom_up_cut_rod(p, 30);
		System.out.println(q);
	}

	protected static int buttom_up_cut_rod(int[] p, int n) {
		int[] r = new int[n + 1];
		for (int i = 0; i < r.length; i++) {
			r[i] = Integer.MIN_VALUE;
		}
		r[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			int q = Integer.MIN_VALUE;
			for (int j = 1; j < i + 1; j++) {
				q = Math.max(q, p[j - 1] + r[i - j]);
			}
			r[i] = q;
		}
		return r[n];
	}
}
