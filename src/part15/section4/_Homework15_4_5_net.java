package part15.section4;

import java.util.Arrays;

/**
 *网上给的求最长递增子序列的方法
 *不太对，老子不想调了
 */
public class _Homework15_4_5_net {
	public static void main(String[] args) {
		int[] x = { 2, 3, 5, 4, 5, 6, 7, 8, 9, 0, 1 };
		int[] pre = length(x);
		System.out.print("最长单调递增子序列为：\t");
		print(x,x.length,pre);

	}

	protected static int[] length(int[] x) {
		int n = x.length;
		int[] c = new int[n + 1];
		int[] pre = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			// 初始化
			c[i] = 0;
			pre[i] = 0;
			for (int j = 0; j < i; j++) {
				if (x[i-1] > x[j]) {
					if (c[j] + 1 > c[i]) {
						c[i] = c[j] + 1;
						pre[i] = j;
					}
				}
			}
		}
		System.out.println("最长单调递增子序列的长度为：" + c[n]);
		return pre;
	}

	protected static void print(int[] x,int n,int[] pre) {
		if (pre[n]>0){
			print(x, pre[n],pre);
			System.out.print(x[n-1]);
		}
	}
}
