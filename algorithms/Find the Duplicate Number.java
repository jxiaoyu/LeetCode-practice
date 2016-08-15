/**
 * 鸽笼原理 + 二分法
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l < r) {
            int count = 0, mid = l + (r - l) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] >= l && nums[i] <= mid) {
                    count++;
                }
            }
            if (count > mid - l + 1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}