package part15.section1;

//一般带备忘的自顶向下的方法都需要在主方法外面套一个方法，通过这个方法定义备忘数组（见第10行）
public class _Homework15_1_5_Fibonacci {
	public static void main(String[] args) {
		System.out.println(Fibonacci(50));
	}

	protected static long Fibonacci(int n) {
		long[] fi = new long[n];
		for (int i = 0; i < n; i++) {
			fi[i] = 1;
		}
		return Fibonacci_aux(fi, n);
	}

	protected static long Fibonacci_aux(long[] fi, int n) {
		if (n < 3) {
			return 1;
		}
		if (fi[n - 1] > 1) {
			return fi[n - 1];
		}
		fi[n - 1] = Fibonacci_aux(fi, n - 1) + Fibonacci_aux(fi, n - 2);
		return fi[n - 1];
	}

	/*这种计算方法的时间复杂度是指数增长的，不可取T(n)=T(n-1)+T(n-2)
	protected static int Fibonacci(int n) {
		if (n == 1 || n==2) {
			return 1;
		}
		return Fibonacci(n-1)+Fibonacci(n-2);
	}
	*/
	
}
