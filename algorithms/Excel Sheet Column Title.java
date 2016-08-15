/**
 * Excel Sheet Column Number 的对称题
 */
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            if (n % 26 == 0) {
                builder.append('Z');
                n = n / 26 -1;
            } else {
                builder.append((char)(n % 26 - 1 + 'A'));
                n /= 26;
            }
        }
        return builder.reverse().toString();
    }
}