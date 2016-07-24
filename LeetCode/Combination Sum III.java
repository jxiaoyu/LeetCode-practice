/**
 * 在 Combination Sum II 的基础上改下
 */
public class Solution {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        dfs(candidates, 0, new ArrayList<>(), k, n);
        return list;
    }

    private void dfs(int[] candidates, int pos, List<Integer> res, int len, int remain) {
        if (remain == 0 && res.size() == len) {
            list.add(new ArrayList(res));
        }
        if (remain < 0 || res.size() >= len) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            res.add(candidates[i]);
            dfs(candidates, i + 1, res, len, remain - candidates[i]);
            res.remove(res.size() - 1);
        }
    }
}