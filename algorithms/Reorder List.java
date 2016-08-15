/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
 * 一开始的思路遍历，拿到链表的末尾节点插入当前位置。因为拿尾节点又要遍历，所以时间复杂度是 O(n^2)，超时了
 * 
 * 从考点的角度来看，这是一道链表的好题。分别考到以下经典考点：
 * 1. 取中间节点
 * 2. 链表反转
 * 3. 链表合并
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode mid = getMiddleNode(head);
        ListNode l1 = head, l2 = reverseList(mid.next);
        mid.next = null;
        
        while (l2 != null) {
            ListNode tmp1 = l1.next, tmp2 = l2.next;
            l1.next = l2;
            l2.next = tmp1;
            l1 = tmp1;
            l2 = tmp2;
        }
    }
    
    private ListNode getMiddleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode prev = null, next = null;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}