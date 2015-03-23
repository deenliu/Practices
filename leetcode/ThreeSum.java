package leetcode;

import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a +
 * b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 * 
 * @author deenliu
 *
 */
public class ThreeSum {
	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		if (num.length < 3) {
			return ret;
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length; i++) {
			int left = i + 1;
			int right = num.length - 1;
			int target = 0 - num[i];
			// avoid duplicate
			if (i == 0 || num[i] > num[i - 1]) {
				while (left < right) {
					if (num[left] + num[right] == target) {
						ArrayList<Integer> com = new ArrayList<Integer>();
						com.add(num[i]);
						com.add(num[left]);
						com.add(num[right]);
						ret.add(com);

						++left;
						--right;
						// avoid duplication
						while (num[left] == num[left - 1] && left < right) {
							++left;
						}
						// avoid duplicate
						while (num[right] == num[right + 1] && left < right) {
							--right;
						}
					} else if (num[left] + num[right] < target) {
						++left;
					} else {
						--right;
					}
				}
			}
		}
		return ret;
	}
}
