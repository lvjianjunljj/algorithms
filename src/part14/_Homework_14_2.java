package part14;

import java.util.ArrayList;
/*自己是搞不定了
public class _Homework_14_2 {
	public static void main(String[] args) {
		ArrayList result = method_2(1, 10);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}

	protected static ArrayList method_2(int m, int n) {
		ArrayList a_1 = new ArrayList();
		ArrayList a_2 = new ArrayList();
		for (int i = 0; i < n; i++) {
			a_2.add(i + 1);
		}
		method_1(a_1, a_2, m, 0);
		return a_1;
	}

	protected static void method_1(ArrayList a_1, ArrayList a_2, int m, int k) {
		int n = a_2.size();
		if (n > 0) {
			if (n >= (m + k)) {
				for (int i = 1; i < (n - k) / m + 1; i++) {
					a_1.add(a_2.get(k + m * i - 1));
				}
				for (int i = (n - k) / m; i > 0; i--) {
					a_2.remove(k + m * i - 1);
				}
				k = ((n - k) / m) * m + k + m - n - 1;
				method_1(a_1, a_2, m, k);
			}
		} else if (n >= m) {
			method_1(a_1, a_2, m, m + k - n);
		} else {
			method_1(a_1, a_2, m, k - n);
		}
	}
}
*/

