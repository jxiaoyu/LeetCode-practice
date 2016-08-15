/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
 * 考察链表操作的基本功
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p = head, prev = null, dummy = new ListNode(0), q = dummy;
        boolean even = false;
        while (p != null) {
            if (even) {
                prev.next = p.next;
                q.next = p;
                q = p;
                p = p.next;
                q.next = null;
            } else {
                prev = p;
                p = p.next;
            }
            even = !even;
        }
        prev.next = dummy.next;
        return head;
    }
}