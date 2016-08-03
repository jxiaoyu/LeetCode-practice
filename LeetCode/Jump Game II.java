/**
 * 贪心算法，求对于步数 jump 所能去到的最远距离
 */
public class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        int jump = 0;
        int max = 0, curReach = 0;

        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                break;
            }
            if (i == curReach) {
                jump++;
                curReach = max;
            }
        }
        return jump + 1;
    }
}