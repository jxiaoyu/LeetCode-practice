/** 
 * 假设当前区间是 [1, right], 若 nums[i] 比 right + 1 小，那么 nums[i] 加入后区间变为 [1, right + nums[i]]
 * 若 nums[i] 比 right + 1 大，那么如果 nums[i] 加入 [right + 1, nums[i]-1] 这个区间的数是无法表示的，这时候就应该引入 right + 1 这个数
 */
public class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0, i = 0;
        long right = 0;
        
        while (right < n) {
            if (i < nums.length && nums[i] <= right + 1) {
                right += nums[i++];
            } else {
                right += (right + 1);
                count++;
            }
        }
        return count;
    }
}