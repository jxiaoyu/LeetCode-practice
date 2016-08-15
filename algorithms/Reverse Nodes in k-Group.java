/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 考察链表操作的基本功，链表的这种考基本功的题要想一次写对还是挺难的，多总结易错点
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode p = head, tail, nextTail = null, prev = null, dummy = new ListNode(0);
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        if (count < k) {
            return head;
        }
        int index = 1;
        p = head;
        tail = dummy;
        while (index <= count - count % k) {
            if (index % k == 1) {
                prev = null;
                nextTail = p;
            } else if (index % k == 0) {
                tail.next = p;
                tail = nextTail;
            }
            index++;
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        tail.next = p;
        return dummy.next;
    }
}