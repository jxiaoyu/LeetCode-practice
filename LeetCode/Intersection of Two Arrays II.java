import java.util.*;

/**
 * Created by jxiao on 2016/6/11.
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            Integer val = map.get(nums1[i]);
            if (val == null) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], val + 1);
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            Integer val = map.get(nums2[i]);
            if (val == null || val == 0) {
                continue;
            }
            list.add(nums2[i]);
            map.put(nums2[i], val - 1);
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}
