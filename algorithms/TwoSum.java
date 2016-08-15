public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer want = map.get(target - nums[i]);
            if (want != null) {
                return new int[]{want + 1, i + 1};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}