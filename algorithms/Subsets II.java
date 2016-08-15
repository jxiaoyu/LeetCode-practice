/**
 * 在 Subsets 的基础上改一下即可
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        List<List<Integer>> addList = new ArrayList<List<Integer>>();
        List<Integer> newAdd = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (newAdd.size() != 0 && newAdd.get(0) != nums[i]) {
                result.addAll(addList);
                addList.clear();
                newAdd.clear();
            }
            newAdd.add(nums[i]);
            for (List<Integer> list : result) {
                List<Integer> newOne = new ArrayList<Integer>(list);
                newOne.addAll(newAdd);
                addList.add(newOne);
            }
        }
        result.addAll(addList);
        return result;
    }
}