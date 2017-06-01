package part16.questions;

import java.util.Arrays;

/**我这个方法确实有一定的问题
 * 至少要将钱数遍历一遍
 */
public class _Homework_16_1_d {
	public static void main(String[] args) {
		int n = 17;
		int[] c = { 1, 2, 4, 5, 6, 7, 8, 9 };
		int[] r = change(c, n);
		for (int i = 0; i < r.length; i++) {
			System.out.println(r[i]);
		}
	}

	protected static void print(int[] r,int i ){
		if(i==0){
			return;
		}else{
			System.out.println(r[i]);
			
		}
	}

	protected static int[] change(int[] c, int n) {
		Arrays.sort(c);
		int l = c.length;
		int[] r = new int[l];
		change_min(c, r, n, l);
		return r;
	}

	protected static int change_min(int[] c, int[] r, int n, int i) {
		if (n < 1) {
			r[i - 1] = 0;
			return 0;
		}
		if (i == 1) {
			r[i - 1] = n;
			return n;
		}
		if (n < c[i - 1]) {
			r[i - 1] = 0;
			return change_min(c, r, n, i - 1);
		}
		r[i - 1] = n / c[i - 1];
		int x = change_min(c, r, n - c[i - 1] * r[i - 1], i - 1) + r[i - 1];
		int y = change_min(c, r, n, i - 1);
		if (x > y) {
			r[i - 1] = 0;
			return y;
		} else {
			return x;
		}
	}
}
