public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n <= 0) {
            return matrix;
        }
        int rowBegin = 0, rowEnd = n - 1, colBegin = 0, colEnd = n - 1;
        int cur = 1;

        while (cur <= n * n) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j++) {
                matrix[rowBegin][j] = cur++;
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j++) {
                matrix[j][colEnd] = cur++;
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    matrix[rowEnd][j] = cur++;
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    matrix[j][colBegin] = cur++;
                }
            }
            colBegin++;
        }

        return matrix;
    }
}