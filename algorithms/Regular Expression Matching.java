/**
 * 思路跟 Wildcard Matching 是一样的，关键是考虑清楚递推关系和边界情况
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0 && p.length() == 0) {
            return true;
        }
        if (p.length() == 0) {
            return false;
        }

        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        dp[0][0] = true;

        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) == '*') {
                dp[i][0] = dp[i-2][0];
            }
            for (int j = 1; j <= s.length(); j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i-2][j] || (dp[i][j-1] && (p.charAt(i - 2) == '.' || s.charAt(j - 1) == p.charAt(i - 2)));
                } else {
                    dp[i][j] = dp[i-1][j-1] && (p.charAt(i - 1) == '.' || p.charAt(i - 1) == s.charAt(j - 1));
                }
            }
        }
        return dp[p.length()][s.length()];
    }
}