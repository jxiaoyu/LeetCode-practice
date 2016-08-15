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
 * 在 Binary Tree Level Order Traversal 的基础上修改下即可
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> in = new LinkedList<>();
        Queue<TreeNode> out = new LinkedList<>();
        List<Integer> sublist = new ArrayList<>();
        out.add(root);
        boolean reverse = false;

        while (!out.isEmpty()) {
            TreeNode p = out.poll();
            sublist.add(p.val);
            if (p.left != null) {
                in.offer(p.left);
            }
            if (p.right != null) {
                in.offer(p.right);
            }
            if (out.isEmpty()) {
                if (reverse) {
                    Collections.reverse(sublist);
                }
                reverse = !reverse;
                list.add(sublist);
                sublist = new ArrayList<Integer>();
                Queue<TreeNode> tmp = out;
                out = in;
                in = tmp;
            }
        }
        return list;
    }
}