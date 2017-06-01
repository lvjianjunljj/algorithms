package part08;

public class _Homework8_2_4 {
	public static void main(String[] args) {
		int[] a = { 16, 9, 10, 1, 1, 9, 9, 9, 8, 8, 1, 4, 6, 8, 8, 9, 12, 14,
				19, 12, 16, 0 };
		System.out.println(method(a, 19,0,4));
	}

	protected static int method(int[] a, int k, int x, int y) {
		int b = 0;
		int[] c = new int[k + 1];
		for (int i = 0; i < k + 1; i++) {
			c[i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			c[a[i]] = c[a[i]] + 1;
		}
		for (int i = 1; i < k+1; i++) {
			c[i] = c[i]+c[i-1];
		}
		if(x == 0){
			b = c[y];
		}else{
			b = c[y] - c[x-1];
		}
		return b;
	}
}