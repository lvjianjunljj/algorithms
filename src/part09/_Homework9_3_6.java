package part09;

//暂时放弃了，没有思路

/*令每个子集合的元素个数为t = n / k，A[j]是数组A中下标为j的元素，A(j)是数组是第j大的元素
 * 则所求的k分位数是指A(t)，A(2t)，A(3t)，……，A((k-1)t)
 * 按顺序依次求这k-1个数的运行时(k-1)*n
 * 要使运行时间为O(nlgk)，改进方法是不要依次寻找这k-1个数，而是借用二分的方法来找。
 * 先找第k/2个分位数，再以这个分位数为主元把数组分为两段，分别对这两段来找分位数，这个时候找的范围变小了，效率也就提高了
 */
public class _Homework9_3_6 {
	public static void main(String[] args) {
		int[] a = { 16, 9, 10, 1, 1, 9, 1, 1, 1, 1, 1, 4, 6, 8, 8, 9, 12, 14,
				19, 12, 1, 2, 3, 4, 5 };
		insert_sort(a, 1, a.length, 1);
		print(a, a.length);
		System.out.println();
		method(a, 5);
		System.out.println();
		System.out.println(find(a, 1, a.length));
	}

	// 我自己根据插排的伪代码才比较简炼，比网上的插排精炼多了（此处是根据要求对序列p到r位数进行插入排序，并返回排序后的第k个数）
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

	// 数组A中，求从start到end这段的分位数。这一段有k个分位数，即第ks+1个分位到第ks+k个分位数
	protected static void K_Quantile(int[] A, int[] B, int k, int start,
			int end, int ks, int t) {
		if (k == 0)
			return;
		// 先找最中间的分位数
		int x = select(A, start, end, ((k + 1) / 2) * t);
		// 记录这个分位数
		B[ks + (k + 1) / 2] = x;
		// 以这个分位数为主元把数组分为两段，调度的时候发现这一步没什么用，因为SELECT已经包含了分段的过程
		partition_median(A, start, end, x);
		// 分别找前后两个的分位数
		K_Quantile(A, B, (k - 1) / 2, start, (ks + (k + 1) / 2) * t, 0, t);
		K_Quantile(A, B, k / 2, (ks + (k + 1) / 2) * t + 1, end, ks + (k + 1)
				/ 2, t);
	}

	protected static void method(int[] a, int k) {
		int t = a.length / k;
		// b是输出数组，记录k-1个分位数
		int[] b = new int[k];
		// 构造随机数据
		// 求k分位数算法
		K_Quantile(a, b, k - 1, 1, a.length, 0, t);
		// 打印输出数组
		print(b, k);
	}

	protected static void print(int[] a, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}
