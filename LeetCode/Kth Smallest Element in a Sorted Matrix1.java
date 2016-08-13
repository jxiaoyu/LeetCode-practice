/**
 * 二分查找的思路，和 Search a 2D Matrix II 对比看
 * 时间复杂度 O(nlgn)
 */
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int lower = matrix[0][0];
        int upper = matrix[m - 1][m - 1];

        while (lower < upper) {
            int mid = lower + ((upper - lower) >> 1);
            int count = count(matrix, mid);
            if (count < k) {
                lower = mid + 1;
            } else {
                upper = mid;
            }
        }

        return upper;
    }

    private int count(int[][] matrix, int target) {
        int m = matrix.length;
        int i = m - 1;
        int j = 0;
        int count = 0;

        while (i >= 0 && j < m) {
            if (matrix[i][j] <= target) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }

        return count;
    }
}