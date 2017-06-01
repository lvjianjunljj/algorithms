package part09;

import java.util.Random;

/*分别求出两数组的中位数mid1，mid2，如果相等则即为所求中位数，如果mid1<mid2则取第一个数组的后半部分第二个的前半部分，否则相反
 * 递归调用这一过程，直到每一个数组中只有一个数字，则取这两个数字中较小的（默认为下中位数）数字为两个数组的中位数。
 */
public class _Homework9_3_8 {
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 6, 8, 9 };
		int[] b = { 1, 2, 8, 11, 12, 13, 14, 15, 16 };
		System.out.println(method(a, b));
	}
	
	protected static int method(int[] a,int[] b){
		return find_mid_twoarray(a,b,1,a.length,1,b.length);
	}

	protected static int find_mid_twoarray(int[] a, int[] b, int ra, int qa,
			int rb, int qb) {
		if (ra < qa || rb < qb) {
			int x = find_mid_onearray(a, ra, qa);
			int y = find_mid_onearray(b, rb, qb);
			if (x == y) {
				return x;
			} else if (x > y) {
				return find_mid_twoarray(a, b, ra, ra + (qa - ra) / 2 - 1, rb
						+ (qb - rb) / 2 + 1, qb);
			} else {
				return find_mid_twoarray(a, b, ra + (qa - ra) / 2 + 1, qa, rb,
						rb + (qb - rb) / 2 - 1);
			}
		}
		if (a[ra - 1] < b[rb - 1]) {
			return a[ra - 1];
		} else {
			return b[rb - 1];
		}

	}

	// 一般都是取下中位数
	protected static int find_mid_onearray(int[] a, int r, int q) {
		return a[(r + q) / 2 - 1];
	}
}