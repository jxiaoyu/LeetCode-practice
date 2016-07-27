/**
 * 这是看的别人的思路，正向怎么想都想不通最后 i 位置的含义
 * 后来逆向想了下，如果 [0, x] 这段是回文，i 最后肯定停在 x + 1 处。所以最后 i 的位置肯定大于最大回文的位置
 */
public class Solution {
    public String shortestPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
            }
            j--;
        }
     
        if (i == s.length()) {
            return s;
        }
        
        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        String mid = shortestPalindrome(s.substring(0, i));
        return prefix + mid + suffix;
    }
}