/**
 * dp
 * 需要注意的是 val 会溢出，而且溢出不一定是负数，而可能是恰巧符合要求的数。所以用 long 型
 */

public class Solution {
    public int nthUglyNumber(int n) {
        int[] fac = {2, 3, 5};
        int[] seq = new int[n];
        seq[0] = 1;
        for (int i = 1; i < n; i++) {
            long min = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                long val = 0;
                int k = 0;
                for (; k < 3; k++) {
                    val = (long)seq[j] * fac[k];
                    if (val > seq[i-1] && val < min) {
                        min = val;
                        break;
                    }
                }
                if (k == 3 && val <= seq[i-1]) {
                    break;
                }
            }
            seq[i] = (int)min;
        }
        return seq[n-1];
    }
}