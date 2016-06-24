/**
 * 转化为 dp 问题的关键在于，bst 树数量只跟节点数有关，而不用管这些节点是什么
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