/**
 * 因为最多两组，可以把数组拆成两部分。左右部分就是 Best Time to Buy and Sell Stock 问题了
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        int[] left = new int[len+1];
        int[] right = new int[len+1];

        int min = prices[0];
        for (int i = 2; i < len + 1; i++) {
            left[i] = Math.max(prices[i-1] - min, left[i-1]);
            min = Math.min(min, prices[i-1]);
        }

        int max = prices[len-1];
        for (int i = 2; i < len + 1; i++) {
            int index = len - i;
            right[i] = Math.max(max - prices[index], right[i-1]);
            max = Math.max(max, prices[index]);
        }

        int profit = 0;
        for (int i = 0; i < len + 1; i++) {
            profit = Math.max(profit, left[i] + right[len-i]);
        }
        return profit;
    }
}