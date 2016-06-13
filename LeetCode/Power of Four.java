/**
 * Created by river on 2016/6/13.
 */

/**
 * https://segmentfault.com/a/1190000003481153
 * 提供了非循环的解题思路。主要用到了二进制就是以 2 为底的特点
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