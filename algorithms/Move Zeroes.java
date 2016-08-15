public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null) {
            return;
        }
        int i = 0, j = 0;
        while (j <= nums.length - 1) {
            if (nums[i] == 0 && nums[j] != 0) {
                int tmp = nums[j];
                nums[j] = nums[i];
                nums[i] = tmp;
                i++;
                j++;
                continue;
            }
            if (nums[i] == 0) {
                j++;
                continue;
            } else if (++i >= j) {
                j++;
            }
        }
    }
}