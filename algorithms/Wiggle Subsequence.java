/**
 * 这种问题很容易想到 dp，但是 dp 在这里的时间复杂度为 O(n^2)
 * 
 * 思路见 http://www.programcreek.com/2014/07/leetcode-wiggle-subsequence-java/
 * 画个图看看会比较清楚
 */
public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        
        int count = 1, i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
                continue;
            }
            if (nums[j] > nums[i]) {
                while (j + 1 < nums.length && nums[j+1] >= nums[j]) {
                    j++;
                }
            } else {
                while (j + 1 < nums.length && nums[j+1] <= nums[j]) {
                    j++;
                }
            }
            count++;
            i = j;
            j = i + 1;
        }
        return count;
    }
}