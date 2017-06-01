package part09;

import java.util.Random;

/*注意题目的输入说的是一个有n个不同数字的集合S
 * step1：求出数组的中位数的值O(n)
 * step2：计算数组每个数与中位数差的绝对值，存于另一个数组B中O(n)
 * step3：求出数组B中第k小的数ret O(n)
 * step4：计算数组S中与ret差的绝对值小于ret的数并输出O(n)
 * 其中，step4也可以通过划分的方法找出数组S中与ret差的绝对值小于ret的数
 */
public class _Homework9_3_7 {
	public static void main(String[] args) {
		int[] a = { 16, 9, 10, 2, 1, 39, 29, 19, 18, 8, 21, 4, 6, 48, 8, 49, 12, 14,
				19, 22, 16, 0 };
		method(a, 1);
	}

	//这主方法写的也算是机智
	protected static void method(int[] a, int k) {
		int i;
		if (k > a.length) {
			System.out.println("error:k > length_A");
		}
		// 计算中位数
		int mid = select(a, 1, a.length, (a.length + 1) / 2);
		// 计算每个数与中位数的距离
		int[] b = new int[a.length + 1];
		for (i = 1; i <= a.length; i++)
			b[i - 1] = Math.abs(a[i - 1] - mid);
		// 选择第k小的数
		int ret = select(b, 1, a.length, k);
		// 求出数组是与中位数距离小于ret的数，并输出
		for (i = 1; i <= a.length; i++) {
			if (Math.abs(a[i - 1] - mid) <= ret) {
				System.out.print(a[i - 1]+"\t");
			}
		}
	}

	protected static int insert_sort(int[] a, int p, int r, int k) {
		for (int i = p; i < r; i++) {
			Integer key = a[i];
			while (i > 0 && key < a[i - 1]) {
				a[i] = a[i - 1];
				a[i - 1] = key;
				i--;
			}
		}
		return a[p + k - 2];
	}

	// 以f为主元的划分
	protected static int partition_median(int[] a, int p, int r, int f) {
		for (int i = p; i < r; i++) {
			if (a[i] == f) {
				int tran = a[i - 1];
				a[i - 1] = a[r - 1];
				a[r - 1] = tran;
				break;
			}
		}
		return partition(a, p, r);
	}

	protected static int select(int[] a, int p, int r, int i) {
		if (p == r) {
			return a[p - 1];
		}
		int f = find(a, p, r);
		int q = partition_median(a, p, r, f);
		int k = q - p + 1;
		if (i == k) {
			return a[q - 1];
		} else if (i < k) {
			return select(a, p, q - 1, i);
		} else {
			return select(a, q + 1, r, i - k);
		}

	}

	// 找到数据a的p到r之间数的中位数
	protected static int find(int[] a, int p, int r) {
		int j = 0;
		int start = 0, len = r - p + 1;
		int[] b = new int[len / 5 + 1];
		// 每5个元素一组，长度为start到end，对每一组进行插入排序，并返回中值
		for (int i = 1; i <= len; i++) {
			if (i % 5 == 1)
				start = i + p - 1;
			if (i % 5 == 0 || i == len) {
				j++;
				int end = i + p - 1;
				// 对每一组从start到end进行插入排序，并返回中值,如果是最后一组，组中元素个数可能少于5
				int ret = insert_sort(a, start, end, (end - start) / 2 + 1);
				// 把每一组的中值挑出来形成一个新的数组
				b[j - 1] = ret;
			}
		}
		// 对这个数组以递归调用Select()的方式寻找中值
		int ret = select(b, 1, j, (j + 1) / 2);
		return ret;
	}

	protected static int partition(int[] a, int p, int r) {
		int x = a[r - 1];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j - 1] <= x) {
				i++;
				int tran = a[i - 1];
				a[i - 1] = a[j - 1];
				a[j - 1] = tran;
			}
		}
		int tran = a[i];
		a[i] = a[r - 1];
		a[r - 1] = tran;
		return i + 1;
	}

	protected static void print(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}