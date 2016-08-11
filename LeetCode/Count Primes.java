/**
 * 这题主要考察质数的判断方法
 * 判断 n 是不是质数，最先想到从 2 到 n -1 判断是否能整除。加计数这题的时间复杂度 O(n^2)
 * 优化一下，不需要到 n-1 只需到 n^0.5，时间复杂度 O(n^1.5)
 * 但还是超时
 * 看提示用筛法时间复杂度更小
 * 开始用 HashMap 来记录筛出来的数，过不了，看提示用数组来记录，过了
 */
public class Solution {
    public int countPrimes(int n) {
        if (n <= 1) {
            return 0;
        }
        return n -1 - sieve(n);
    }

    private int sieve(int n) {
        boolean[] notPrime = new boolean[n];
        notPrime[1] = true;
        for (int i = 2; i * i < n; i++) {
            for (int j = i; i * j < n; j++) {
                if (!notPrime[i*j]) {
                    notPrime[i*j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (notPrime[i]) {
                count++;
            }
        }
        return count;
    }
}