/**
 * 考布尔代数
 * 还有整数的负数表示是补码的，所以可以这样运算
 */
public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }
}