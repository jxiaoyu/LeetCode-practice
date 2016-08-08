/**
 * 理解不了的时候举几个例子
 * 比如：2,3,1,4  2,3,1,0,4  2,3,1,2,4
 */
public class Solution {
    public boolean increasingTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
     
        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];
     
            if (x >= z) {
                x = z;
            } else if (y >= z) {
                y = z;
            } else {
                return true;
            }
        }
     
        return false;
    }
}s