/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
 
/**
 * 思路很简单、直接，不知道为什么是 hard
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        int i = 0;
        while (i + 1 < intervals.size()) {
            Interval cur = intervals.get(i), next = intervals.get(i + 1);
            if (next.start <= cur.end) {
                cur.end = Math.max(cur.end, next.end);
                intervals.remove(i + 1);
            } else {
                i++;
            }
        }
        return intervals;
    }
}