public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        perm(new ArrrayList<>(), nums, perms);
        return perms;
    }

    public void perm(List<Integer> prefix, int[] nums, List<List<Integer>> perms) {
        if (prefix.size() == nums.length) {
            perms.add(new ArrayList<>(prefix));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (prefix.contains(nums[i])) 
                continue;
            prefix.add(nums[i]);
            perm(prefix, nums, perms);
            prefix.remove(prefix.size() - 1);
        }
    }
}