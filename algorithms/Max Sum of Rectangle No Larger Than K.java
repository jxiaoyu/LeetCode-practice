/**
 * 最朴素的思路是枚举所有的矩阵，时间复杂度 O(m^2)*O(n^2)
 * 一个维度枚举 O(m^2)，另一维度可以优化成 O(nlgn)
 * 思路参考 https://discuss.leetcode.com/topic/48854/java-binary-search-solution-time-complexity-min-m-n-2-max-m-n-log-max-m-n
 */
public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int m = Math.max(row, col), n = Math.min(row, col);
        boolean colIsBig = col > row;

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int[] array = new int[m];
            for (int j = i; j >= 0; j--) {
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                int sum = 0;
                for (int x = 0; x < m; x++) {
                    array[x] += (colIsBig ? matrix[j][x] : matrix[x][j]);
                    sum += array[x];
                    Integer subRes = set.ceiling(sum - k);
                    if (subRes != null) {
                        res = Math.max(res, sum - subRes);
                    }
                    set.add(sum);
                }
            }
        }
        return res;
    }
}