public class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int index = nums[i] - 1;
            while (index != i) {
                if (index < 0 || index >= n) {
                    break;
                }
                if (nums[i] == nums[index]) {
                    break;
                }
                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
                index = nums[i] - 1;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i)
                return i + 1;
        }
        return n + 1;
    }
}
