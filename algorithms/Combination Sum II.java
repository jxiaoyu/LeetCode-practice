/**
 * Combination Sum 稍微改一下即可
 */
public class Solution {

    private List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, new ArrayList<>(), target);
        return list;
    }

    private void dfs(int[] candidates, int pos, List<Integer> res, int remain) {
        if (remain == 0) {
            list.add(new ArrayList(res));
        }
        if (remain < 0 || pos >= candidates.length) {
            return;
        }
        Integer prev = null;
        for (int i = pos; i < candidates.length; i++) {
            if (prev != null && candidates[i] == prev) {
                continue;
            }
            res.add(candidates[i]);
            dfs(candidates, i + 1, res, remain - candidates[i]);
            res.remove(res.size() - 1);
            prev = candidates[i];
        }
    }
}