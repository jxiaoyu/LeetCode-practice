/**
 * 这题真是提交了无数次，完全是靠测试用例来修改代码
 * 逻辑上没什么难点，关键是要把各种情况考虑清楚。一直到最后测试通过我才算把逻辑理清
 */

public class Solution {
    public boolean isNumber(String s) {
        if (s == null) {
            return false;
        }
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        boolean hasDot = false, hasE = false;
        for (int i = 0; i < s.length(); i++) {
            if (!isDigit(s.charAt(i))) {
                if ((s.charAt(i) == '+' || s.charAt(i) == '-') && (i == 0 || lastNDight(s, i, 1) == 'e') && i < s.length() - 1) {
                    continue;
                } else if (s.charAt(i) == '.' && (isDigit(lastNDight(s, i, 1)) || i < s.length() - 1) && !hasDot && !hasE) {
                    hasDot = true;
                    continue;
                } else if (s.charAt(i) == 'e' && (isDigit(lastNDight(s, i, 1)) ||
                        (lastNDight(s, i, 1) == '.' && isDigit(lastNDight(s, i, 2)))) && i < s.length() - 1 && !hasE) {
                    hasE = true;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    private boolean isDigit(Character d) {
        if (d == null) {
            return false;
        }
        int i = d - '0';
        return i >= 0 && i <= 9;
    }

    private Character lastNDight(String s, int cur, int n) {
        if (cur - n >= 0) {
            return s.charAt(cur - n);
        }
        return ' ';
    }
}