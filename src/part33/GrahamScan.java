package part33;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//通过GrahamScan算法求得点集的凸包，返回的是凸包的端点的集合
public class GrahamScan {
	static Point p0 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);

	public static void main(String[] args) {
		Point[] Q = new Point[6];
		Q[3] = new Point(0, 0);
		Q[4] = new Point(3, 0);
		Q[2] = new Point(2, 1);
		Q[0] = new Point(3, 3);
		Q[5] = new Point(1, 2);
		Q[1] = new Point(0, 3);
		Stack<Point> result = grahamScan(Q);
		System.out.println("点集Q的凸包坐标点为：");
		for (Point p : result) {
			System.out.println("(" + p.getX() + "," + p.getY() + ")");
		}
	}

	protected static Stack<Point> grahamScan(Point[] Q) {
		// 不是这么简单地用y坐标从小到大对点进行排序
		// Comparator c = new Comparator() {
		// public int compare(Object o1, Object o2) {
		// int i1 = ((Point) o1).getY();
		// int i2 = ((Point) o2).getY();
		// if (i1 > i2) {
		// return 1;
		// }
		// if (i1 < i2) {
		// return -1;
		// }
		// return 0;
		// }
		// };
		// Arrays.sort(Q, c);

		// java中不易求得图中的角度，所以尝试通过斜率排序
		// 先找到最低点（y坐标最小的点，若存在多个则在其中选择x坐标最小的点，由606页图中解释的方法很容易得到这个选择标准）
		for (Point p : Q) {
			if (p0.getY() > p.getY()) {
				p0 = p;
			} else if (p0.getY() == p.getY() && p0.getX() > p.getX()) {
				p0 = p;
			}
		}
		// 这个排序规则应该是对的，没有经过太多的验证
		Comparator c1 = new Comparator() {
			public int compare(Object o1, Object o2) {
				int x0 = p0.getX();
				int y0 = p0.getY();
				int x1 = ((Point) o1).getX();
				int x2 = ((Point) o2).getX();
				int y1 = ((Point) o1).getY();
				int y2 = ((Point) o2).getY();
				double k1, k2;
				if (x0 == x1) {
					k1 = Integer.MAX_VALUE;
				} else {
					k1 = (double) (y1 - y0) / (double) (x1 - x0);
				}
				if (x0 == x2) {
					k2 = Integer.MAX_VALUE;
				} else {
					k2 = (double) (y2 - y0) / (double) (x2 - x0);
				}
				if (x0 == x2 && y0 == y2) {
					return 1;
				}
				if (x0 == x1 && y0 == y1) {
					return -1;
				}
				if (k1 == k2) {
					return 0;
				} else if (k1 > k2 && k2 >= 0) {
					return 1;
				} else if (k1 < 0 && k2 >= 0) {
					return 1;
				} else if (k1 < k2 && k2 < 0) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		// 按正弦值进行排序更简单直接，且易于理解
		Comparator c2 = new Comparator() {
			public int compare(Object o1, Object o2) {
				Point pi = new Point(p0.getX() + 1, p0.getY());
				if ((Point) o2 == p0) {
					return 1;
				}
				if ((Point) o1 == p0) {
					return -1;
				}
				if (getCos((Point) o1, pi, p0) < getCos((Point) o2, pi, p0)) {
					return 1;
				} else if (getCos((Point) o1, pi, p0) == getCos((Point) o2, pi,
						p0)
						&& ((Point) o1).getX() > ((Point) o2).getX()) {
					return 1;
				} else {
					return -1;
				}
			}
		};
		Arrays.sort(Q, c2);
		int m = Q.length;
		if (m < 3) {
			System.out.println("convex hull is empty!!!");
			return null;
		} else {
			Stack<Point> S = new Stack<Point>();
			S.push(Q[0]);
			S.push(Q[1]);
			S.push(Q[2]);
			for (int i = 3; i < m; i++) {
				Point p1 = S.get(S.size() - 2);
				Point p2 = Q[i];
				Point pi = S.peek();
				while (crossProduct(p1, p2, pi) >= 0) {
					S.pop();
					p1 = S.get(S.size() - 2);
					pi = S.peek();
				}
				S.push(p2);
			}
			return S;
		}

	}

	protected static int crossProduct(Point p1, Point p2, Point pi) {
		return (p1.getX() - pi.getX()) * (p2.getY() - pi.getY())
				- (p2.getX() - pi.getX()) * (p1.getY() - pi.getY());
	}

	protected static double getCos(Point p1, Point p2, Point pi) {
		double x1 = p1.getX() - pi.getX();
		double y1 = p1.getY() - pi.getY();
		double x2 = p2.getX() - pi.getX();
		double y2 = p2.getY() - pi.getY();
		return (x1 * x2 + y1 * y2)
				/ Math.sqrt((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2));
	}
}
