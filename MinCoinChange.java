/**
 * Minimum Coin Change Problem
 * 
 * @author deenliu
 * 
 *         You are given n types of coin denominations of values v(1) < v(2) <
 *         ... < v(n) (all integers). Assume v(1) = 1, so you can always make
 *         change for any amount of money C. Give an algorithm which makes
 *         change for an amount of money C with as few coins as possible.
 */
public class MinCoinChange {
	public static int minCoinChange(int[] coins, int target) {
		int[] count = new int[target + 1];
		int coin;
		count[0] = 0;

		for (int i = 1; i <= target; i++) {
			coin = Integer.MAX_VALUE;
			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					coin = Math.min(coin, count[i - coins[j]]);
				}
			}
			if (coin < Integer.MAX_VALUE) {
				count[i] = coin + 1;
			}
		}

		coin = count[target];
		System.out.printf("For $%d, need %d coin(s).\n", target, coin);
		return coin;
	}

	public static void testMinCoinChange() {
		int[] coins = { 1, 5, 10, 20 };
		int target = 217;
		minCoinChange(coins, target);
	}
}
