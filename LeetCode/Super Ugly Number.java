/**
 * PriorityQueue
 * 像 k lists merge 的思路
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
        Node node = null;
        while (i < n) {
            node = queue.poll();
            if (i == 0 || node.val != seq[i-1]) {
                seq[i++] = node.val;
            }
            if (node.index != -1) {
                queue.offer(new Node(seq[++times[node.index]] * primes[node.index], node.index));
            }
        }
        return node.val;
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
