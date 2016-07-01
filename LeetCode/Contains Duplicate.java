/**
 * 一开始用了 HashMap 来做，超时了，这里还是用 HashSet 更合适
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
     
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i: nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }
}