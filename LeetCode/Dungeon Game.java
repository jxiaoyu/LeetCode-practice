/**
 * dp 问题，这题要注意的是跟之前的棋盘问题不同。确定的是最后格的状态倒推初始格的状态
 */

public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] status = new int[m][n];
        status[m-1][n-1] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i + 1 < m) {
                    status[i][j] = Math.max(status[i+1][j] - dungeon[i+1][j], 1);
                }
                if (j + 1 < n && (status[i][j+1] - dungeon[i][j+1] < status[i][j] || status[i][j] == 0)) {
                    status[i][j] = Math.max(status[i][j+1] - dungeon[i][j+1], 1);
                }
            }
        }
        return Math.max(status[0][0] - dungeon[0][0], 1);
    }
}