/**
 * 注意 reverse 后整数溢出的问题
 */
public class Solution {
    public int reverse(int x) {
        int val = Math.abs(x), num = 0;
        while (val > 0) {
            num = num * 10 + val;
            val /= 10;
        }
        if (x < 0) {
            num = -num;
        }
        if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)num;
    }
}