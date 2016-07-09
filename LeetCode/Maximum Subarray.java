/**
 * 先把数组求个和，然后就转换成 Best Time to Buy and Sell Stock 问题了
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        int min = sums[0], max = Integer.MIN_VALUE;
        for (int i = 1; i < sums.length; i++) {
            max = Math.max(max, sums[i] - min);
            if (sums[i] < min) {
                min = sums[i];
            }
        }
        return max;
    }
}