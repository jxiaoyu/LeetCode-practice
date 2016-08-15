import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> in = new LinkedList<>();
        Queue<TreeNode> out = new LinkedList<>();
        List<Integer> sublist = new ArrayList<>();
        out.add(root);

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