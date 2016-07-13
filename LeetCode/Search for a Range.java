/**
 * 用 First Bad Version 的思路分别找到第一个和最后一个 target
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = {-1, -1};
        if (nums == null || nums.length == 0) {
            return range;
        }
        range[0] = firstTarget(nums, target);
        range[1] = lastTarget(nums, target);
        return range;
    }
    
    private int firstTarget(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (true) {
            if (left == right) {
                if (nums[left] == target) {
                    return left;
                } else {
                    return -1;
                }
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
    }
    
    private int lastTarget(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (true) {
            if (left == right) {
                if (nums[left] == target) {
                    return left;
                } else {
                    return -1;
                }
            }
            int mid = right - (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
    }
}