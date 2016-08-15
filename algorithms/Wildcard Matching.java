/**
 * dp
 */
public class Solution {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        if (s.length() == 0) {
            if (p.length() == 0 || p.equals("*")) {
                return true;
            } else {
                return false;
            }
        }
        if (p.length() == 0) {
            return false;
        }

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*') {
                for (int j = 1; j <= s.length(); j++) {
                    dp[j] = dp[j] || dp[j - 1];
                }
            } else {
                for (int j = s.length(); j >= 1; j--) {
                    if (dp[j-1] && (p.charAt(i) == '?' || s.charAt(j - 1) == p.charAt(i))) {
                        dp[j] = true;
                    } else {
                        dp[j] = false;
                    }
                }
                dp[0] = false;
            }
        }
        return dp[s.length()];
    }
}