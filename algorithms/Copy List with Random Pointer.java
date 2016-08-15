/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

/**
 * 先复制节点的值，保存节点的映射关系
 * 然后根据映射关系，复制指针信息
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p = head;
        while (p != null) {
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }
        p = head;
        while (p != null) {
            RandomListNode q = map.get(p);
            if (p.next != null) {
                q.next = map.get(p.next);
            }
            if (p.random != null) {
                q.random = map.get(p.random);
            }
            p = p.next;
        }
        return map.get(head);
    }
}