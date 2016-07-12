/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
 
/**
 * 做了 Copy List with Random Pointer 再来做这题就不难了。一样的思路
 */
public class Solution {
    
    private Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        flood(node);
        for (Map.Entry<UndirectedGraphNode, UndirectedGraphNode> entry : map.entrySet()) {
            for (UndirectedGraphNode neighbor : entry.getKey().neighbors) {
                entry.getValue().neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
    
    private void flood(UndirectedGraphNode node) {
        if (!map.containsKey(node)) {
            map.put(node, new UndirectedGraphNode(node.label));
            for (UndirectedGraphNode neighbor : node.neighbors) {
                flood(neighbor);
            }
        }
    }
}