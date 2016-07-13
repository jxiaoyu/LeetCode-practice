/**
 * 找两次
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length - 1, n = matrix[0].length - 1;
        int l = 0, r = m;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (target == matrix[mid][n]) {
                return true;
            }
            if (target < matrix[mid][n]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        
        int subl = 0, subr = n;
        while (subl <= subr) {
            if (subl == subr) {
                return target == matrix[l][subl];
            }
            int mid = subl + (subr - subl) / 2;
            if (target == matrix[l][mid]) {
                return true;
            }
            if (target < matrix[l][mid]) {
                subr = mid;
            } else {
                subl = mid + 1;
            }
        }
        return false;
    }
}