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
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        while (head != null) {
            ListNode p = dummy;
            while (p.next != null && p.next.val < head.val) {
                p = p.next;
            }
            ListNode next = head.next, tmp = p.next;
            p.next = head;
            head.next = tmp;
            head = next;
        }
        return dummy.next;
    }
}