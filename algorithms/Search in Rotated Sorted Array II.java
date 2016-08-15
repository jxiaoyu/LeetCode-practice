public class Solution {
    public boolean search(int[] nums, int target) {
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    private boolean searchHelper(int[] nums, int target, int l, int r) {
        if (l >= r) {
            return nums[l] == target;
        }
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[l] == nums[r]) {
            return searchHelper(nums, target, l, mid - 1) || searchHelper(nums, target, mid + 1, r);
        } else if (nums[l] < nums[r]) {
            if (target < nums[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        } else {
            if (nums[mid] > nums[r]) {
                if (target > nums[r] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target < nums[l] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return searchHelper(nums, target, l, r);
    }
}