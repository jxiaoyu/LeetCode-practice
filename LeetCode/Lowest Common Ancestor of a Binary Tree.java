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
 * 递归的解法，注意边界情况的含义
 * 一开始的想法是按 bfs 给每个节点编号。找到 p ,q 的编号
 * while (m != n) {
 *   if (m > n) {
 *     m /= 2;
 *   } else {
 *     n /= 2;
 *   }
 * }
 * 但是到后面的用例 m,n 太大了，用 long 型都溢出了。毕竟是指数啊
 */

public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }
}