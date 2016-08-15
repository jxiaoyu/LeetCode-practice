/**
 * 二分搜索树，这个问题就是个排序问题啊
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;
    // count 记录的是 本节点左树的节点个数+1
    int count = 1;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        TreeNode root = new TreeNode(nums[nums.length - 1]);
        res.add(0);
        for (int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public int insertNode(TreeNode root, int val) {
        int thisCount = 0;
        while (true) {
            if (val <= root.val) {
                root.count++;
                if (root.left == null) {
                    root.left = new TreeNode(val);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                if (root.right == null) {
                    root.right = new TreeNode(val);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return thisCount;
    }
}
