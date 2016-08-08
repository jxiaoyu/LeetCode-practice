/**
 * https://discuss.leetcode.com/topic/41464/step-by-step-explanation-of-index-mapping-in-java
 */
public class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {
            if (nums[newIndex(i, n)] > median) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
        return;
    }

    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }

    private int findKthLargest(int[] nums, int k) {
        //find kth largest is to find (n-k+1)th smallest.
        return helper(nums, nums.length - k, 0, nums.length - 1);
    }

    private int helper(int[] nums, int k, int low, int high) {
        int mid = partition(nums, low, high);
        if (mid == k) return nums[mid];
        else if (mid > k) return helper(nums, k, low, mid - 1);
        else return helper(nums, k, mid + 1, high);
    }

    private int partition(int[] nums, int low, int high) {
        if (low == high) return low;
        int pivot = nums[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, high);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}