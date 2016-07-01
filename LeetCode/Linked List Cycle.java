/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/**
 * 链表的经典问题
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode quick = head, slow = head;
        do {
            slow = slow.next;
            if (quick == null || quick.next == null) {
                return false;
            } else {
                quick = quick.next.next;
            }
        } while (slow != quick);
        return true;
    }
}