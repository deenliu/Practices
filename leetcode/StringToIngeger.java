package leetcode;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 * 
 * @author deenliu
 *
 */
public class StringToIngeger {
	public static int atoi(String str) {
		if (str.length() < 1) {
			return 0;
		}
		long ret = 0;
		boolean postive = true;
		int i = 0;
		for (i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ')
				break;
		}
		if (str.charAt(i) == '-') {
			postive = false;
			i++;
		} else if (str.charAt(i) == '+') {
			i++;
		}
		for (; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				ret = ret * 10 + Character.getNumericValue(str.charAt(i));
				if (postive && ret > Integer.MAX_VALUE) {
					return Integer.MAX_VALUE;
				}
				if (!postive && (0 - ret) < Integer.MIN_VALUE) {
					return Integer.MIN_VALUE;
				}
			} else {
				break;
			}
		}
		if (!postive) {
			ret = 0 - ret;
		}
		return (int) ret;
	}
}
