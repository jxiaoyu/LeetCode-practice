import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 把问题转化为 LIS 问题
 */
public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        });

        List<Integer> list = new ArrayList<Integer>();
        list.add(envelopes[0][1]);
        for (int i = 1; i < envelopes.length; i++) {
            if (envelopes[i][1] > list.get(list.size() - 1)) {
                list.add(envelopes[i][1]);
            } else {
                int l = 0, r = list.size() - 1;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (list.get(mid) >= envelopes[i][1]) {
                        r = mid;
                    } else {
                        l = mid + 1;
                    }
                }
                list.set(l, envelopes[i][1]);
            }
        }
        return list.size();
    }
}