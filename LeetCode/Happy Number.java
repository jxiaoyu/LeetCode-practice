/**
 * 题目给了提示，如果不以 1 终结的话，将会进入一个循环，所以用一个 hashmap 记录下历史，如果陷入循环就返回 false
 */
public class Solution {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        while (true) {
            int sum = getSquareSum(n);
            if (sum == 1) {
                return true;
            } else if (map.get(sum) != null && map.get(sum)) {
                return false;
            }
            map.put(sum, true);
            n = sum;
        }

    }

    private int getSquareSum(int num) {
        int sum = 0;
        do {
            sum += (num % 10) * (num % 10);
            num /= 10;
        } while (num > 0);
        return sum;
    }
}