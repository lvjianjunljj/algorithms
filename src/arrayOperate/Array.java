package arrayOperate;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 这里实现了将一个二维数组按某行或者某列进行排序 这里是按列进行排序的而不是按行进行排序的 所以我自己定义了一个矩阵转置的方法
 */
public class Array {
	public static void sortArrs(int[][] a, final int sortCols) {
		Comparator c = new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((int[]) o1)[sortCols])
						.compareTo(((int[]) o2)[sortCols]);
			}
		};
		Arrays.sort(a, c);
	}
	
	public static void sortArrs(float[][] a, final int sortCols) {
		Comparator c = new Comparator() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((float[]) o1)[sortCols])
						.compareTo(((float[]) o2)[sortCols]);
			}
		};
		Arrays.sort(a, c);
	}
	//实现二维数组的转置
	public static int[][] transpose(int[][] a) {
		int m = a.length;
		int n = a[0].length;
		int[][] b = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
	
	public static double[][] transpose(double[][] a) {
		int m = a.length;
		int n = a[0].length;
		double[][] b = new double[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				b[j][i] = a[i][j];
			}
		}
		return b;
	}
	
	//实现数组的倒序排列
	public static void sortReverse(Integer[] a) {
		Comparator c = new Comparator() {
			public int compare(Object o1, Object o2) {
				int i1 = ((Integer) o1).intValue();
				int i2 = ((Integer) o2).intValue();
				if (i1 < i2) {
					return 1;
				}
				if (i1 > i2) {
					return -1;
				}
				return 0;
			}
		};
		//这个方法不支持输入int和Comparator，只支持输入object和Comparator。所以我暂时只能写成这样了
		Arrays.sort(a,c);
	}

}
