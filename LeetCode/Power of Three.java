/**
 * Created by river on 2016/6/12.
 */
public class Solution {
    public boolean isPowerOfThree(int n) {
        /**
         * 思路就是求对数，但是没有相应的方法，所以用了换底公式
         * 要注意的是对对数的结果要取整
         * 解法速度并不快，经测不如循环
         */
        return n > 0 && n == Math.pow(3, Math.round((Math.log(n) / Math.log(3))));
    }
}