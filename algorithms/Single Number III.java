/**
 * 三题都是一样的思路
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int [] result = new int[2];
        int i = 0, j = 0;
        while (i < nums.length) {
            if (i + 1 >= nums.length || nums[i] != nums[i+1]) {
                result[j++] = nums[i];
                i++;
            } else {
                i += 2;
            }
        }
        return result;
    }
}