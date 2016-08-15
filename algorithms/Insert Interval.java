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
 * 很朴素的思路，就是分情况讨论
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        Interval first = intervals.get(0);
        Interval last = intervals.get(intervals.size() - 1);

        if (newInterval.end < first.start) {
            intervals.add(0, newInterval);
            return intervals;
        }
        if (newInterval.start > last.end) {
            intervals.add(newInterval);
            return intervals;
        }

        int left = -1, right = -1, prev = -1;
        for (int i = 0; i < intervals.size(); i++) {
            Interval in = intervals.get(i);
            if (newInterval.start >= in.start && newInterval.start <= in.end) {
                left = i;
            } else if (newInterval.start < in.start && (prev == -1 || newInterval.start > intervals.get(prev).end)) {
                left = i;
            }

            if (newInterval.end >= in.start && newInterval.start <= in.end) {
                right = i;
            } else if (newInterval.end < in.start && (prev == -1 || newInterval.end > intervals.get(prev).end)) {
                right = prev;
            }
            prev = i;
        }

        if (right < left) {
            intervals.add(left, newInterval);
            return intervals;
        }

        Interval leftInterval = intervals.get(left);
        leftInterval.start = Math.min(newInterval.start, leftInterval.start);

        Interval rightInterval = intervals.get(right);
        rightInterval.end = Math.max(newInterval.end, rightInterval.end);

        if (left == right) {
            return intervals;
        }

        int i = left + 1;
        for (; i < right; i++) {
            intervals.remove(left + 1);
        }
        leftInterval.end = intervals.remove(left + 1).end;

        return intervals;
    }
}