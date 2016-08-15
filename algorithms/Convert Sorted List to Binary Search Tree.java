/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
  * 这里的解法是从网上看来的 http://bangbingsyb.blogspot.com/2014/11/leetcode-convert-sorted-list-to-binary.html
  * 这里的思路也是递归，但是树却是自底向上构建的，跟前序遍历的递归思路比较像
  */
public class Solution {
    static ListNode h;
 
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;
 
        h = head;
        int len = getLength(head);
        return sortedListToBST(0, len - 1);
    }
 
    // get list length
    public int getLength(ListNode head) {
        int len = 0;
        ListNode p = head;
 
        while (p != null) {
            len++;
            p = p.next;
        }
        return len;
    }
 
    // build tree bottom-up
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;
 
        // mid
        int mid = (start + end) / 2;
 
        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);
 
        root.left = left;
        root.right = right;
 
        return root;
    }
}