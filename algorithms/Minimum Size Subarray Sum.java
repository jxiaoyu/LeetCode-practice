/**
 * two points + sliding window
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE, l = 0, r = 0, sum = 0;
        boolean exist = false;
        while (r < nums.length || sum >= s) {
            if (sum < s) {
                sum += nums[r++];
            } else {
                exist = true;
                min = Math.min(min, r - l);
                sum -= nums[l++];
            }
        }
        if (exist) {
            return min;
        }
        return 0;
    }
}