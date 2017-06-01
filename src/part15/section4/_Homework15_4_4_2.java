package part15.section4;

/**
 * 使用min(m,n)项以及O(1)空间 题上这么说的，可是我却只能使用max(m,n)项以及O(1)空间
 * 但是这个方法写的绝对是机智啊（机智到好像不太对啊），搞不定了
 */
public class _Homework15_4_4_2 {
	public static void main(String[] args) {
		String[] x = { "q", "w", "b", "r", "t", "y", "u", "i", "o", "p" };
		String[] y = { "a", "e", "r", "t", "y", "i", "o", "o", "o", "o", "p" };
		int result = lcs_length(x, y);
		System.out.print("最长公共子序列为：" + result);

	}

	protected static int lcs_length(String[] x, String[] y) {
		int m = x.length;
		int n = y.length;
		int a = Math.max(m, n);
		int b = Math.min(m, n);
		int[] c = new int[a + 1];
		int t1 = 0;
		int t2;
		int i = 0, j = 0;
		for (i = 1; i <= n; i++) {
			t2 = c[j];
			for (j = 1; j <= m; j++) {
				if (y[i - 1] == x[j - 1]) {
					c[j] = t1 + 1;
				} else {
					c[j] = Math.max(c[j], c[j - 1]);
				}
				t1 = t2;
			}
		}
		return c[b];
	}
}
