package part15.section3;

//带备忘录的递归算法为每个子问题维护一个表项来保存它的解
public class MEMOIZED_MATRIX_CHAIN {
	public static void main(String[] args) {
		int[] p = { 5, 10, 3, 12, 5, 50, 6 };
		memoized_matrix_chain(p);
	}

	protected static void memoized_matrix_chain(int[] p) {
		int n = p.length - 1;
		int[][] m = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m[i][j] = Integer.MAX_VALUE;
			}
		}
		int result = lookup_chain(p, m, 1, n);
		System.out.println(result);
	}

	protected static int lookup_chain(int[] p, int[][] m, int i, int j) {
		if (m[i - 1][j - 1] < Integer.MAX_VALUE) {
			return m[i - 1][j - 1];
		}
		if (i == j) {
			m[i - 1][j - 1] = 0;
		}
		for (int k = i; k < j; k++) {
			int q = lookup_chain(p, m, i, k) + lookup_chain(p, m, k + 1, j)
					+ p[i-1] * p[k] * p[j];
			if (q < m[i - 1][j - 1]) {
				m[i - 1][j - 1] = q;
			}
		}
		return m[i - 1][j - 1];
	}
}
