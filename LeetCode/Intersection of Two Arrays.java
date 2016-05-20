import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by river on 2016/5/21.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {

        Map<Integer, Boolean> map = new HashMap();
        List<Integer> arr = new ArrayList();

        for (int i = 0; i < nums1.length; i ++) {
            map.put(nums1[i], true);
        }

        for (int i = 0; i < nums2.length; i++) {

            Boolean removed = map.remove(nums2[i]);
            if (removed != null && removed) {
                arr.add(nums2[i]);
            }
        }

        int[] res = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
    }
}