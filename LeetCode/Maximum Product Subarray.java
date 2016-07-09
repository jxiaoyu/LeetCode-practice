/**
 * dp 问题，跟 Maximum Subarray 有点像
 */
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] minDp = new int[nums.length];
        int[] maxDp = new int[nums.length];
        minDp[0] = maxDp[0] = nums[0];
        int result = maxDp[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                minDp[i] = Math.min(minDp[i-1] * nums[i], nums[i]);
                maxDp[i] = Math.max(maxDp[i-1] * nums[i], nums[i]);
            } else {
                maxDp[i] = Math.max(minDp[i-1] * nums[i], nums[i]);
                minDp[i] = Math.min(maxDp[i-1] * nums[i], nums[i]);
            }
            if (maxDp[i] > result) {
                result = maxDp[i];
            }
        }
        return result;
    }
}