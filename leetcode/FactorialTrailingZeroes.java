package leetcode;
/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * @author deenliu
 *
 */
public class FactorialTrailingZeroes {
	public static int trailingZeroes(int n) {
        int i = 0;
        int k = 1;
        while (Math.pow(5, k) <= n) {
            i += n/(Math.pow(5, k));
            k++;
        }
        return i;
    }
	
	public static void testTrailingZeroes() {
		System.out.printf("Trailing zeroes of 0! is %d.\n", trailingZeroes(0));
		System.out.printf("Trailing zeroes of 4! is %d.\n", trailingZeroes(4));
		System.out.printf("Trailing zeroes of 5! is %d.\n", trailingZeroes(5));
		System.out.printf("Trailing zeroes of 10! is %d.\n", trailingZeroes(10));
		System.out.printf("Trailing zeroes of 100! is %d.\n", trailingZeroes(100));
	}
}
