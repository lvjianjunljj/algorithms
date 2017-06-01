package part33;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//通过Jarvis算法求得点集的凸包，返回的是凸包的端点的集合
public class Jarvis {

	public static void main(String[] args) {
		Point[] Q = new Point[7];
		Q[3] = new Point(0, 0);
		Q[4] = new Point(3, 0);
		Q[2] = new Point(2, 1);
		Q[0] = new Point(3, 3);
		Q[5] = new Point(1, 2);
		Q[1] = new Point(0, 3);
		Q[6] = new Point(2, 2);
		Stack<Point> result = Jarvis(Q);
		System.out.println("点集Q的凸包坐标点为：");
		for (Point p : result) {
			System.out.println("(" + p.getX() + "," + p.getY() + ")");
		}
	}

	protected static Stack<Point> Jarvis(Point[] Q) {
		// 先找到最低点和最高点（y坐标最小和最大的点，若存在多个则分别在其中选择x坐标最小的点，由609页图中解释的方法很容易得到这个选择标准）
		ArrayList<Point> Q_copy = new ArrayList<Point>();
		Point p_low = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
		Point p_high = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
		for (Point p : Q) {
			Q_copy.add(p);
			if (p_low.getY() > p.getY()) {
				p_low = p;
			} else if (p_low.getY() == p.getY() && p_low.getX() > p.getX()) {
				p_low = p;
			}
			if (p_high.getY() < p.getY()) {
				p_high = p;
			} else if (p_high.getY() == p.getY() && p_high.getX() > p.getX()) {
				p_high = p;
			}
		}
		int m = Q.length;
		if (m < 3) {
			System.out.println("convex hull is empty!!!");
			return null;
		} else {
			Stack<Point> S = new Stack<Point>();
			Point pi = new Point();
			// 像这种判断角度大小的完全可以用斜率来做，至少右链可以这样，但是用sin值来做快得多
			Q_copy.remove(p_low);
			S.add(p_low);
			pi = p_low;
			while (pi != p_high) {
				double cos = Integer.MIN_VALUE;
				for (Point p : Q_copy) {
					if (p.getY() >= S.peek().getY()) {
						double cosTran = getCosRight(S.peek(), p);
						if ((cosTran > cos)
								|| (cosTran == cos && p.getX() > pi.getX())) {
							cos = cosTran;
							pi = p;
						}
					}
				}
				Q_copy.remove(pi);
				S.add(pi);
			}
			Q_copy.add(p_low);
			while (pi != p_low) {
				double cos = Integer.MIN_VALUE;
				for (Point p : Q_copy) {
					if (p.getY() <= S.peek().getY()) {
						double cosTran = getCosLeft(S.peek(), p);
						if ((cosTran > cos)
								|| (cosTran == cos && p.getX() > pi.getX())) {
							cos = cosTran;
							pi = p;
						}
					}
				}
				Q_copy.remove(pi);
				S.add(pi);
			}
			S.remove(S.size()-1);
			return S;
		}

	}

	protected static int getK(Point p1, Point p2) {
		int k;
		if (p1.getX() == p2.getX()) {
			k = Integer.MAX_VALUE;
		} else {
			k = (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
		}
		return k;
	}

	// 用斜率k值进行排序判断要考虑的情况太对，不如用sin值来的直接（GrahamScan类中的排序规则验证了这一点）
	//右链
	protected static double getCosRight(Point p1, Point p2) {
		double x = p2.getX() - p1.getX();
		double y = p2.getY() - p1.getY();
		return x / Math.sqrt(x * x + y * y);
	}
	protected static double getCosLeft(Point p1, Point p2) {
		double x = p2.getX() - p1.getX();
		double y = p2.getY() - p1.getY();
		return -x / Math.sqrt(x * x + y * y);
	}

}
