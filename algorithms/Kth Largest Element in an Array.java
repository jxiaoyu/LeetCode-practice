/**
 * 时间复杂度 nlg(k)
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i: nums) {
            q.offer(i);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }
}