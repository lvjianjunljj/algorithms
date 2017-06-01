package part09;

import java.util.Random;

public class _Homework_9_2_c {
	public static void main(String[] args) {
		float[] a = new float[20];
		Random ra = new Random();
		for (int i = 0; i < a.length; i++) {
			a[i] = ra.nextFloat();
		}
		print(a, a.length);
		System.out.println(sum(a, 1, a.length));
	}
/*太麻烦了，我不想写了
	protected static void method(int[] a, float[] b, int p, int r) {
		float x = select(b, p, r, (p + r) / 2);
		partition_median(b, p, r, x);
		float sum_front = sum(b, p, (p + r) / 2 - 1 );
		float sum_back = sum(b, (p + r) / 2 + 1, r);
		if(sum_front <0.5 && sum_back<= 0.5){
			return 
		}

	}
*/
	// 通过随机数实现选择
	protected static float select(float[] a, int p, int r, int i) {
		if (p == r) {
			return a[p - 1];
		}
		int q = partition(a, p, r);
		int k = q - p + 1;
		if (i == k) {
			return a[q - 1];
		} else if (i < k) {
			return select(a, p, q - 1, i);
		} else {
			return select(a, q + 1, r, i - k);
		}

	}

	// 以f为主元的划分
	protected static float partition_median(float[] a, int p, int r, float f) {
		for (int i = p; i < r; i++) {
			if (a[i] == f) {
				float tran = a[i - 1];
				a[i - 1] = a[r - 1];
				a[r - 1] = tran;
				break;
			}
		}
		return partition(a, p, r);
	}

	protected static int partition(float[] a, int p, int r) {
		float x = a[r - 1];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j - 1] <= x) {
				i++;
				float tran = a[i - 1];
				a[i - 1] = a[j - 1];
				a[j - 1] = tran;
			}
		}
		float tran = a[i];
		a[i] = a[r - 1];
		a[r - 1] = tran;
		return i + 1;
	}

	protected static float sum(float[] a, int p, int r) {
		float sum = 0;
		for (int j = p - 1; j < r; j++) {
			sum += a[j];
		}
		return sum;
	}

	protected static void print(float[] a, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}