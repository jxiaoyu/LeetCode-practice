import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在 Course Schedule 的基础上这题就没什么难度了，修改一下就可以了
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] arr = new int[numCourses];
        Node[] nodes = new Node[numCourses];
        for (int i = 0; i < numCourses; i++) {
            nodes[i] = new Node();
        }
        for (int i = 0; i < prerequisites.length; i++) {
            nodes[prerequisites[i][0]].outers.add(prerequisites[i][1]);
            nodes[prerequisites[i][1]].indegree++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i].indegree == 0 && nodes[i].outers.size() == 0) {
                arr[--numCourses] = i;
            } else if (nodes[i].indegree == 0) {
                nodes[i].visited = true;
                queue.offer(i);
            }
        }
        while (queue.size() > 0) {
            int i = queue.remove();
            arr[--numCourses] = i;
            for (Integer o : nodes[i].outers) {
                if (nodes[o].visited) {
                    return new int[0];
                } else if (nodes[o].indegree == 1) {
                    nodes[o].visited = true;
                    queue.offer(o);
                }
                nodes[o].indegree--;
            }
        }
        if (numCourses > 0) {
            return new int[0];
        } else {
            return arr;
        }
    }

    class Node {
        int indegree = 0;
        List<Integer> outers = new ArrayList<Integer>();
        boolean visited = false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {};
        s.findOrder(2, a);
    }
}