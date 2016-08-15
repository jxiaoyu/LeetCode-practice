/**
 * http://www.programcreek.com/2014/03/leetcode-best-time-to-buy-and-sell-stock-iv-java/
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (len < 2 || k <= 0) {
            return 0;
        }
        
        // k >= prices.length / 2 时意味着有足够次交易，变成 Best Time to Buy and Sell Stock II
        if ( k >= prices.length / 2) {
            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                maxProfit += Math.max(0, prices[i] - prices[i-1]);
            }
            return maxProfit;
        }
        
        int[][] local = new int[len][k+1];
    	int[][] global = new int[len][k+1];
        
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i-1];
            for (int j = 1; j <= k; j++) {
                local[i][j] = Math.max(global[i-1][j-1] + Math.max(diff, 0), local[i-1][j] + diff);
                global[i][j] = Math.max(global[i-1][j], local[i][j]);
            }
        }
        return global[len-1][k];
    }
}