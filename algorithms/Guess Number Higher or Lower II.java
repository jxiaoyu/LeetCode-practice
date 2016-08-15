/**
 * 一开始的想法是二分，在二分的基础上做一些修正
 * 但是推演了 1 到 6 的几种情况，发现不了修正的规律，所以只好遍历
 * 需要 dp 保存结果，避免重复计算
 */
public class Solution {
    
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return solve(1, n, dp);
    }
    
    private int solve(int l, int r, int[][] dp) {
        if (l >= r) {
            return 0;
        }
        if (dp[l][r] != 0) {
            return dp[l][r];
        }
        int min = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            min = Math.min(min, Math.max(solve(l, i - 1, dp), solve(i + 1, r, dp)) + i);
        }
        dp[l][r] = min;
        return min;
    }
}