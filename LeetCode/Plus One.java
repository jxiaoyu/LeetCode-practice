/**
 * 考察数组的基本操作，无难点
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int add = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + add;
            digits[i] = val % 10;
            add = val / 10;
        }
        if (add == 0) {
            return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = add;
        for (int i = 1; i < newDigits.length; i++) {
            newDigits[i] = digits[i-1];
        }
        return newDigits;
    }
}