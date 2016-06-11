import java.util.*;

/**
 * Created by jxiao on 2016/6/11.
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prev = null;
        ListNode head = null;
        while(l1 != null || l2 != null) {
            ListNode newNode = null;
            if (l1 == null) {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            }
            else if (l2 == null) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            else if (l1.val < l2.val) {
                newNode = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                newNode = new ListNode(l2.val);
                l2 = l2.next;
            }
            if (prev == null) {
                head = newNode;
            }
            else {
                prev.next = newNode;
            }
            prev = newNode;
        }
        return head;
    }
}