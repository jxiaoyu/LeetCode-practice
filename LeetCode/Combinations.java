import java.util.ArrayList;
import java.util.List;

/**
 * Created by river on 2016/6/13.
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        /**
         * 注意1：用 dfs 时间复杂度 O(n^k)
         * 开始觉得时间复杂度是指数，会超时。但是后来发现这种问题的时间复杂度没法做到多项式
         */
        dfs(n, k, -1, new ArrayList<Integer>());
        return combs;
    }

    private List<List<Integer>> combs = new ArrayList<List<Integer>>();

    private void dfs(int n, int depth, int last, List<Integer> seq) {

        if (seq.size() == depth) {
            combs.add(new ArrayList<Integer>(seq));
            return;
        }

        for (int i = last + 1; i < n; i++) {
            seq.add(i + 1);
            dfs(n, depth, i, seq);
            seq.remove(seq.size() - 1);
        }
    }
}