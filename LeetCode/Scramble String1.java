/**
 * 在 Scramble String.java 里已经分析过暴力解法的时间复杂度的 O(2^n), 因为会反复用到、计算一些中间结果，所以可以用 dp
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        if (s1.equals(s2))
            return true;

        int L = s1.length();
        boolean[][][] dp = new boolean[L][L][L];
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++)
                if (s1.charAt(i) == s2.charAt(j))
                    dp[0][i][j] = true;
        }

        for (int k = 2; k <= L; k++) {
            for (int i = L - k; i >= 0; i--) {
                for (int j = L - k; j >= 0; j--) {
                    boolean canScramble = false;
                    for (int m = 1; m < k; m++) {
                        canScramble = (dp[m - 1][i][j] && dp[k - m - 1][i + m][j + m]) || (dp[m - 1][i][j + k -m] && dp[k - m - 1][i + m][j]);
                        if (canScramble)
                            break;
                    }
                    dp[k - 1][i][j] = canScramble;
                }
            }
        }

        return dp[L - 1][0][0];
    }
}