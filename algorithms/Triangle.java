/**
 * dp
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int[] dp = new int[triangle.size()];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = row.size() - 1; j >= 0; j--) {
                if (j == row.size() - 1) {
                    dp[j] = dp[j-1] + row.get(j);
                } else if (j == 0) {
                    dp[j] = dp[j] + row.get(j);
                } else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + row.get(j);
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            result = Math.min(result, dp[i]);
        }
        return result;
    }
}