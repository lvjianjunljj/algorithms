package part33;

//通过SegmentsIntersect算法判断两条线段是否相交
public class SegmentsIntersect {
	public static void main(String[] args) {
		Point p1 = new Point(0, 3);
		Point p2 = new Point(3, 0);
		Point p3 = new Point(0, 4);
		Point p4 = new Point(4, 0);
		System.out.println("线段p1p2与线段p3p4的相交与否的结果是"
				+ segmentsIntersect(p1, p2, p3, p4));
	}

	protected static boolean segmentsIntersect(Point p1, Point p2, Point p3,
			Point p4) {
		int d1 = direction(p3, p4, p1);
		int d2 = direction(p3, p4, p2);
		int d3 = direction(p1, p2, p3);
		int d4 = direction(p1, p2, p4);
		if (((d1 > 0 && d2 < 0) || (d1 < 0 && d2 > 0))
				&& ((d3 > 0 && d4 < 0) || (d3 < 0 && d4 > 0))) {
			return true;
		} else if (d1 == 0 && onSegment(p3, p4, p1)) {
			return true;
		} else if (d2 == 0 && onSegment(p3, p4, p2)) {
			return true;
		} else if (d3 == 0 && onSegment(p1, p2, p3)) {
			return true;
		} else if (d4 == 0 && onSegment(p1, p2, p4)) {
			return true;
		} else {
			return false;
		}
	}

	protected static int direction(Point pi, Point pj, Point pk) {
		Point p1 = new Point();
		Point p2 = new Point();
		p1.setX(pk.getX() - pi.getX());
		p1.setY(pk.getY() - pi.getY());
		p2.setX(pj.getX() - pi.getX());
		p2.setY(pj.getY() - pi.getY());
		return crossProduct(p1, p2);
	}

	protected static boolean onSegment(Point pi, Point pj, Point pk) {
		if (Math.min(pi.getX(), pj.getX()) <= pk.getX()
				&& pk.getX() <= Math.max(pi.getX(), pj.getX())
				&& Math.min(pi.getY(), pj.getY()) <= pk.getY()
				&& pk.getY() <= Math.max(pi.getY(), pj.getY())) {
			return true;
		} else {
			return false;
		}
	}

	protected static int crossProduct(Point p1, Point p2) {
		return p1.getX() * p2.getY() - p2.getX() * p1.getY();
	}
}
