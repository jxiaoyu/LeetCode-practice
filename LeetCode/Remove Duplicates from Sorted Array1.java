/**
 * 两个指针，一个按顺序遍历，另一个保存新数组的进度
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int i = 1, j = 1;
        while (j < nums.length) {
            if (nums[j] != nums[j-1]) {
                nums[i++] = nums[j];
            }
            j++;
        }
        return i;
    }
}