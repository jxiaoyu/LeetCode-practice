/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 这道题主要考察链表中 dummy head 的使用
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add = 0;
        ListNode dummy = new ListNode(0), prev = dummy;

        while (l1 != null || l2 != null) {
            int v1 = 0, v2 = 0;
            if (l1 != null) {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                v2 = l2.val;
                l2 = l2.next;
            }
            prev.next = new ListNode((v1 + v2 + add) % 10);
            add = (v1 + v2 + add) / 10;
            prev = prev.next;
        }
        if (add > 0) {
            prev.next = new ListNode(add);
        }
        return dummy.next;
    }
}