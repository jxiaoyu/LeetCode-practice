/**
 * 一开始以为可以延续 Maximal Square 的思路，用二维数组保存当前最大 rect 的 w, h, dp 求最大的 w, h
 * 后来发现这个思路和递推关系是不对的
 * 
 * 思路见 http://www.cnblogs.com/TenosDoIt/p/3454877.html
 */
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][n-1] = matrix[i][n-1] == '1' ? 1 : 0;
            for (int j = n - 2; j >= 0; j--) {
                dp[i][j] = matrix[i][j] == '1' ? dp[i][j+1] + 1 : 0;
            }
        }

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //剪枝
                if ((m - i) * (n - j) <= max) {
                    break;
                }
                int w = Integer.MAX_VALUE;
                for (int k = i; k < m; k++) {
                    w = Math.min(w, dp[k][j]);
                    max = Math.max(max, w * (k - i + 1));
                }
            }
        }
        return max;
    }
}