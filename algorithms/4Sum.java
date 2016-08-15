public class Solution {
     public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        kSum(nums, 4, 0, target, new ArrayList<Integer>(), list);
        return list;
    }

    private void kSum(int[] nums, int k, int index, int target, List<Integer> prefix, List<List<Integer>> list) {
        if (k > 2) {
            int prev = 0;
            for (int i = index; i < nums.length - k + 1; i++) {
                if (i != index && nums[i] == prev)
                    continue;
                prefix.add(nums[i]);
                kSum(nums, k - 1, i + 1, target - nums[i], prefix, list);
                prefix.remove(prefix.size() - 1);
                prev = nums[i];
            } 
        }
        else {
            twoSum(nums, index, target, prefix, list);
        }
    }

    private void twoSum(int[] nums, int index, int target, List<Integer> prefix, List<List<Integer>> list) {
        int k = index, l = nums.length - 1;
        int prev = nums[k] - 1;
        while (k < l) {
            if (nums[k] == prev) {
                k++;
                continue;
            }
            if (nums[k] + nums[l] > target) {
                l--;
            } else if (nums[k] + nums[l] < target) {
                k++;
            } else {
                List<Integer> solution = new ArrayList<>(prefix);
                solution.add(nums[k]);
                solution.add(nums[l]);
                list.add(solution);
                prev = nums[k];
                k++;
                l--;
            }
        }
    }

    // 没想到这种写法居然超时了
    private void twoSum(int[] nums, int index, int target, List<Integer> prefix, List<List<Integer>> list) {
        Map<Integer, Integer> map = new HashMap<>();
        int prev = nums[index] - 1;
        for (int i = index; i < nums.length; i++) {
            if (nums[i] == prev)
                continue;
            Integer want = map.get(target - nums[i]);
            if (want != null) {
                List<Integer> solution = new ArrayList<>(prefix);
                solution.add(target - nums[i]);
                solution.add(nums[i]);
                list.add(solution);
                prev = nums[i];
            }
            map.put(nums[i], i);
        }
    }
}