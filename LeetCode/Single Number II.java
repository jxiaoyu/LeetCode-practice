/**
 * 跟 Single Number 思路差不多
 */
public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        for (; i < nums.length; i += 3) {
            if (i + 2 >= nums.length || nums[i] != nums[i+2]) {
                break;
            }
        }
        return nums[i];
    }
}