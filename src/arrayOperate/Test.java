package arrayOperate;

public class Test {
	public static void main(String[] args) {
		int[][] b = { { 1, 2, 3, 4, 5 }, { 5, 4, 3, 2, 1 } };
		int[][] a = Array.transpose(b);
		Array.sortArrs(a, 1);
		b = Array.transpose(a);
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				System.out.print(b[i][j]);
			}
			System.out.println();
		}
		
		Integer[] c = {1,2,3,4,5,6,7,8,9};
		Array.sortReverse(c);
		for (int i = 0; i < c.length; i++) {
			System.out.println(c[i]);
		}
	}
}
