/**
 * Largest Sum of Contiguous Subarray
 * 
 * @author deenliu
 * 
 *         Given a sequence of n real numbers A(1) ... A(n), determine a
 *         contiguous subsequence A(i) ... A(j) for which the sum of elements in
 *         the subsequence is maximized.
 *
 */
public class LargestSumContiguousSubarray {

	public static int largestSumContiguousSubarray(int data[], int size) {
		int max = 0;
		int currentMax = 0;

		int start = 0, end = 0;
		for (int i = 0, j = 0; i < size; i++) {
			if (currentMax <= 0) {
				currentMax = data[i];
				j = i;
			} else {
				currentMax += data[i];
			}
			if (currentMax > max) {
				max = currentMax;
				start = j;
				end = i;
			}
		}
		System.out.printf("The largest sum of contiguous subarray is %d.\n",
				max);
		System.out.printf("It is from %d to %d.\n\n", start, end);
		return max;
	}

	public static void testLSCS() {
		int[] A = { -2, 11, -4, 13, -5, 2 };
		int[] B = { -15, 29, -36, 3, -22, 11, 19, -5 };
		largestSumContiguousSubarray(A, A.length);
		largestSumContiguousSubarray(B, B.length);
	}

}
