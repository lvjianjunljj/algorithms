package part28;

public class LupSolve {
	public static void main(String[] args) {
		float[][] A = { { 1, 1, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
		float[] b = {3,5,3};
		float[] result = lupSolve(A, b);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	protected static float[] lupSolve(float[][] A, float[] b) {
		int n = A.length;
		float[][] L = new float[n][n];
		float[][] U = luDecomposition(A, L);
		int[] p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i + 1;
		}
		return lupSolve_aux(L, U, p, b);
	}

	protected static float[][] luDecomposition(float[][] A, float[][] L) {
		int n = A.length;
		float[][] U = new float[n][n];
		for (int i = 0; i < n; i++) {
			L[i][i] = 1;
		}
		for (int k = 0; k < n; k++) {
			U[k][k] = A[k][k];
			for (int i = k + 1; i < n; i++) {
				L[i][k] = A[i][k] / U[k][k];
				U[k][i] = A[k][i];

			}
			for (int i = k + 1; i < n; i++) {
				for (int j = k + 1; j < n; j++) {
					A[i][j] -= L[i][k] * U[i][k];
				}

			}
		}
		return U;
	}

	protected static float[] lupSolve_aux(float[][] L, float[][] U, int[] p,
			float[] b) {
		int n = L.length;
		float[] x = new float[n];
		float[] y = new float[n];
		for (int i = 0; i < n; i++) {
			float tran = 0;
			for (int j = 0; j < i; j++) {
				tran += L[i][j] * y[j];
			}
			y[i] = b[p[i] - 1] - tran;
		}
		for (int i = n - 1; i > -1; i--) {
			float tran = 0;
			for (int j = i + 1; j < n; j++) {
				tran += U[i][j] * x[j];
			}
			x[i] = (y[i] - tran) / U[i][i];
		}
		return x;
	}
}
