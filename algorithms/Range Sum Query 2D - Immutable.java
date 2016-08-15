/**
 * Range Sum Query - Immutable 的思路
 */
public class NumMatrix {
    
    private int[][] sum;

    public NumMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0|| matrix[0].length == 0) {
            return;
        }
        int m = matrix.length, n = matrix[0].length;
        sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                if (i == 0) {
                    sum[i][j] = rowSum;
                } else {
                    sum[i][j] = sum[i-1][j] + rowSum;
                }
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int result = sum[row2][col2];
        if (row1 > 0) {
            result -= sum[row1-1][col2];
        }
        if (col1 > 0) {
            result -= sum[row2][col1-1];
        }
        if (row1 > 0 && col1 > 0) {
            result += sum[row1-1][col1-1];
        }
        return result;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);