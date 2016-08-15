/**
 * 一开始想到是 dfs
 * 后来想到只要前两个数确定了，后面就定了。时间复杂度 O(n^2)
 */
public class Solution {
    public boolean isAdditiveNumber(String num) {
        int L = num.length();

        for (int i = 1; i <= (L - 1) / 2; i++) {
            if (num.charAt(0) == '0' && i >= 2) break;

            for (int j = i + 1; L - j >= j - i && L - j >= i; j++) {
                if (num.charAt(i) == '0' && j - i >= 2) break;

                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                String substr = num.substring(j);

                if (isAdditive(substr, num1, num2)) return true;
            }
        }
        return false;
    }

    public boolean isAdditive(String str, long num1, long num2) {
        if (str.equals("")) return true;

        long sum = num1 + num2;
        String s = ((Long) sum).toString();
        if (!str.startsWith(s)) return false;

        return isAdditive(str.substring(s.length()), num2, sum);
    }
}
