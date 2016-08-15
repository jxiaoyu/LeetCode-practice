/**
 * 思路是所求节点是在最长路径的中间，把叶子节点一层层去掉，最后剩下的就是所求节点
 * 当所有的数都落在一定范围的时候，可以用数组或ArrayList这样的数据结构，比HashMap快
 */
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);
        List<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>(n);
        for (int i = 0; i < n; i++) {
            list.add(new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        List<Integer> leaves = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (list.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<Integer>();
            for (Integer leaf : leaves) {
                int j = list.get(leaf).iterator().next();
                list.get(j).remove(leaf);
                if (list.get(j).size() == 1) {
                    newLeaves.add(j);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}