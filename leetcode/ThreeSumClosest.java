package leetcode;

import java.util.*;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] num, int target) {
        int closestSum = 0;
        int minDiff = Integer.MAX_VALUE;
        if (num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        for(int i = 0; i < num.length; i ++) {
            int left = i + 1;
            int right = num.length - 1;
            while (left < right) {
                int sum = num[i] + num[left] + num[right];
                int diff = sum < target ? target - sum : sum - target;
                if (diff == 0) {
                    return sum;
                }
                if (diff < minDiff) {
                    minDiff = diff;
                    closestSum = num[i] + num[left] + num[right];
                }
                if (sum < target) {
                    ++left;
                } else {
                    --right;
                }
            }
        }
        return closestSum;
    }
}
