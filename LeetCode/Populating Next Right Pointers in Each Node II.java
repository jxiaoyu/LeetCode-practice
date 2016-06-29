/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
 
/**
 * 这题比 Populating Next Right Pointers in Each Node 更通用
 * 想明白了也很简单，遍历上层结点，连接本层结点
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        TreeLinkNode lastHead = root, lastCurrent = lastHead, head = null, current = null;
        while (lastHead != null) {
            while (lastCurrent != null) {
                if (lastCurrent.left != null) {
                    if (head == null) {
                        head = current = lastCurrent.left;
                    } else {
                        current.next = lastCurrent.left;
                        current = current.next;
                    }
                }
                if (lastCurrent.right != null) {
                    if (head == null) {
                        head = current = lastCurrent.right;
                    } else {
                        current.next = lastCurrent.right;
                        current = current.next;
                    }
                }
                lastCurrent = lastCurrent.next;
            }
            lastHead = head;
            lastCurrent = lastHead;
            head = current = null;
        }
    }
}