/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * 一些相似的题型该总结下了
 * Linked List Cycle: 判断链表是否有环
 * Linked List Cycle II: 求链表环的起点
 * Intersection of Two Linked Lists: 求两个链表的交点。可以把这个问题的一条链表想象成环，然后就变成上面的问题了
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        ListNode slow = head.next, fast = head.next.next;
        while (slow != fast) {
            slow = slow.next;
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}