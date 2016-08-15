/**
 * 二分搜索的思路
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                list.add(nums[i]);
            } else if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (nums[i] > list.get(mid)) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                list.set(l, nums[i]);
            }
        }
        return list.size();
    }
}