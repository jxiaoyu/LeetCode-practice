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
 * 关键在于能把问题转换为一个递归问题
 */
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie) {
        if (ps > pe) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ps]);
        for (int i = is; i <= ie; i++) {
            if (inorder[i] == root.val) {
                root.left = buildTree(preorder, ps + 1, ps + i - is, inorder, is, i - 1);
                root.right = buildTree(preorder, ps + i - is + 1, pe, inorder, i + 1, ie);
                break;
            }
        }
        return root;
    }
}