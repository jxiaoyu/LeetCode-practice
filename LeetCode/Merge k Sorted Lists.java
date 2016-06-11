public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return helper(lists, 0, lists.length - 1);
    }

    public ListNode helper(ListNode[] list, int l, int r) {
        if (l == r) {
            return list[l];
        }
        int m = (l + r) / 2;
        return mergeTwoList(helper(list, l, m), helper(list, m + 1, r));
    }

    public ListNode mergeTwoList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        dummy.next = a;
        ListNode prev = dummy;
        while (a != null && b != null) {
            if (a.val < b .val) {
                prev = a;
                a = a.next;
            } else {
                prev.next = b;
                prev = b;
                b = b.next;
                prev.next = a;
            }
        }

        if (a == null) {
            prev.next = b;
        }
        return dummy.next;
    }
}