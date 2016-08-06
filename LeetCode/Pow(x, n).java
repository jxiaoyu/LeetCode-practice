/**
 * 二分，时间复杂度 lg(n)
 * 有细节值得注意。n 是负数的时候要转成 long 型再转正
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            return myPowHelper(1 / x, -(long)n);
        } else {
            return myPowHelper(x, n);
        }
    }
    
    private double myPowHelper(double x, long n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return x;
        }
        double result = myPowHelper(x, n / 2);
        if (n % 2 == 1) {
            return result * result * x;
        } else {
            return result * result;
        }
    }
}