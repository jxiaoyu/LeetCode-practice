public class Solution {

    public String getPermutation(int n, int k) {

        int fac = 1;
        for (int i = 1; i < n; i++) {
            fac *= i;
        }

        StringBuilder builder = new StringBuilder();
        boolean[] used = new boolean[n];
        // 注意1：计数的问题
        k = k - 1;

        for (int i = 0; i < n; i++) {
            int d = k / fac;
            k = k % fac;
            for (int j = 0; j < n; j++) {
                if (!used[j] && d == 0) {
                    builder.append(j + 1);
                    used[j] = true;
                    break;
                } else if (!used[j]) {
                    d--;
                }
            }

            if (i < n - 1) {
                fac /= (n - i - 1);
            }
        }

        return builder.toString();
    }
}