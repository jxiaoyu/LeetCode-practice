public class Solution {
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        int count = 0;
        int copyN = n;
        for (int weight = 1; n > 0; weight *= 10) {
            int complete = n / 10;
            int lsb = n % 10;
            if (lsb < 1) {
                count += weight * complete;
            } else if (lsb > 1) {
                count += weight * (complete + 1);
            } else {  // lsb == 1
                count += weight * complete + copyN % weight + 1;
            }
            n = complete;
        }
        return count;
    }
}