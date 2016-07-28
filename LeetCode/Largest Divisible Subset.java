/**
 * dp[i] 保存 nums[i] 在 set 中且当前的最大 Subset
 */
public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length < 1) {
            return list;
        }
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxIndex = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        list.add(nums[maxIndex]);
        for (int i = maxIndex - 1; i >= 0; i--) {
            if (nums[maxIndex] % nums[i] == 0 && dp[i] == dp[maxIndex] - 1) {
                list.add(nums[i]);
                maxIndex = i;
            }
        }
        return list;
    }
}