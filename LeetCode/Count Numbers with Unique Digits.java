/**
 * https://www.hrwhisper.me/leetcode-count-numbers-unique-digits/
 */
public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) {
            return 1;
        }
        int uniq = 10, tmp;
        for(int i = 2; i <= n; i++) {
            tmp = 9;
            for(int j = 2; j <= i; j++) {
                tmp *= 9-j+2;
            }
            uniq += tmp;
        }
        return uniq;
    }
}