package part31;

public class ExtenderEuclid {
	public static void main(String[] args) {
		double a = 24;
		double b = 16;
		double[] c = extenderEuclid(a, b);
		System.out.println(a+"和"+b+"的最大公约数是："+c[0]);
		System.out.println(c[0]+"="+a+"*("+c[1]+")+"+b+"*("+c[2]+")");
	}

	//求两个数a和b的最大公约数d，同时求得x和y使得d=ax+by
	protected static double[] extenderEuclid(double a, double b) {
		if (b == 0) {
			double[] result = { a, 1, 0 };
			return result;
		} else {
			double[] tran = extenderEuclid(b, a % b);
			double[] result = { tran[0], tran[2],
					tran[1] - Math.floor(a / b) * tran[2] };
			return result;
		}

	}
}
