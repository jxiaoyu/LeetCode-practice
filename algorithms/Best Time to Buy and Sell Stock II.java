/** 
 * 一开始看到觉得比 Best Time to Buy and Sell Stock 更容易啊，稍微改一下就提交了，超时了
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}