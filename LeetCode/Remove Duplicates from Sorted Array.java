public class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums.length && j < nums.length) {
            if (set.add(nums[i])) {
                i++;
                continue;
            } else if (j <= i) {
                j = i + 1;
                continue;
            } else if (!set.contains(nums[j])) {
                nums[i] = nums[j];
                set.add(nums[i]);
                i++;
            }
            j++;
        }
        return i;
    }
}