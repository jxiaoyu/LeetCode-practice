public class Solution {
    public int thirdMax(int[] nums) {
        if (nums == null) {
            return 0;
        }
        Queue<Integer> queue = new PriorityQueue<>(capacity);
        for (int num : nums) {
            if ((queue.size() < capacity || num > queue.peek()) && !queue.contains(num)) {
                queue.offer(num);
            }
            if (queue.size() > capacity) {
                queue.poll();
            }
        }
        
        if (queue.size() == capacity) {
            return queue.peek();
        }
        int result = 0;
        while (queue.size() > 0) {
            result = queue.poll();
        }
        return result;
    }
    
    private final int capacity = 3;
}