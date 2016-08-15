/**
 * 设 s 的左起最长回文子串为 P，剩下的为 A。把 s 翻转一下加到 s 的右边就是 PAA'P (A' 为 A 的翻转)，A'PA 就是要求的最短回文串
 * 现在就是要求出 P 的长度，然后就可求出 A'
 * 用 kmp table 的思想求出 P 的长度
 */
public class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        if (isPalindrome(new StringBuilder(s))) {
            return s;
        }
        int len = s.length();
        String revStr = new StringBuilder(s).reverse().toString();
        int[] table = kmpTable(s + + '#' + revStr);
        String res = revStr.substring(0, len - table[table.length-1]) + s;
        return res;
    }

    int[] kmpTable(String p) {
        // 一开始是声明 p.length() 长度的数组来表示相应位的状态，但是 table[1] = 1，所以就一直循环
        int[] table = new int[p.length()+1];
        int i = 2, cnt = 0;
        while (i <= p.length()) {
            if (p.charAt(i - 1) == p.charAt(cnt)) {
                table[i++] = ++cnt;
            } else if (cnt > 0) {
                cnt = table[cnt];
            } else {
                table[i++] = 0;
            }
        }
        return table;
    }

    private boolean isPalindrome(StringBuilder s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}