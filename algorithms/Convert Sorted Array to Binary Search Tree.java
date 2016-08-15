/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
/**
 * 已经做了蛮多这种生成树的问题了，比较关键的还是找到根节点，找到根结点才能递归成子树
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode sortedArrayToBST(int[] nums, int s, int e) {
        if (s > e) {
            return null;
        }
        int m = s + (e - s) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = sortedArrayToBST(nums, s, m - 1);
        root.right = sortedArrayToBST(nums, m + 1, e);
        return root;
    }
}