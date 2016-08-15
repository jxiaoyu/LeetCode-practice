public class Solution {
    public boolean isUgly(int num) {

        if (num <= 1) {
            return false;
        }

        int[] factors = {2, 3, 5};

        while (num != 1) {
            boolean flag = false;
            for (int i = 0; i < factors.length; i++) {
                if (num % factors[i] == 0) {
                    num /= factors[i];
                    flag = true;
                }
            }
            if (!flag) {
                return flag;
            }
        }
        return true;
    }
}