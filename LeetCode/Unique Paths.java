/**
 * dp 的经典题目
 */

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];
        ways[0][0] = 1;
        return uniquePathsHelper(m, n , ways);
    }

    private int uniquePathsHelper(int m, int n, int[][] ways) {
        if (m - 1 < 0 || n -1 < 0) {
            return 0;
        }
        if (ways[m-1][n-1] > 0) {
            return ways[m-1][n-1];
        }
        int counts = uniquePathsHelper(m - 1, n, ways) + uniquePathsHelper(m, n - 1, ways);
        ways[m-1][n-1] = counts;
        return counts;
    }
}