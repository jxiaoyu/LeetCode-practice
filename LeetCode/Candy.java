/**
 * 从左到右，假设第i个小孩的等级比第i - 1个小孩高，那么第i的小孩的糖果数量就是第i - 1个小孩糖果数量在加一
 * 再从右到左，如果第i个小孩的等级大于第i + 1个小孩，同时第i个小孩此时的糖果数量小于第i + 1的小孩，那么第i个小孩的糖果数量就是第i + 1个小孩的糖果数量加一
 */
public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        
        int[] candies = new int[ratings.length];
        candies[0] = 1;
     
        //from let to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else { 
                // if not ascending, assign 1
                candies[i] = 1;
            }
        }
     
        int result = candies[ratings.length - 1];
     
        //from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if (ratings[i] > ratings[i + 1]) {
                cur = candies[i + 1] + 1;
            }
     
            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }
     
        return result;
    }
}