/*
 *难点在于各种 edge case 的考虑
 *空格，非数字字符
 *以及数超出 int 型
 */
public class Solution {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        boolean positive = true;
        double num = 0;
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(0) == '-') {
                positive = false;
            } else if (i == 0 && str.charAt(0) == '+') {
                positive = true;
            } else {
                int d = str.charAt(i) - '0';
                if (d < 0 || d > 9) {
                    break;
                }
                num = num * 10 + d;
            }
        }
        if (!positive) {
            num = -num;
        }
        if (num > Integer.MAX_VALUE) {
            num = Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            num = Integer.MIN_VALUE;
        }
        return (int)num;
    }
}