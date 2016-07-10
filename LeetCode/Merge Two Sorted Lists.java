/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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