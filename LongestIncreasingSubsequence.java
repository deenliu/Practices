/**
 * Longest Increasing Subsequence
 * 
 * @author deenliu
 *
 *         Given a sequence of n real numbers A(1) ... A(n), determine a
 *         subsequence (not necessarily contiguous) of maximum length in which
 *         the values in the subsequence form a strictly increasing sequence.
 *
 */
public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int[] data, int size) {
		int increasingLength = 0;
		int start = 0;
		int end = 0;
		int j, pre;
		for (int i = 0; i < data.length; i = j + 1) {
			pre = data[i];
			for (j = i + 1; j < data.length; j++) {
				if (data[j] <= pre) {
					break;
				} else {
					pre = data[j];
				}
			}
			if (j - i > increasingLength) {
				increasingLength = j - i;
				start = i;
				end = j - 1;
			}
		}
		System.out.printf(
				"The longest increasing subsequence is from %d to %d.\n",
				data[start], data[end]);
		System.out.printf("The length of LIS is %d.\n", increasingLength);

		return increasingLength;
	}

	public static void testLongestIncreasingSubsequence() {
		int[] data = { 1, 0, -1, 2, 3, 4, 2, 2, 3, 9 };
		int size = data.length;
		longestIncreasingSubsequence(data, size);
	}
}
