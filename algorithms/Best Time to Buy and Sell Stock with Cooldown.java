/**
 * 简单的 dp 问题
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int[] sell = new int[prices.length];
        int[] buy = new int[prices.length];
        buy[0] = -prices[0];
        int max = 0;
        
        for (int i = 1; i < prices.length; i++) {
            buy[i] = -prices[i];
            sell[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i - 1; j++) {
                buy[i] = Math.max(buy[i], sell[j] - prices[i]);
                sell[i] = Math.max(sell[i], buy[j] + prices[i]);
            }
            sell[i] = Math.max(sell[i], buy[i-1] + prices[i]);
            max = Math.max(max, sell[i]);
        }
        return max;
    }
}