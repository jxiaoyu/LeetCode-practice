/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode lastHead = root, lastCurrent = lastHead, head = root.left, current = head;
        while (head != null) {
            while (true) {
                current.next = lastCurrent.right;
                current = current.next;
                lastCurrent = lastCurrent.next;
                if (lastCurrent != null) {
                    current.next = lastCurrent.left;
                    current = current.next;
                } else {
                    current.next = null;
                    lastHead = head;
                    lastCurrent = lastHead;
                    head = head.left;
                    current = head;
                    break;
                }
            }
        }
    }
}