package part16.chapter;

import java.util.ArrayList;

//与上一道题非常类似，但是因为是闭区间，所以要考虑边界问题
public class _Homework16_2_5 {
	public static void main(String[] args) {
		double[] p = { 1, 2, 3, 4, 5, 6, 7 };
		gekko(p, 1.2);
	}

	protected static void gekko(double[] p, double m) {
		ArrayList result_f = new ArrayList();
		ArrayList result_l = new ArrayList();
		double n = p.length;
		double d = p[0] + m;
		result_f.add(p[0]);
		result_l.add(p[0] + m);
		for (int i = 1; i < n; i++) {
			if (p[i] > d) {
				d = m + p[i];
				result_f.add(p[i]);
				result_l.add(p[i] + m);
			}
		}
		/**因为还要调用m值，所以直接将输出在方法中写了
		 * 其次因为ArrayList的get方法的返回值是Object不能直接和double相加
		 * 所以才定义了result_f和result_l来保存区间的前后界
		 * 起始可以double的封装类Double，就是使用ArrayList<Double>类
		 */
		System.out.println("区间集合一共包含区间个数为：" + result_f.size());
		System.out.println("每个区间为：");
		for (int i = 0; i < result_f.size(); i++) {
			System.out.print("[" + result_f.get(i) + "," + result_l.get(i)
					+ "]");
			System.out.println();
		}
	}
}
