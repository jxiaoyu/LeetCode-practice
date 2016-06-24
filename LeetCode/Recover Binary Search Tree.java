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
 * 对于 bst，中序遍历的结果就是从小到大排列的。所以中序遍历，找出乱序的节点即可
 * 但是用栈或递归的方式遍历，都需要 O(n) 的空间。O(1) 的空间的话要改中序遍历的的方法，没仔细研究
 */
public class Solution {
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        TreeNode pre = null, first = null, second = null;
        while (!stack.empty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (pre == null) {
                    pre = p;
                    continue;
                }
                if (first == null) {
                    if (p.val < pre.val) {
                        first = pre;
                        second = p;
                    }
                } else {
                    if (p.val < pre.val) {
                        second = p;
                    }
                }
                pre = p;
                p = p.right;
            }
        }
        int tmp = second.val;
        second.val = first.val;
        first.val = tmp;
        return;
    }
}