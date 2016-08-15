/**
 * LIS 问题有两种解法：dp 和 二分搜索
 * dp 的时间复杂度是 O(n^2)，二分的时间复杂度是 O(nlgn)
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }
}