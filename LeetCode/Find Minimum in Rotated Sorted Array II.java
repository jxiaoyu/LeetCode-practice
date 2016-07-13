/**
 * 在 Find Minimum in Rotated Sorted Array 的基础上修改一下
 * 时间复杂度极端情况下会变成 O(n)
 */
public class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if (nums[l] < nums[r]) {
            return nums[l];
        }
        return findMinHelper(nums, l, r);
    }
    
    private int findMinHelper(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] > nums[r]) {
            return findMinHelper(nums, mid + 1, r);
        } else if (nums[mid] < nums[r]) {
            return findMinHelper(nums, l, mid);
        } else {
            return Math.min(findMinHelper(nums, mid + 1, r), findMinHelper(nums, l, mid));
        }
    }
}