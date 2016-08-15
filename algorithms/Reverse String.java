/**
 * Created by river on 2016/6/12.
 */
public class Solution {
    public String reverseString(String s) {

        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] c = s.toCharArray();
        int left = 0, right = c.length - 1;

        while (left < right) {
            char tmp = c[left];
            c[left] = c[right];
            c[right] = tmp;
            left++;
            right--;
        }
        return new String(c);
    }
}