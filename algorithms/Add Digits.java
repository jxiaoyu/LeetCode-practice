/**
 * 考循环，无难点
 */
public class Solution {
    public int addDigits(int num) {
        while (true) {
            if (num < 10) {
                return num;
            }
            num = digitsSum(num);
        }
    }

    private int digitsSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}