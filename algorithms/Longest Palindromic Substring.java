public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        String longStr = s.substring(0, 1);
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int j = 1; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 >= j || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (j - i + 1 > longStr.length()) {
                        longStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longStr;
    }
}