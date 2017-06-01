package part16.questions;

//最好自己实现一遍
public class _Homework_16_1_CoinsChange_self {
	public static void main(String[] args) {

		// 硬币面值预先已经按降序排列
		int[] coinValue = new int[] { 25, 21, 10, 5, 1 };
		// 需要找零的面值
		int money = 65;
		change(coinValue, money);
	}
	
	protected static void change(int[] coinValue,int money){
		// 保存每一个面值找零所需的最小硬币数，0号单元舍弃不用，所以要多加1
		int[] coinsUsed = new int[money + 1];
		int[] coinTrack = new int[money + 1];
		for (int i = 1; i <= money; i++) {
			coinsUsed[i] = 0;
			coinTrack[i] = 0;
		}
		makeChange(coinValue, money, coinsUsed, coinTrack);
	}
	
	protected static void makeChange(int[] values, int money, int[] coinsUsed,
			int[] coinTrack) {
		int last = 0;
		for (int i = 1; i < money + 1; i++) {
			int minCoins = Integer.MAX_VALUE;
			for (int j = 0; j < values.length; j++) {
				if (values[j] <= i) {
					int temp = coinsUsed[i - values[j]] + 1;
					if (temp < minCoins) {
						minCoins = temp;
						last = j;
					}
				}
			}
			coinsUsed[i] = minCoins;
			coinTrack[i] = values[last];
		}
		System.out.print("面值为："+money+"的最小硬币数为："+coinsUsed[money]+"，硬币为：");
		trackPrint(money, coinTrack);

	}

	protected static void trackPrint(int m, int[] coinTrack) {
		if (m == 0) {
			return;
		} else {
			System.out.print(coinTrack[m] + " ");
			trackPrint(m - coinTrack[m], coinTrack);
		}
	}
}