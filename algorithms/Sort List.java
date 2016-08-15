/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * 归并排序
 * 考点是 mergeTwoLists，这个已经在 Merge Two Sorted Lists 和 Merge k Sorted Lists 里考过了
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, quick = head;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        ListNode r = slow.next;
        slow.next = null;
        return mergeTwoLists(sortList(head), sortList(r));
    }
    
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2 .val) {
                prev = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                prev = l2;
                l2 = l2.next;
                prev.next = l1;
            }
        }

        if (l1 == null) {
            prev.next = l2;
        }
        return dummy.next;
    }
}