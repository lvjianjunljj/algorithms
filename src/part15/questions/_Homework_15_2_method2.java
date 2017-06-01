package part15.questions;

import java.util.ArrayList;
/**这个种从两端向中间不断检索的方法
 * 在aux方法中每次迭代需要新建arraylist所以感觉空间复杂度较高
 * aux方法中维护的mark是判断中间的字母是两个一样的还是单个
 * 但是这种单字符维护不能只是传入一个int类型，因为这样传入的是一个数字而不是地址，无法对它进行维护
 */
public class _Homework_15_2_method2 {
	public static void main(String[] args) {
		String value = "asdfghsfda";
		ArrayList output = get_palindrome(value);
		System.out.print("最长回文子序列：");
		for (int i = 0; i < output.size(); i++) {
			System.out.print(output.get(i));
		}
	}

	protected static ArrayList get_palindrome(String value) {
		char[] list = value.toCharArray();
		int len = list.length;
		int[] mark = new int[1];
		ArrayList output = new ArrayList();
		int out = get_palindrome_aux(list, output, 1, len, mark);
		int l = output.size();
		if (mark[0]==0) {
			for (int i = 0; i < l; i++) {
				output.add(output.get(l-i-1));
			}
		}else {
			for (int i = 0; i < l-1; i++) {
				output.add(output.get(l-i-2));
			}
		}
		return output;
	}

	protected static int get_palindrome_aux(char[] input, ArrayList output,
			int i, int j, int[] mark) {
		if (i > j) {
			mark[0] = 0;
			return 0;
		}
		if (i == j) {
			output.add(input[i - 1]);
			mark[0] = 1;
			return 1;
		}
		if (input[i - 1] == input[j - 1]) {
			output.add(input[i - 1]);
			return get_palindrome_aux(input, output, i + 1, j - 1, mark) + 1;
		} else if (get_palindrome_aux(input, new ArrayList(), i, j - 1, mark) > get_palindrome_aux(
				input, new ArrayList(), i + 1, j, mark)) {
			return get_palindrome_aux(input, output, i, j - 1, mark);
		} else {
			return get_palindrome_aux(input, output, i + 1, j, mark);
		}

	}

}
