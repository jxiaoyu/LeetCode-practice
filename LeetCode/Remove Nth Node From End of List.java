/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(0), p = head;
        pre.next = head;
        int i = 0;
        while (p != null) {
            p = p.next;
            if (i == n) {
                pre = pre.next;
            } else {
                i++;
            }
        }
        if (pre.next == head) {
            head = head.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}