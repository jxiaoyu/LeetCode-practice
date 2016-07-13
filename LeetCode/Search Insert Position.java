/**
 * binary search
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        return searchInsertHelper(nums, target, 0, nums.length - 1);
    }
    
    private int searchInsertHelper(int[] nums, int target, int left, int right) {
        if (left >= right) {
            if (target <= nums[left]) {
                return left;
            } else {
                return left + 1;
            }
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            return searchInsertHelper(nums, target, mid + 1, right);
        } else {
            return searchInsertHelper(nums, target, left, mid - 1);
        }
    }
}