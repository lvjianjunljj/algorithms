package part16.questions;

public class _Homework_16_1_a {
	public static void main(String[] args) {
		int n = 66;
		int[] s = change(n);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}
	}

	// 输出的数组是4种零钱对应的数量
	protected static int[] change(int n) {
		int[] r = new int[4];
		/*
		 * 这也是一种循环方式，其实可以将n<5的情况剔除循环之外直接对其进行赋值
		while (n > 0) {
			if (n > 24) {
				r[0]++;
				n -= 25;
			} else if (n > 9) {
				r[1]++;
				n -= 10;
			} else if (n > 4) {
				r[2]++;
				n -= 5;
			} else {
				r[3]++;
				n--;
			}
		}
		 */
		while (n > 4) {
			if (n > 24) {
				r[0]++;
				n -= 25;
			} else if (n > 9) {
				r[1]++;
				n -= 10;
			} else {
				r[2]++;
				n -= 5;
			}
		}
		r[3] = n;
		return r;
	}
}
