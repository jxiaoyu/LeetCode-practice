/**
 * dp 的经典问题 Unique Paths 的基础上稍微改一下就可以了
 */
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] ways = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                if (i - 1 >= 0) {
                    ways[i][j] += ways[i-1][j];
                }
                if (j - 1 >= 0) {
                    ways[i][j] += ways[i][j-1];
                }
                if (i == 0 && j == 0) {
                    ways[i][j] = 1;
                }
            }
        }
        return ways[m-1][n-1];
    }
}