/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
/**
 * 考察了链表操作的基本功
 * 思路见 https://siddontang.gitbooks.io/leetcode-solution/content/linked_list/copy_list_with_random_pointer.html
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        RandomListNode p = head;
        while (p != null) {
            RandomListNode copy = new RandomListNode(p.label);
            copy.next = p.next;
            p.next = copy;
            p = copy.next;
        }
        
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head;
        RandomListNode newHead = head.next, q = newHead;
        while (q != null && q.next != null) {
            p.next = p.next.next;
            p = p.next;
            q.next = q.next.next;
            q = q.next;
        }
        p.next = null;
        return newHead;
    }
}