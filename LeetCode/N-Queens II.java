/**
 * dfs
 */
public class Solution {
    public int totalNQueens(int n) {
        dfs(n, new ArrayList<Integer>());
        return count;
    }

    private int count = 0;

    private void dfs(int n, List<Integer> posList) {
        if (posList.size() == n) {
            count++;
        }

        boolean[] flags = new boolean[n];
        for (int i = 0; i < posList.size(); i++) {
            int pos = posList.get(i);
            int delta = posList.size() - i;
            flags[pos] = true;
            if (pos - delta >= 0) {
                flags[pos-delta] = true;
            }
            if (pos + delta < n) {
                flags[pos+delta] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (flags[i]) {
                continue;
            }
            posList.add(i);
            dfs(n, posList);
            posList.remove(posList.size() - 1);
        }
    }
}