package leetcode;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume
 * that the maximum length of S is 1000, and there exists one unique longest
 * palindromic substring.
 * 
 * @author deenliu
 *
 */
public class LongestPalindromicSubstring {
	public static String fromCenter(String s, int left, int right) {
		int l = left;
		int r = right;
		while (l >= 0 && r < s.length()) {
			char lc = s.charAt(l);
			char rc = s.charAt(r);
			if (lc != rc)
				break;
			--l;
			++r;
		}
		if (l == r)
			return s.substring(l, r + 1);
		if (l == r - 1) {
			if (s.charAt(l) == s.charAt(r)) {
				return s.substring(l, r + 1);
			} else {
				return "";
			}
		}
		return s.substring(++l, r);
	}

	public static String longestPalindrome(String s) {
		int len = s.length();
		int left = 0, right = 0;
		String longest = "";
		int maxLen = 0;
		while (left < len && right < len) {
			String current = fromCenter(s, left, right);
			if (current.length() > maxLen) {
				maxLen = current.length();
				longest = current;
			}
			if (left == right) {
				++right;
			} else {
				++left;
			}
		}
		return longest;
	}

	public static void testLongestPalindrome() {
		String s;
		s = "";
		System.out.printf(
				"The longest palindrome substring of \"%s\" is \"%s\".\n", s,
				longestPalindrome(s));
		s = "a";
		System.out.printf(
				"The longest palindrome substring of \"%s\" is \"%s\".\n", s,
				longestPalindrome(s));
		s = "abb";
		System.out.printf(
				"The longest palindrome substring of \"%s\" is \"%s\".\n", s,
				longestPalindrome(s));
		s = "dasuiewabbbccbbbadjhkag";
		System.out.printf(
				"The longest palindrome substring of \"%s\" is \"%s\".\n", s,
				longestPalindrome(s));
	}
}
