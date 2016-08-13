/*
 * 直接的思路是 binary search + LinkedList 或者 BST
 * 这里的思路确实比较巧
 */
public class MedianFinder {

    Queue[] q = {new PriorityQueue(), new PriorityQueue(Collections.reverseOrder())};
    int i = 0;

    // Adds a number into the data structure.
    public void addNum(int num) {
        q[i].add(num);
        q[i^=1].add(q[i^1].poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        return ((int) (q[1].peek()) + (int) (q[i].peek())) / 2.0;
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();