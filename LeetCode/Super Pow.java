/**
 * Basic math knowlege:
 * (ab)%k=(a%k)(b%k)%k
 * (abc)%k=(a%k)(b%k)(c%k)%k
 */
public class Solution {
    private int base = 1337;

    public int superPow(int a, int[] b) {
        return helper(a, b, b.length-1);
    }

    private int helper(int a,int[]b,int endidx){
        if (endidx == -1) {
            return 1;
        }
        int lastDigit = b[endidx];
        return powmod(helper(a, b, endidx - 1), 10) * powmod(a, lastDigit) % base;
    }
    private int powmod(int a,int k) {
        a %= base;
        int result = 1;
        for (int i = 0; i < k; i++) {
            result = (result * a) % base;
        }
        return result;
    }
}