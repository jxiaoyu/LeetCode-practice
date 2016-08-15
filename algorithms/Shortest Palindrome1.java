/**
 * 这是一开始的思路 dp
 * 但是过一个很长的字符的测试用例的时候，内存超了
 * 总结一下，dp 的时间和空间复杂度通常是 O(n) 或 O(n^2)（通常是一维或二维 dp），
 * 时间复杂度一般没问题，但也要注意下空间复杂度
 */
public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        
        int left = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        for (int j = 1; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 >= j || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (i == 0) {
                        left = j;
                    }
                }
            }
        }
        if (left == s.length() - 1) {
            return s;
        }
        return new StringBuilder(s.substring(left + 1)).reverse().toString() + s;
    }
}