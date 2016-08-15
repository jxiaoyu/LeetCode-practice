/**
 * 字符串相关的子串，子序列的问题还是蛮折磨人的，一直觉得没搞清楚
 * 看到这题比较像 lcs 问题，复习了下该问题，然后想到了 dp 的解法就不难了
 */
public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null || s.length() * t.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][t.length()];
        if (s.charAt(0) == t.charAt(0)) {
            dp[0][0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    if (j - 1 >= 0) {
                        dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
                    } else {
                        dp[i][j] = dp[i-1][j] + 1;
                    }
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length()-1][t.length()-1];
    }
}