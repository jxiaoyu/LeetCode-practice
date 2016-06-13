/**
 * Created by river on 2016/6/13.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        // 注意1：对负数的处理。power of 4 是正数
        while (true) {
            if (num == 1) {
                return true;
            }
            if (num < 4) {
                return false;
            }
            if (num % 4 > 0) {
                return false;
            }
            num = num / 4;
        }
    }
}