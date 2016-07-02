public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
                continue;
            }
            nums[i] = nums[j];
            j--;
        }
        return j + 1;
    }
}