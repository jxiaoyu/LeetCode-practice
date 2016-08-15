/**
 * dfs
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        dfs(n, new ArrayList<Integer>());
        return result;
    }

    private List<List<String>> result = new ArrayList<List<String>>();

    private void dfs(int n, List<Integer> posList) {
        if (posList.size() == n) {
            List<String> list = new ArrayList<String>();
            char[] row = new char[n];
            for (Integer index : posList) {
                for (int i = 0; i < n; i++) {
                    if (i == index) {
                        row[i] = 'Q';
                    } else {
                        row[i] = '.';
                    }
                }
                list.add(new String(row));
            }
            result.add(list);
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