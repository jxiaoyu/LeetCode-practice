import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 这题和 Ugly Number II 类似，用 dp 的思路应该也是可以的
 * 不过这里把它当成 k lists merge 来做
 */
public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {

        PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });

        int[] seq = new int[n];
        int[] times = new int[primes.length];

        for (int i = 0; i < primes.length; i++) {
            queue.offer(new Node(primes[i], i));
        }
        queue.offer((new Node(1, -1)));

        int i = 0;
        while (true) {
            Node node = queue.poll();
            if (i == 0 || node.val != seq[i-1]) {
                if (i + 1 == n) {
                    return node.val;
                }
                seq[i++] = node.val;
            }
            if (node.index != -1) {
                queue.offer(new Node(seq[++times[node.index]] * primes[node.index], node.index));
            }
        }
    }

    class Node {
        int val;
        int index;

        public Node(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
}