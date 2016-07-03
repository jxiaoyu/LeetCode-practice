public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || k <= 0 || t < 0) {
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long cur = (long)nums[i];
            long left = (long)(cur - t);
            long right = (long)(cur + t + 1);
            SortedSet<Long> sub = set.subSet(left, right);
            if (sub.size() > 0) {
                return true;
            }
            set.add(cur);
            if (i >= k) {
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}