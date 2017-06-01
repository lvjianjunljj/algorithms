package test;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		/*
		 * 这里的问题一直没有解决，用了next方法以后会一直输入而不是在enter以后就会停止输入 Scanner content = new
		 * Scanner(System.in); ArrayList<Integer> arrayList = new
		 * ArrayList<Integer>(); int i = 0; while(content.hasNext() == true) {
		 * System.out.println(content.next()); } System.out.println("1234");
		 */

		/*
		 * int[] a = {1,2,3,4,5}; int[] c = Arrays.copyOfRange(a, 0, 5);
		 * System.out.println(c.length);
		 */

		/*
		 * System.out.println((int)(Math.log(8)/Math.log(2)));
		 * System.out.println(Math.pow(3, 3)); HashMap a = new HashMap();
		 * ArrayList b = new ArrayList();
		 */

		/*
		 * Random ra = new Random(); for (int i = 0; i < 30; i++) {
		 * System.out.println(ra.nextInt(10)); } int i = 0; for (int j = 1; j <
		 * 11; j++) { i++; } System.out.println(i);
		 */

		/*
		 * int[] data = new int[] { 1100, 192, 221, 12, 23 }; print(data);
		 * radixSort(data, 10, 4); System.out.println("排序后的数组："); print(data);
		 */
		/*
		 * ArrayList list = new ArrayList(); list.add(1); list.add(2);
		 * list.add(3); System.out.println(list.get(0)); list.remove(0);
		 * list.remove(0); list.remove(0); System.out.println(list.isEmpty());
		 * System.out.println(1/2*2);
		 */
		/*
		 * Random ra = new Random(); int[] a = new int[30]; for (int i = 0; i <
		 * a.length; i++) { a[i] = ra.nextInt(40)+1; } for (int i = 0; i <
		 * a.length; i++) { System.out.print(a[i]+","); }
		 */

	}
	/*
	 * public static void radixSort(int[] data, int radix, int d) { // 缓存数组
	 * int[] tmp = new int[data.length]; // buckets用于记录待排序元素的信息 //
	 * buckets数组定义了max-min个桶 int[] buckets = new int[radix];
	 * 
	 * for (int i = 0, rate = 1; i < d; i++) {
	 * 
	 * // 重置count数组，开始统计下一个关键字 Arrays.fill(buckets, 0); // 将data中的元素完全复制到tmp数组中
	 * System.arraycopy(data, 0, tmp, 0, data.length);
	 * 
	 * // 计算每个待排序数据的子关键字 for (int j = 0; j < data.length; j++) { int subKey =
	 * (tmp[j] / rate) % radix; buckets[subKey]++; }
	 * 
	 * for (int j = 1; j < radix; j++) { buckets[j] = buckets[j] + buckets[j -
	 * 1]; }
	 * 
	 * // 按子关键字对指定的数据进行排序 for (int m = data.length - 1; m >= 0; m--) { int
	 * subKey = (tmp[m] / rate) % radix; data[--buckets[subKey]] = tmp[m]; }
	 * rate *= radix; }
	 * 
	 * }
	 * 
	 * public static void print(int[] data) { for (int i = 0; i < data.length;
	 * i++) { System.out.print(data[i] + "\t"); } System.out.println(); }
	 */

}
