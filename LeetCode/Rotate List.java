/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 考察链表的基本功
 * 跟 Rotate Array 的思路是相近的
 */
public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int count = 1, i = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head, tail;
        while (p.next != null) {
            count++;
            p = p.next;
        }
        k %= count;
        if (k <= 0) {
            return head;
        }
        tail = p;
        p = dummy;
        while (i < count - k) {
            p = p.next;
            i++;
        }
        ListNode tmp = dummy.next;
        dummy.next = p.next;
        tail.next = tmp;
        p.next = null;
        return dummy.next;
    }
}