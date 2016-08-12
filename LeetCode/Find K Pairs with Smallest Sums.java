/**
 * PriorityQueue
 * 和 Super Ugly Number 放在一起看
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) {
            return Collections.emptyList();
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>(nums2.length);
        //Initialize the heap.
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new Tuple(0, i, nums1[0] + nums2[i]));
        }

        List<Tuple> l = new ArrayList<>(k);

        int min = Math.min(k, nums1.length * nums2.length);
        for (int i = 0; i < min; i++) {

            Tuple t = pq.poll();
            l.add(t);

            if (t.i1 + 1 < nums1.length) {
                //The next possible smallest pair is {t.i1+1, t.i2}.
                pq.offer(new Tuple(t.i1 + 1, t.i2, nums1[t.i1 + 1] + nums2[t.i2]));
            }
        }
        List<int[]> r = new ArrayList<>(l.size());
        for (Tuple t : l) {
            r.add(new int[]{nums1[t.i1], nums2[t.i2]});
        }
        return r;
    }

    static class Tuple implements Comparable<Tuple> {
        int i1; //index in the first array.
        int i2; //index in the seconde array.
        int sum;

        Tuple(int i1, int i2, int sum) {
            this.i1 = i1;
            this.i2 = i2;
            this.sum = sum;

        }

        @Override
        public int compareTo(Tuple another) {
            return sum - another.sum;
        }
    }
}