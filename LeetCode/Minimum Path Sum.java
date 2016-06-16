/**
 * dp 的经典问题 Unique Paths 的基础上稍微改一下就可以了
 */

public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] sums = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i - 1 >= 0) {
                    sums[i][j] = sums[i-1][j] + grid[i][j];
                }
                if (j - 1 >= 0 && (sums[i][j-1] + grid[i][j] < sums[i][j] || sums[i][j] == 0)) {
                    sums[i][j] = sums[i][j-1] + grid[i][j];
                }
                if (i == 0 && j == 0) {
                    sums[i][j] = grid[i][j];
                }
            }
        }
        return sums[m-1][n-1];

    }
}