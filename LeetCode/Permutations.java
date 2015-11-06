public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> perms = new ArrayList<List<Integer>>();
        perms.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmpPerms = new ArrayList<List<Integer>>(perms);
            perms.clear();
            for (List<Integer> list : tmpPerms) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> tmp = new ArrayList<>(list);
                    tmp.add(j, nums[i]);
                    perms.add(tmp);
                }
            }
        }
        return perms;
    }
}