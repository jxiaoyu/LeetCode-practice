public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> perms = new ArrayList<List<Integer>>();
        perms.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tmpPerms = new ArrayList<List<Integer>>(perms);
            Map<List<Integer>, Boolean> map = new HashMap<List<Integer>, Boolean>();
            perms.clear();
            for (List<Integer> list : tmpPerms) {
                for (int j = 0; j <= list.size(); j++) {
                    List<Integer> tmp = new ArrayList<Integer>(list);
                    tmp.add(j, nums[i]);
                    Boolean had = map.get(tmp);
                    if (had == null || !had) {
                        perms.add(tmp);
                        map.put(tmp, true);
                    }
                }
            }
        }
        return perms;
    }
}