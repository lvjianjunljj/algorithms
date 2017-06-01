package part16.chapter;
/**
 *三个方法没有一个能实现的，实在没有办法，我投降好不好，不知道如何用动态规划做贪心算法的问题
 *应该是很简单才是啊
 */
public class _Homework16_1_1_net_1 {
	public static void main(String[] args) {
		int[] s = { 1, 3, 1, 4, 5, 6, 7, 8, 9 };
		int[] f = { 2, 4, 4, 5, 6, 7, 8, 9, 10 };
		int[][] result = activity_select(s, f, 8);
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				System.out.println(result[i][j]);
			}
		}
	}

	protected static int[][] activity_select(int starts[], int finished[],
			int activityNum) {
		int[][] counts = new int[activityNum + 2][activityNum + 2];
		int[][] partition = new int[activityNum + 2][activityNum + 2];
		for (int i = 0; i < activityNum + 2; ++i)
			for (int j = 0; j < activityNum + 2; ++j) {
				counts[i][j] = 0;
				partition[i][j] = 0;
			}

		for (int i = activityNum; i >= 0; --i) {
			for (int j = i + 1; j < activityNum + 2; ++j) {
				for (int k = i + 1; k < j; ++k) {
					if (starts[k] >= finished[i] && finished[k] <= starts[j])// s【i，j】不为空
					{
						if (counts[i][j] <= (counts[i][k] + 1 + counts[k][j])) {
							counts[i][j] = (counts[i][k] + 1 + counts[k][j]);
							partition[i][j] = k;
						}
					}
				}
			}
		}
		return counts;
	}
}
