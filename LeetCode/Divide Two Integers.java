/**
 * 注意 -2147483648 1 也是个 edge case，但是恰巧这个 case 可以过
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (divisor == -1 && dividend == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = false;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            isNegative = true;
        }
        long dvd = Math.abs((long)dividend), dvs = Math.abs((long)divisor);
        int i = 0, result = 0;

        while (dvd >= dvs << (i + 1)) {
            i++;
        }

        while (dvd >= dvs) {
            if (dvd >= dvs << i) {
                result += 1 << i;
                dvd -= dvs << i;
            }
            i--;
        }
        if (isNegative) {
            result = -result;
        }
        return result;
    }
}