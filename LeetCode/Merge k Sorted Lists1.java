import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by jxiao on 2016/6/11.
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // 技巧1：PriorityQueue 是用二叉堆实现的。入列的时间复杂度是 lgn
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val -l2.val;
            }
        });

        ListNode head = new ListNode(0);
        ListNode p = head;

        for (ListNode list: lists) {
            if (list != null) {
                queue.offer(list);
            }
        }

        while (!queue.isEmpty()) {
            ListNode n = queue.poll();
            p.next = n;
            p = p.next;

            if (n.next != null) {
                queue.offer(n.next);
            }
        }

        return head.next;
    }
}
