/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * 在列表反转的基础上做些文章，不是很难
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 0;
        ListNode cur = head, prev = null, next = null, before = null, start = null;
        while (++i <= n) {
            if (i == m - 1) {
                before = cur;
            } else if (i == m) {
                start = cur;
            }
            
            if (i >= m) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            } else {
                cur = cur.next;
            }
        }
        if (before != null) {
            before.next = prev;
        }
        start.next = cur;
        if (m == 1) {
            return prev;
        } else {
            return head;
        }
    }
}