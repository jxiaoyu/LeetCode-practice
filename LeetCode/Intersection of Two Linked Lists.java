/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = ListLength(headA);
        int lengthB = ListLength(headB);
        int offset = Math.abs(lengthA - lengthB);
        
        while (lengthA != lengthB) {
            if (lengthA > lengthB) {
                headA = headA.next;
                lengthA--;
            } else {
                headB = headB.next;
                lengthB--;
            }
        }
        
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            } else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }
    
    private int ListLength(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }
        return len;
    }
}