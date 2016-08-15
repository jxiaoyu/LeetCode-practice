/**
 * dp
 */
public class Solution {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];

        int p = 1;
        int pow = 1;
        for (int i = 1; i <= num; i++) {
            if (i == pow) {
                dp[i] = 1;
                pow <<= 1;
                p = 1;
            } else {
                dp[i] = dp[p] + 1;
                p++;
            }
        }

        return dp;
    }
}