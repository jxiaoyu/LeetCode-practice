/**
 * dp 问题，不过要注意特殊情况的处理
 */

public class Solution {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] records = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int val = records[j] * records[i-j];
                if (val > records[i]) {
                    records[i] = val;
                }
            }
            if (i != n && records[i] < i) {
                records[i] = i;
            }
        }
        return records[n];
    }
}