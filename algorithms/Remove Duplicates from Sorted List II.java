/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 考察链表操作的基本功，考虑清楚边界情况
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                int val = head.val;
                while (head != null && head.val == val) {
                    head = head.next;
                }
                continue;
            }
            prev.next = head;
            prev = head;
            head = head.next;
            prev.next = null;
        }
        return dummy.next;
    }
}