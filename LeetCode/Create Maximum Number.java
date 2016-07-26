/**
 * 最开始的思路是 dfs，但是超时了
 * 是时候总结下了：
 * 1. 对于那些像 Combination Sum 那种需要求出所有符合要求的解的集合的时候，遍历是必须的。dfs 很合适
 * 2. 但是对于像本题这种并非求所有解，而是求最优解的情形，遍历就不一定是好的方法
 */
public class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); i++) {
            int[] sub1 = maxSubArray(nums1, i);
            int[] sub2 = maxSubArray(nums2, k - i);
            int[] tmp = new int[k];
            int p1 = 0, p2 = 0;
            for (int j = 0; j < k; j++) {
                if (compare(sub1, p1, sub2, p2) < 0) {
                    tmp[j] = sub2[p2++];
                } else {
                    tmp[j] = sub1[p1++];
                }
            }

            if (compare(res, 0, tmp, 0) < 0) {
                res = tmp;
            }
        }
        return res;
    }

    private int compare(int[] nums1, int p1, int[] nums2, int p2) {
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] != nums2[p2]) {
                return nums1[p1] - nums2[p2];
            } else {
                p1++;
                p2++;
            }
        }
        return (nums1.length - p1) - (nums2.length - p2);
    }

    private int[] maxSubArray(int[] nums, int len) {
        int[] res = new int[len];
        // 遍历时需要回溯，栈是比较合适的数据结构。思路像 Remove Duplicate Letters
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.empty() && nums[i] > stack.peek() && nums.length - i + stack.size() - 1 >= len) {
                stack.pop();
            }
            if (stack.size() < len) {
                stack.push(nums[i]);
            }
        }
        int i = len - 1;
        while (!stack.empty()) {
            res[i--] = stack.pop();
        }
        return res;
    }
}