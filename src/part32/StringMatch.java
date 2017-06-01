package part32;

import java.util.ArrayList;


public class StringMatch {
	public static void main(String[] args) {
		String t = "abcdefbcefr";
		String p = "bc";
		ArrayList result = StringMatch(t, p);
		System.out.println("“" + t + "”中的“" + p + "”所在位置的起始点为：");
		for (int i = 0; i < result.size(); i++) {
			System.out.print(result.get(i) + "\t");
		}

	}

	// 自己封装的字符串匹配的方法
	protected static ArrayList<Integer> StringMatch(String t, String p) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		while (t.indexOf(p) > -1) {
			int n = t.indexOf(p);
			res.add(n);
			t = t.substring(n + p.length());
		}
		for (int i = 1; i < res.size(); i++) {
			res.set(i, res.get(i - 1) + res.get(i) + p.length());
		}
		return res;
	}
}
