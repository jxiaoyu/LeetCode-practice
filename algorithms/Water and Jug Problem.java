/**
 * 题解 https://discuss.leetcode.com/topic/49751/clear-explanation-of-why-using-gcd
 */
public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        return x + y == z || (x + y > z ) && z % gcd(x,y) == 0;
    }
    
    private int gcd(int a,int b){
        return b==0 ? a: gcd(b, a % b);
    }
}