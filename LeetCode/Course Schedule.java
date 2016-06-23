import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 一开始的想法是很朴素的：从根结点出发，一层层往下走，看能不能遍历所有结点。当然这里不只一个根结点，其实无所谓。
 * 再一想，这其实跟树的 bfs 很像，借鉴下相关思想，处理一下环的问题就可以了
 */

/**
 * 另外最近做了不少树的题目，发现多数时候不是从根结点入手，就是从叶结点入手（比如 Verify Preorder Serialization of a Binary Tree 和 Minimum Height Trees）
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            nodes[prerequisites[i][0]].outers.add(prerequisites[i][1]);
            nodes[prerequisites[i][1]].indegree++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].indegree == 0 && nodes[i].outers.size() == 0) {
                numCourses--;
            } else if (nodes[i].indegree == 0) {
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int i = queue.remove();
            nodes[i].visited = true;
            numCourses--;
            for (Integer o : nodes[i].outers) {
                if (nodes[o].visited) {
                    return false;
                } else if (nodes[o].indegree == 1) {
                    nodes[o].visited = true;
                    queue.offer(o);
                }
                nodes[o].indegree--;
            }
        }
        if (numCourses > 0) {
            return false;
        } else {
            return true;
        }
    }

    class Node {
        int indegree = 0;
        List<Integer> outers = new ArrayList<Integer>();
        boolean visited = false;
    }
}