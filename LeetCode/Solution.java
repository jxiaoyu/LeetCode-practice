/**
 * 一开始想用 dp 来做，内存和时间超出了，找到数学规律才行
 */
public class Solution {
    public boolean canWinNim(int n) {
        return n % 4 > 0;
    }
}