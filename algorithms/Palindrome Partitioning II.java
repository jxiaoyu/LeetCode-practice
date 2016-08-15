/**
 * 之前已经总结过了对于像 Palindrome Partitioning 那种要求出所有解的题目，遍历是必须的，这里把 I 稍微改一下提交果不其然超时了
 * 分两步
 * 1. 用 dp 求出任意一个区间是否是回文，后面用到的时候不用像 I 那样每次都计算一遍
 * 2. 用 dp 求出到当前字符所需的最小切分数。这比 dfs 的时间复杂度小
 * 
 * 想不清楚可以分两步写，写完发现可以整合在一起
 */
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][0] = true;
        int[] cut = new int[s.length()];
        for (int j = 1; j < s.length(); j++) {
            cut[j] = j;
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && (i + 1 >= j || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if (i == 0) {
                        cut[j] = 0;
                    } else {
                        cut[j] = Math.min(cut[j], cut[i-1] + 1);
                    }
                }
            }
        }
        return cut[s.length()-1];
    }
}