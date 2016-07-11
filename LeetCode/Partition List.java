/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 考察链表 dummy head 的使用
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyL = new ListNode(0), dummyR = new ListNode(0), l = dummyL, r = dummyR;
        while (head != null) {
            if (head.val < x) {
                l.next = head;
                l = head;
            } else {
                r.next = head;
                r = head;
            }
            head = head.next;
        }
        // close the list
        r.next = null;
        l.next = dummyR.next;
        return dummyL.next;
    }
}