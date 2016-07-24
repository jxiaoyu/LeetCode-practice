/**
 * 在 Combination Sum III 的基础上改一下
 */
public class Solution {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(n, 1, new ArrayList<>(), k);
        return list;
    }

    private void dfs(int n, int pos, List<Integer> res, int len) {
        if (res.size() == len) {
            list.add(new ArrayList(res));
            return;
        }
        for (int i = pos; i <= n; i++) {
            res.add(i);
            dfs(n, i + 1, res, len);
            res.remove(res.size() - 1);
        }
    }
}