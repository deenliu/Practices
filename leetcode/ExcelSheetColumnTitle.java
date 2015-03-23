package leetcode;

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * 
 * @author deenliu
 *
 */
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		int div, rem;
		StringBuilder sb = new StringBuilder();
		do {
			div = n / 26;
			rem = n % 26;
			if (rem > 0) {
				sb.insert(0, (char) ('A' + rem - 1));
			} else {
				sb.insert(0, 'Z');
				--div;
			}
			n = div;
		} while (n > 0);
		return sb.toString();
	}

	public static void testConvertToTitle() {
		System.out.printf("Title of column %d is %s.\n", 1, convertToTitle(1));
		System.out
				.printf("Title of column %d is %s.\n", 26, convertToTitle(26));
		System.out
				.printf("Title of column %d is %s.\n", 27, convertToTitle(27));
		System.out.printf("Title of column %d is %s.\n", 100,
				convertToTitle(100));
	}
}
