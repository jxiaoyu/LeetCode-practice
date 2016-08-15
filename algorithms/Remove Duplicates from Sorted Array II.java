/**
 * 一开始沿用了 Remove Duplicates from Sorted Array 的思路，比较 nums[j] 和 nums[j-2] 的异同 
 * 发现新数组的数据影响到原数组了，in place 的做法要小心这点
 * 然后就引入一个变量有计数重复的个数
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int i = 1, j = 1, count = 1;
        while (j < nums.length) {
            if (nums[j] != nums[j-1]) {
                nums[i++] = nums[j];
                count = 1;
            } else {
                if (++count <= 2) {
                    nums[i++] = nums[j];
                }
            }
            j++;
        }
        return i;
    }
}