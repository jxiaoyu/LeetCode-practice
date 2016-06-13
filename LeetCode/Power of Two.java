/**
 * Created by river on 2016/6/12.
 */
public class Solution {

    public boolean isPowerOfTwo(int n) {
        // 技巧1：二进制就是以 2 为底
        return n > 0 && (n & (n - 1)) == 0;
    }
}