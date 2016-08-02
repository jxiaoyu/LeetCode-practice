/**
 * 最开始想到的思路就是遍历 matrix，用两个数组，分别记录列和行是否有零，然后再遍历一遍，根据记录置为零即可
 * follow up 里说能不能用常数的空间呢？
 * 为了这个目的，用 matrix 的第一行和第一列还记录列和行是否有零，然后两个变量记录第一行和第一列的状态即可
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ;
        }
        int m = matrix.length, n = matrix[0].length;
        boolean rowHasZero = false, columnHasZero = false;
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (columnHasZero) {
            for(int i = 0; i < matrix.length; i++)
                matrix[i][0] = 0;
        }
 
        if (rowHasZero) {
            for(int i = 0; i < matrix[0].length; i++)
                matrix[0][i] = 0;
        }
    }
}