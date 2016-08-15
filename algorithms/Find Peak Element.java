/**
 * 这题最直接想到的思路当然是遍历
 * 但是可以二分查找
 */
public class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left != right) {
            int mid = left + (right - left) / 2;
            if (nums[mid+1] > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}