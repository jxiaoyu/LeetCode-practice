public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        int prev = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == prev)
                continue;
            twoSum(nums, i + 1, -nums[i], triplets);
            prev = nums[i];
        }
        return triplets;
    }

    public void twoSum(int[] nums, int index, int target, List<List<Integer>> triplets) {
        Map<Integer, Integer> map = new HashMap<>();
        int prev = nums[index] - 1;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == prev) 
                continue;
            Integer want = map.get(target - nums[i]);
            if (want != null) {
                triplets.add(Arrays.asList(-target, target - nums[i], nums[i]));
                prev = nums[i];
            }
            map.put(nums[i], i);
        }
    }
}