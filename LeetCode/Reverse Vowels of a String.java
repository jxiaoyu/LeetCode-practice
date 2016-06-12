/**
 * Created by river on 2016/6/12.
 */
public class Solution {

    public String reverseVowels(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }

        String vowels = "aeiouAEIOU";
        char[] c = s.toCharArray();

        int left = 0, right = s.length() - 1, sign = 0;

        while (left < right) {
            if (sign == 0) {
                if (vowels.indexOf(c[left]) >= 0) {
                    sign = 1;
                } else {
                    left++;
                }
                continue;
            } else if (sign == 1) {
                if (vowels.indexOf(c[right]) >= 0) {
                    char tmp = c[left];
                    c[left] = c[right];
                    c[right] = tmp;
                    left++;
                    right--;
                    sign = 0;
                } else {
                    right--;
                }
                continue;
            }
        }
        return new String(c);
    }
}