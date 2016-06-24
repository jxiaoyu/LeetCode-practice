/**
 * 转化为 dp 问题
 */
public class Solution {
    public int numTrees(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[i-1-j] * dp[j];
            }
        }
        return dp[n];
    }
}