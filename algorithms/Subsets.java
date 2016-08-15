public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> addList = new ArrayList<List<Integer>>();

            for (List<Integer> list : result) {
                List<Integer> newOne = new ArrayList<Integer>(list);
                newOne.add(nums[i]);
                addList.add(newOne);
            }
            result.addAll(addList);
        }
        return result;
    }
}