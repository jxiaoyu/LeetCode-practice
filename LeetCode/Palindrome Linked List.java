/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
/**
 * 综合应用了链表反转和寻找中间节点的考点
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode quick = head, slow = head;
        while (quick != null && quick.next != null && quick.next.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        
        ListNode p;
        if (quick != null && quick.next != null) {
            p = slow.next;
        } else {
            p = slow;
        }
        
        p = reverseList(p);
        
        while (p != null) {
            if (head.val != p.val) {
                return false;
            }
            head = head.next;
            p = p.next;
        }
        return true;
    }
    
    private ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}