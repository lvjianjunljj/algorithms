package part16.chapter;

public class _Homework16_1_1_net_2 {
	public static void main(String[] args) {
		int[] s = { 1, 3, 1, 4, 1, 6, 7, 8, 8 };
		int[] f = { 2, 4, 4, 5, 6, 7, 8, 9, 10 };
		int[] result = activity_select(s, f, 9);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	protected static int[] activity_select(int started[], int finished[],
			int activityNum) {
		int[] maxSetNum = new int[activityNum];
		int[] trace = new int[activityNum];
		for (int i = 0; i < activityNum; i++) {
			maxSetNum[i] = 1;
			trace[i] = -1;
		}
		for (int i = 1; i < activityNum + 1; i++) {
			for (int j = 1; j < i; j++) {
				if (finished[j - 1] < started[i - 1]
						&& maxSetNum[i - 1] <= maxSetNum[j - 1]) {
					maxSetNum[i - 1] = maxSetNum[j - 1] + 1;
					trace[i - 1] = j;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < maxSetNum.length; i++) {
			if (maxSetNum[i]>0) {
				result++;
			}
		}
		return maxSetNum;
	}
}
