/**
 * 贪心算法，求截至位置 i 时所能去到的最远位置
 */
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return true;
        }
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (i == max && nums[i] == 0) {
                return false;
            }
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}